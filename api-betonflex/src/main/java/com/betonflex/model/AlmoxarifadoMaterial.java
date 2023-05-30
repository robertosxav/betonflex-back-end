package com.betonflex.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.betonflex.model.enuns.StatusMatAlmoxaridoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "almoxarifado_material",schema="public") 
public class AlmoxarifadoMaterial implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "almoxarifado_material_id")
	private Long almoxarifadoMaterialId;

	//@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne()  
	@JoinColumn(name = "almoxarifado_id")
	private Almoxarifado almoxarifado;

	//@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne() 
	@JoinColumn(name = "material_id")
	private Material material;
	
	@Column(name="almoxarifado_material_lote")
	private String lote;
	
	@Column(name="almoxarifado_material_valor_un")
	private BigDecimal valorUnitario;
	
	@Column(name="almoxarifado_material_valor_to")
	private BigDecimal valorTotal;
	
	@Column(name="almoxarifado_material_qtd")
	private BigDecimal qtde;
	
	@Column(name="almoxarifado_material_qtd_uti")
	private BigDecimal qtdeUtilizada;
	
	@Enumerated(EnumType.STRING)
	@Column(name="almoxarifado_material_status")
	private StatusMatAlmoxaridoEnum status;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name="almoxarifado_material_data")
	private LocalDate data;
	
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

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getQtde() {
		return qtde;
	}

	public void setQtde(BigDecimal qtde) {
		this.qtde = qtde;
	}

	public BigDecimal getQtdeUtilizada() {
		return qtdeUtilizada;
	}

	public void setQtdeUtilizada(BigDecimal qtdeUtilizada) {
		this.qtdeUtilizada = qtdeUtilizada;
	}

	public StatusMatAlmoxaridoEnum getStatus() {
		return status;
	}

	public void setStatus(StatusMatAlmoxaridoEnum status) {
		this.status = status;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
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

	public AlmoxarifadoMaterial(Almoxarifado almoxarifado, Material material, String lote, BigDecimal valorUnitario,
			BigDecimal valorTotal, BigDecimal qtde, BigDecimal qtdeUtilizada, StatusMatAlmoxaridoEnum status, LocalDate data) {
		super();
		this.almoxarifado = almoxarifado;
		this.material = material;
		this.lote = lote;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
		this.qtde = qtde;
		this.qtdeUtilizada = qtdeUtilizada;
		this.status = status;
		this.data = data;
	}
	 
} 
