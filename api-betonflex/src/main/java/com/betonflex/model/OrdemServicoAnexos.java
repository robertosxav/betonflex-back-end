package com.betonflex.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "public.ordem_servico_anexos") 
public class OrdemServicoAnexos implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordem_servico_anexo_id")
	private Long ordemServicoAnexoId;

	@Column(name = "ordem_servico_id")
	private Integer ordemServicoId;

	@Column(name = "ordem_servico_anexo_arq")
	private String ordemServicoAnexoArq;

	@Column(name = "ordem_servico_anexo_arq_tipo")
	private String ordemServicoAnexoArqTipo;

	@Column(name = "ordem_servico_anexo_arq_nome")
	private String ordemServicoAnexoArqNome;

	public Long getOrdemServicoAnexoId() {
		return ordemServicoAnexoId;
	}
	 
	public void setOrdemServicoAnexoId(Long ordemServicoAnexoId) {
		this.ordemServicoAnexoId = ordemServicoAnexoId;
	}
	 
	public Integer getOrdemServicoId() {
		return ordemServicoId;
	}
	 
	public void setOrdemServicoId(Integer ordemServicoId) {
		this.ordemServicoId = ordemServicoId;
	}
	 
	public String getOrdemServicoAnexoArq() {
		return ordemServicoAnexoArq;
	}
	 
	public void setOrdemServicoAnexoArq(String ordemServicoAnexoArq) {
		this.ordemServicoAnexoArq = ordemServicoAnexoArq;
	}
	 
	public String getOrdemServicoAnexoArqTipo() {
		return ordemServicoAnexoArqTipo;
	}
	 
	public void setOrdemServicoAnexoArqTipo(String ordemServicoAnexoArqTipo) {
		this.ordemServicoAnexoArqTipo = ordemServicoAnexoArqTipo;
	}
	 
	public String getOrdemServicoAnexoArqNome() {
		return ordemServicoAnexoArqNome;
	}
	 
	public void setOrdemServicoAnexoArqNome(String ordemServicoAnexoArqNome) {
		this.ordemServicoAnexoArqNome = ordemServicoAnexoArqNome;
	}
	 

} 
