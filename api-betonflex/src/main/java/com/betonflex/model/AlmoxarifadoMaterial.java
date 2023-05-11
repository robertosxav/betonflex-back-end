package com.betonflex.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administrativo.almoxarifado_material") 
public class AlmoxarifadoMaterial implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "almoxarifado_material_id")
	private Long almoxarifadoMaterialId;

	@Column(name = "almoxarifado_id")
	private String almoxarifadoId;

	@Column(name = "material_id")
	private String materialId;

	public Long getAlmoxarifadoMaterialId() {
		return almoxarifadoMaterialId;
	}
	 
	public void setAlmoxarifadoMaterialId(Long almoxarifadoMaterialId) {
		this.almoxarifadoMaterialId = almoxarifadoMaterialId;
	}
	 
	public String getAlmoxarifadoId() {
		return almoxarifadoId;
	}
	 
	public void setAlmoxarifadoId(String almoxarifadoId) {
		this.almoxarifadoId = almoxarifadoId;
	}
	 
	public String getMaterialId() {
		return materialId;
	}
	 
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	 

} 
