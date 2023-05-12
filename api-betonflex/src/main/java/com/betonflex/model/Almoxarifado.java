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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "almoxarifado",schema="public") 
public class Almoxarifado implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "almoxarifado_id")
	private Long almoxarifadoId;

	@Column(name = "almoxarifado_nome")
	private String almoxarifadoNome;

	@Column(name = "almoxarifado_descricao")
	private String almoxarifadoDescricao;

	@Column(name = "almoxarifado_ativo")
	private Boolean almoxarifadoAtivo;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "almoxarifado_createat")
	private Date almoxarifadoCreateat;

	public Long getAlmoxarifadoId() {
		return almoxarifadoId;
	}
	 
	public void setAlmoxarifadoId(Long almoxarifadoId) {
		this.almoxarifadoId = almoxarifadoId;
	}
	 
	public String getAlmoxarifadoNome() {
		return almoxarifadoNome;
	}
	 
	public void setAlmoxarifadoNome(String almoxarifadoNome) {
		this.almoxarifadoNome = almoxarifadoNome;
	}
	 
	public String getAlmoxarifadoDescricao() {
		return almoxarifadoDescricao;
	}
	 
	public void setAlmoxarifadoDescricao(String almoxarifadoDescricao) {
		this.almoxarifadoDescricao = almoxarifadoDescricao;
	}
	 
	public Boolean getAlmoxarifadoAtivo() {
		return almoxarifadoAtivo;
	}
	 
	public void setAlmoxarifadoAtivo(Boolean almoxarifadoAtivo) {
		this.almoxarifadoAtivo = almoxarifadoAtivo;
	}
	 
	public Date getAlmoxarifadoCreateat() {
		return almoxarifadoCreateat;
	}
	 
	public void setAlmoxarifadoCreateat(Date almoxarifadoCreateat) {
		this.almoxarifadoCreateat = almoxarifadoCreateat;
	}
	 

} 
