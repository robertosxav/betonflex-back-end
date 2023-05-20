package com.betonflex.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ordem_servico_id")
	private OrdemServico ordemServico;

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

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public OrdemServicoCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdemServicoCliente(Cliente cliente, OrdemServico ordemServico) {
		super();
		this.cliente = cliente;
		this.ordemServico = ordemServico;
	}

} 
