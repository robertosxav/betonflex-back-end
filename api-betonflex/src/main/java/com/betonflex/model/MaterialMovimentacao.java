package com.betonflex.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "public.material_movimentacao") 
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
