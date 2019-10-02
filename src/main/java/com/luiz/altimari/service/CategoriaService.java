package com.luiz.altimari.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.altimari.domain.Categoria;
import com.luiz.altimari.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Optional<Categoria> buscar(Integer id) {
		return this.repo.findById(id);
	}
	
	public List<Categoria> listar(){
		return this.repo.findAll();
	}
	
	
}
