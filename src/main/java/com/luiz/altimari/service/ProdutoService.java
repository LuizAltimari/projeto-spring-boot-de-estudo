package com.luiz.altimari.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.altimari.domain.Produto;
import com.luiz.altimari.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	public List<Produto> listar(){
		return repo.findAll();
	}
	
	public Optional<Produto> buscar(Integer id){
		return repo.findById(id);
	}
}
