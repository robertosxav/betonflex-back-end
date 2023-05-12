package com.betonflex.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "almoxarifado_material",schema="public") 
public class AlmoxarifadoMaterial implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "almoxarifado_material_id")
	private Long almoxarifadoMaterialId;

	@Column(name = "almoxarifado_id")
	private Integer almoxarifadoId;

	@Column(name = "material_id")
	private Integer materialId;

	public Long getAlmoxarifadoMaterialId() {
		return almoxarifadoMaterialId;
	}
	 
	public void setAlmoxarifadoMaterialId(Long almoxarifadoMaterialId) {
		this.almoxarifadoMaterialId = almoxarifadoMaterialId;
	}
	 
	public Integer getAlmoxarifadoId() {
		return almoxarifadoId;
	}
	 
	public void setAlmoxarifadoId(Integer almoxarifadoId) {
		this.almoxarifadoId = almoxarifadoId;
	}
	 
	public Integer getMaterialId() {
		return materialId;
	}
	 
	public void setMaterialId(Integer materialId) {
		this.materialId = materialId;
	}
	 

} 
