package com.luiz.altimari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.altimari.domain.Categoria;
import com.luiz.altimari.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	
	@GetMapping(value = "/listar")
	public List<Categoria> listar(){				
		return service.listar();
	}
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Integer id){		
			return ResponseEntity.ok().body(service.buscar(id));			
	}
}
