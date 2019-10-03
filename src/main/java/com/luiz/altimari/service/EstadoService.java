package com.luiz.altimari.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.altimari.domain.Estado;
import com.luiz.altimari.repository.EstadoRepository;
import com.luiz.altimari.service.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> listar(){
		return this.repo.findAll();
	}
	
	public Estado buscar(Integer id){
		Optional<Estado> estado = this.repo.findById(id); 
		return estado.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}
}
