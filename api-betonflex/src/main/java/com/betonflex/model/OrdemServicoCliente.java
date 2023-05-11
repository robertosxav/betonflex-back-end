package com.betonflex.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "administrativo.ordem_servico_cliente") 
public class OrdemServicoCliente implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ordem_servico_cliente_id")
	private Long ordemServicoClienteId;

	@Column(name = "cliente_id")
	private String clienteId;

	public Long getOrdemServicoClienteId() {
		return ordemServicoClienteId;
	}
	 
	public void setOrdemServicoClienteId(Long ordemServicoClienteId) {
		this.ordemServicoClienteId = ordemServicoClienteId;
	}
	 
	public String getClienteId() {
		return clienteId;
	}
	 
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	 

} 
