package com.luiz.altimari.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.altimari.domain.Categoria;
import com.luiz.altimari.domain.Cidade;
import com.luiz.altimari.repository.CidadeRepository;
import com.luiz.altimari.service.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	public List<Cidade> listar(){
		return repo.findAll();
	}
	
	public Cidade buscar(Integer id) {
		Optional<Cidade> cidade = repo.findById(id);
		return cidade.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
}
