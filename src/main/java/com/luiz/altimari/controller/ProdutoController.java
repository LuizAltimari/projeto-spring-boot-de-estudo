package com.luiz.altimari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.altimari.domain.Produto;
import com.luiz.altimari.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping(value = "/listar")
	public List<Produto> listar(){
		return this.service.listar();
	}
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Integer id){
		return ResponseEntity.ok().body(service.buscar(id));
	}
}
