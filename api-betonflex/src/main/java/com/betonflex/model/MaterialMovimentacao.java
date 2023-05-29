package com.betonflex.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "material_movimentacao",schema="public") 
public class MaterialMovimentacao implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "material_movimentacao_id")
	private Long materialMovimentacaoId;

	@Column(name = "almoxarifado_material_id")
	private Integer almoxarifadoMaterialId;

	@Column(name = "material_movimentacao_tipo")
	private String materialMovimentacaoTipo;

	public Long getMaterialMovimentacaoId() {
		return materialMovimentacaoId;
	}
	 
	public void setMaterialMovimentacaoId(Long materialMovimentacaoId) {
		this.materialMovimentacaoId = materialMovimentacaoId;
	}
	 
	public Integer getAlmoxarifadoMaterialId() {
		return almoxarifadoMaterialId;
	}
	 
	public void setAlmoxarifadoMaterialId(Integer almoxarifadoMaterialId) {
		this.almoxarifadoMaterialId = almoxarifadoMaterialId;
	}
	 
	public String getMaterialMovimentacaoTipo() {
		return materialMovimentacaoTipo;
	}
	 
	public void setMaterialMovimentacaoTipo(String materialMovimentacaoTipo) {
		this.materialMovimentacaoTipo = materialMovimentacaoTipo;
	}
	 

} 
