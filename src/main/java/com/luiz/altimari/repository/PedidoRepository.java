package com.luiz.altimari.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luiz.altimari.domain.Pedido;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Integer>{

}
