package com.betonflex.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "almoxarifado_material",schema="public") 
public class AlmoxarifadoMaterial implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "almoxarifado_material_id")
	private Long almoxarifadoMaterialId;


	@ManyToOne(cascade = CascadeType.ALL)  
	@JoinColumn(name = "almoxarifado_id")
	private Almoxarifado almoxarifado;


	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "material_id")
	private Material material;

	public Long getAlmoxarifadoMaterialId() {
		return almoxarifadoMaterialId;
	}
	 
	public void setAlmoxarifadoMaterialId(Long almoxarifadoMaterialId) {
		this.almoxarifadoMaterialId = almoxarifadoMaterialId;
	}

	public Almoxarifado getAlmoxarifado() {
		return almoxarifado;
	}

	public void setAlmoxarifado(Almoxarifado almoxarifado) {
		this.almoxarifado = almoxarifado;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public AlmoxarifadoMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlmoxarifadoMaterial(Almoxarifado almoxarifado, Material material) {
		super();
		this.almoxarifado = almoxarifado;
		this.material = material;
	}
	
	
	 
} 
