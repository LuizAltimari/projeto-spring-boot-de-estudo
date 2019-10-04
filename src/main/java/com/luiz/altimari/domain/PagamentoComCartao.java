package com.luiz.altimari.domain;

import javax.persistence.Entity;

import com.luiz.altimari.domain.enums.EstadoPagamento;
@Entity
public class PagamentoComCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;

	public PagamentoComCartao() {
		super();
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer nParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = nParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
	
}
