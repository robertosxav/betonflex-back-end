package com.betonflex.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "ordem_servico",schema="public") 
public class OrdemServico implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordem_servico_id")
	private Long ordemServicoId;

	@Column(name = "ordem_servico_numero")
	private String ordemServicoNumero;

	@Column(name = "tipo_servico_id")
	private Integer tipoServicoId;

	@Column(name = "ordem_servico_status")
	private Integer ordemServicoStatus;

	@Column(name = "ordem_servico_data_abertura")
	private String ordemServicoDataAbertura;

	public Long getOrdemServicoId() {
		return ordemServicoId;
	}
	 
	public void setOrdemServicoId(Long ordemServicoId) {
		this.ordemServicoId = ordemServicoId;
	}
	 
	public String getOrdemServicoNumero() {
		return ordemServicoNumero;
	}
	 
	public void setOrdemServicoNumero(String ordemServicoNumero) {
		this.ordemServicoNumero = ordemServicoNumero;
	}
	 
	public Integer getTipoServicoId() {
		return tipoServicoId;
	}
	 
	public void setTipoServicoId(Integer tipoServicoId) {
		this.tipoServicoId = tipoServicoId;
	}
	 
	public Integer getOrdemServicoStatus() {
		return ordemServicoStatus;
	}
	 
	public void setOrdemServicoStatus(Integer ordemServicoStatus) {
		this.ordemServicoStatus = ordemServicoStatus;
	}
	 
	public String getOrdemServicoDataAbertura() {
		return ordemServicoDataAbertura;
	}
	 
	public void setOrdemServicoDataAbertura(String ordemServicoDataAbertura) {
		this.ordemServicoDataAbertura = ordemServicoDataAbertura;
	}
	 

} 
