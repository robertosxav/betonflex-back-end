package com.betonflex.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "ordem_servico_cliente",schema="public") 
public class OrdemServicoCliente implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordem_servico_cliente_id")
	private Long ordemServicoClienteId;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Long getOrdemServicoClienteId() {
		return ordemServicoClienteId;
	}
	 
	public void setOrdemServicoClienteId(Long ordemServicoClienteId) {
		this.ordemServicoClienteId = ordemServicoClienteId;
	}
	 
	public Cliente getCliente() {
		return cliente;
	}
	 
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	 

} 
