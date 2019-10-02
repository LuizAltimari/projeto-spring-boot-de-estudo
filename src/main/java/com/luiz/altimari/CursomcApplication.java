package com.luiz.altimari;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.luiz.altimari.domain.Categoria;
import com.luiz.altimari.domain.Produto;
import com.luiz.altimari.repository.CategoriaRepository;
import com.luiz.altimari.repository.ProdutoRepository;


@SpringBootApplication

public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository CategoriaRepo;
	@Autowired
	private ProdutoRepository ProdutoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(null, "Escritório");
		Categoria c2 = new Categoria(null, "Informática");
		Categoria c3 = new Categoria(null, "Eletrônica");
		
		Produto p1 = new Produto(null, "Arduino", 75.0);
		Produto p2 = new Produto(null, "Monitor", 250.0);
		Produto p3 = new Produto(null, "Mouse", 20.0);
		Produto p4 = new Produto(null, "Impressora", 800.0);
		
		
		c1.getProdutos().addAll(Arrays.asList( p3, p4));
		c2.getProdutos().addAll(Arrays.asList(p1, p2, p3, p4));
		c1.getProdutos().addAll(Arrays.asList(p1));
		
		p1.getCategorias().addAll(Arrays.asList(c2, c3));
		p3.getCategorias().addAll(Arrays.asList(c2, c1));
		p2.getCategorias().addAll(Arrays.asList( c2));
		p4.getCategorias().addAll(Arrays.asList( c2, c1));
		
		this.CategoriaRepo.saveAll(Arrays.asList(c1, c2, c3));
		this.ProdutoRepo.saveAll(Arrays.asList(p1, p2, p3, p4));
	}

}
