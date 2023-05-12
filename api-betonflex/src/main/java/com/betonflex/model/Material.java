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
@Table(name = "material",schema="public") 
public class Material implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "material_id")
	private Long materialId;

	@Column(name = "material_nome")
	private String materialNome;

	@Column(name = "material_descricao")
	private String materialDescricao;

	@Column(name = "material_observacao")
	private String materialObservacao;

	@Column(name = "material_sku")
	private String materialSku;

	@Column(name = "material_ativo")
	private Integer materialAtivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "material_createat")
	private Date materialCreateat;

	public Long getMaterialId() {
		return materialId;
	}
	 
	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}
	 
	public String getMaterialNome() {
		return materialNome;
	}
	 
	public void setMaterialNome(String materialNome) {
		this.materialNome = materialNome;
	}
	 
	public String getMaterialDescricao() {
		return materialDescricao;
	}
	 
	public void setMaterialDescricao(String materialDescricao) {
		this.materialDescricao = materialDescricao;
	}
	 
	public String getMaterialObservacao() {
		return materialObservacao;
	}
	 
	public void setMaterialObservacao(String materialObservacao) {
		this.materialObservacao = materialObservacao;
	}
	 
	public String getMaterialSku() {
		return materialSku;
	}
	 
	public void setMaterialSku(String materialSku) {
		this.materialSku = materialSku;
	}
	 
	public Integer getMaterialAtivo() {
		return materialAtivo;
	}
	 
	public void setMaterialAtivo(Integer materialAtivo) {
		this.materialAtivo = materialAtivo;
	}
	 
	public Date getMaterialCreateat() {
		return materialCreateat;
	}
	 
	public void setMaterialCreateat(Date materialCreateat) {
		this.materialCreateat = materialCreateat;
	}
	 

} 
