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
@Table(name = "public.ordem_servico_material") 
public class OrdemServicoMaterial implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordem_servico_material_id")
	private Long ordemServicoMaterialId;

	@Column(name = "almoxarifado_material_id")
	private Integer almoxarifadoMaterialId;

	@Column(name = "ordem_servico_id")
	private Integer ordemServicoId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ordem_servico_material_data")
	private Date ordemServicoMaterialData;

	@Column(name = "ordem_servico_material_status")
	private String ordemServicoMaterialStatus;

	@Column(name = "funcionario_id")
	private Integer funcionarioId;

	@Column(name = "ordem_servico_material_valor")
	private String ordemServicoMaterialValor;

	@Column(name = "almoxarifado_material_valor")
	private String almoxarifadoMaterialValor;

	@Column(name = "ordem_servico_material_qtd")
	private Integer ordemServicoMaterialQtd;

	public Long getOrdemServicoMaterialId() {
		return ordemServicoMaterialId;
	}
	 
	public void setOrdemServicoMaterialId(Long ordemServicoMaterialId) {
		this.ordemServicoMaterialId = ordemServicoMaterialId;
	}
	 
	public Integer getAlmoxarifadoMaterialId() {
		return almoxarifadoMaterialId;
	}
	 
	public void setAlmoxarifadoMaterialId(Integer almoxarifadoMaterialId) {
		this.almoxarifadoMaterialId = almoxarifadoMaterialId;
	}
	 
	public Integer getOrdemServicoId() {
		return ordemServicoId;
	}
	 
	public void setOrdemServicoId(Integer ordemServicoId) {
		this.ordemServicoId = ordemServicoId;
	}
	 
	public Date getOrdemServicoMaterialData() {
		return ordemServicoMaterialData;
	}
	 
	public void setOrdemServicoMaterialData(Date ordemServicoMaterialData) {
		this.ordemServicoMaterialData = ordemServicoMaterialData;
	}
	 
	public String getOrdemServicoMaterialStatus() {
		return ordemServicoMaterialStatus;
	}
	 
	public void setOrdemServicoMaterialStatus(String ordemServicoMaterialStatus) {
		this.ordemServicoMaterialStatus = ordemServicoMaterialStatus;
	}
	 
	public Integer getFuncionarioId() {
		return funcionarioId;
	}
	 
	public void setFuncionarioId(Integer funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
	 
	public String getOrdemServicoMaterialValor() {
		return ordemServicoMaterialValor;
	}
	 
	public void setOrdemServicoMaterialValor(String ordemServicoMaterialValor) {
		this.ordemServicoMaterialValor = ordemServicoMaterialValor;
	}
	 
	public String getAlmoxarifadoMaterialValor() {
		return almoxarifadoMaterialValor;
	}
	 
	public void setAlmoxarifadoMaterialValor(String almoxarifadoMaterialValor) {
		this.almoxarifadoMaterialValor = almoxarifadoMaterialValor;
	}
	 
	public Integer getOrdemServicoMaterialQtd() {
		return ordemServicoMaterialQtd;
	}
	 
	public void setOrdemServicoMaterialQtd(Integer ordemServicoMaterialQtd) {
		this.ordemServicoMaterialQtd = ordemServicoMaterialQtd;
	}
	 

} 
