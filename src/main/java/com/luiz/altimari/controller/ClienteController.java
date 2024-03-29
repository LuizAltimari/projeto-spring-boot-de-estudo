package com.luiz.altimari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.altimari.domain.Cliente;
import com.luiz.altimari.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	
	@GetMapping(value = "/listar")
	public List<Cliente> listar(){				
		return service.listar();
	}
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<?> buscar(@PathVariable("id") Integer id){		
			return ResponseEntity.ok().body(service.buscar(id));			
	}
}
