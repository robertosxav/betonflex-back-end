package com.betonflex.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import java.util.Date;
import javax.persistence.TemporalType;

@Entity
@Table(name = "public.ordem_servico_fechamento") 
public class OrdemServicoFechamento implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordem_servico_fechamento_id")
	private Long ordemServicoFechamentoId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ordem_servico_fechamento_data")
	private Date ordemServicoFechamentoData;

	@Column(name = "ordem_servico_id")
	private Integer ordemServicoId;

	public Long getOrdemServicoFechamentoId() {
		return ordemServicoFechamentoId;
	}
	 
	public void setOrdemServicoFechamentoId(Long ordemServicoFechamentoId) {
		this.ordemServicoFechamentoId = ordemServicoFechamentoId;
	}
	 
	public Date getOrdemServicoFechamentoData() {
		return ordemServicoFechamentoData;
	}
	 
	public void setOrdemServicoFechamentoData(Date ordemServicoFechamentoData) {
		this.ordemServicoFechamentoData = ordemServicoFechamentoData;
	}
	 
	public Integer getOrdemServicoId() {
		return ordemServicoId;
	}
	 
	public void setOrdemServicoId(Integer ordemServicoId) {
		this.ordemServicoId = ordemServicoId;
	}
	 

} 
