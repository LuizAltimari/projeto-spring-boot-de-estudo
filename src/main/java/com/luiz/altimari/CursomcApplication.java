package com.luiz.altimari;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luiz.altimari.domain.Cidade;
import com.luiz.altimari.domain.Cliente;
import com.luiz.altimari.domain.Endereco;
import com.luiz.altimari.domain.Estado;
import com.luiz.altimari.domain.Pagamento;
import com.luiz.altimari.domain.PagamentoComBoleto;
import com.luiz.altimari.domain.PagamentoComCartao;
import com.luiz.altimari.domain.Pedido;
import com.luiz.altimari.domain.enums.EstadoPagamento;
import com.luiz.altimari.domain.enums.TipoCliente;
import com.luiz.altimari.repository.CidadeRepository;
import com.luiz.altimari.repository.ClienteRepository;
import com.luiz.altimari.repository.EnderecoRepository;
import com.luiz.altimari.repository.EstadoRepository;
import com.luiz.altimari.repository.PagamentoRepository;
import com.luiz.altimari.repository.PedidoRepository;

@SpringBootApplication

public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository CidadeRepo;
	@Autowired
	private EstadoRepository EstadoRepo;
	@Autowired
	private ClienteRepository ClienteRepo;
	@Autowired
	private EnderecoRepository EnderecoRepo;
	@Autowired
	private PedidoRepository PedidoRepo;
	@Autowired
	private PagamentoRepository PagamentoRepo;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Estado p1 = new Estado(null, "Rio de Janeiro", "RJ");
		Estado p2 = new Estado(null, "Minas Gerais", "MG");
		Estado p3 = new Estado(null, "São Paulo",  "SP");
		
		Cidade c1 = new Cidade(null, "Rio de Janeiro", p1);
		Cidade c2 = new Cidade(null, "Cabo Frio", p1);
		Cidade c3 = new Cidade(null, "Belo Horizonte", p2);
		Cidade c4 = new Cidade(null, "Juiz de Fora", p2);
		Cidade c5 = new Cidade(null, "São Paulo", p3);
		Cidade c6 = new Cidade(null, "Santos", p3);
		
		p1.getCidades().addAll(Arrays.asList(c1, c2));
		p2.getCidades().addAll(Arrays.asList(c3, c4));
		p3.getCidades().addAll(Arrays.asList(c5, c6));
		
		this.EstadoRepo.saveAll(Arrays.asList(p1, p2, p3));
		this.CidadeRepo.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));		
		
		Cliente cli = new Cliente(null, "Luiz Carlos Altimari", "luiz.altimari@ebix.com", "111.222.333-44", TipoCliente.PESSOAFISICA);
		cli.getTelefones().addAll(Arrays.asList("99999-9999","99999-9998"));
		Endereco ed1 = new Endereco(null, "Rua dos Inválidos", "121", "Prédio", "Centro", "20231-046", cli, c1); 
		Endereco ed2 = new Endereco(null, "Rua Tamoio", "31", "Apto", "Braga", "28907-060", cli, c2);
		
		cli.getEnderecos().addAll(Arrays.asList(ed1, ed2));
		this.ClienteRepo.save(cli);
		this.EnderecoRepo.saveAll(Arrays.asList(ed1, ed2));
		
		SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("04/10/2019 15:00"), cli, ed1);
		Pedido ped2 = new Pedido(null, sdf.parse("05/10/2019 15:00"), cli, ed2);
		
		Pagamento pag1 = new PagamentoComBoleto(null, EstadoPagamento.QUITADO, ped1,  sdf.parse("31/10/2019 15:00"), sdf.parse("05/10/2019 15:00"));
		ped1.setPagamento(pag1);
		
		Pagamento pag2 = new PagamentoComCartao(null, EstadoPagamento.PENDENTE, ped2, 5);
		ped2.setPagamento(pag2);
				
		cli.setPedidos(Arrays.asList(ped1, ped2));
		this.PedidoRepo.saveAll(Arrays.asList(ped1, ped2));
		this.PagamentoRepo.saveAll(Arrays.asList(pag1, pag2));
		
		
	}
}