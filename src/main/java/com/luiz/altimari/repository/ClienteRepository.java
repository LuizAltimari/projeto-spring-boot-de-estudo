package com.luiz.altimari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luiz.altimari.domain.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

}
