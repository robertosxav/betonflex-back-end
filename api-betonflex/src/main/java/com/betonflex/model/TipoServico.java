package com.betonflex.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tipo_servico",schema = "administrativo") 
public class TipoServico implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tipo_servico_id")
	private Long tipoServicoId;

	@Column(name = "tipo_servico_nome")
	private String tipoServicoNome;

	@Column(name = "tipo_servico_descricao")
	private String tipoServicoDescricao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tipo_servico_createat")
	private Date tipoServicoCreateat;

	@Column(name = "tipo_servico_ativo")
	private Integer tipoServicoAtivo;

	public Long getTipoServicoId() {
		return tipoServicoId;
	}
	 
	public void setTipoServicoId(Long tipoServicoId) {
		this.tipoServicoId = tipoServicoId;
	}
	 
	public String getTipoServicoNome() {
		return tipoServicoNome;
	}
	 
	public void setTipoServicoNome(String tipoServicoNome) {
		this.tipoServicoNome = tipoServicoNome;
	}
	 
	public String getTipoServicoDescricao() {
		return tipoServicoDescricao;
	}
	 
	public void setTipoServicoDescricao(String tipoServicoDescricao) {
		this.tipoServicoDescricao = tipoServicoDescricao;
	}
	 
	public Date getTipoServicoCreateat() {
		return tipoServicoCreateat;
	}
	 
	public void setTipoServicoCreateat(Date tipoServicoCreateat) {
		this.tipoServicoCreateat = tipoServicoCreateat;
	}
	 
	public Integer getTipoServicoAtivo() {
		return tipoServicoAtivo;
	}
	 
	public void setTipoServicoAtivo(Integer tipoServicoAtivo) {
		this.tipoServicoAtivo = tipoServicoAtivo;
	}
	 

} 
