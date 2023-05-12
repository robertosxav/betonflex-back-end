package com.betonflex.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ordem_servico",schema = "administrativo") 
public class OrdemServico implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ordem_servico_id")
	private Long ordemServicoId;

	@Column(name = "ordem_servico_numero")
	private String ordemServicoNumero;

	@Column(name = "ordem_servico_status")
	private Integer ordemServicoStatus;

	@Column(name = "ordem_servico_data_abertura")
	private String ordemServicoDataAbertura;

	@Column(name = "tipo_servico_id")
	private String tipoServicoId;

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
	 
	public String getTipoServicoId() {
		return tipoServicoId;
	}
	 
	public void setTipoServicoId(String tipoServicoId) {
		this.tipoServicoId = tipoServicoId;
	}
	 

} 
