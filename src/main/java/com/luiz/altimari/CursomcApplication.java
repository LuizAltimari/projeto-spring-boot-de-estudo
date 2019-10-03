package com.luiz.altimari;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luiz.altimari.domain.Cidade;
import com.luiz.altimari.domain.Estado;
import com.luiz.altimari.repository.CidadeRepository;
import com.luiz.altimari.repository.EstadoRepository;

@SpringBootApplication

public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository CidadeRepo;
	@Autowired
	private EstadoRepository EstadoRepo;

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
	}

}
