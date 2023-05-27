package com.betonflex.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ordem_servico_material",schema="public") 
public class OrdemServicoMaterial implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordem_servico_material_id")
	private Long ordemServicoMaterialId;

	@JoinColumn(name = "almoxarifado_material_id",referencedColumnName = "almoxarifado_material_id")
	private AlmoxarifadoMaterial almoxarifadoMaterial;

	@JoinColumn(name = "ordem_servico_id",referencedColumnName = "ordem_servico_id")
	private OrdemServico ordemServico;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "ordem_servico_material_data")
	private LocalDate ordemServicoMaterialData;

	@Column(name = "ordem_servico_material_status")
	private String ordemServicoMaterialStatus;

	@Column(name = "funcionario_id")
	private Funcionario funcionario;

	@Column(name = "ordem_servico_material_valor")
	private String ordemServicoMaterialValor;

	@Column(name = "almoxarifado_material_valor")
	private String almoxarifado_material_valor;

	@Column(name = "ordem_servico_material_qtd")
	private Integer ordem_servico_material_qtd;

	public Long getOrdemServicoMaterialId() {
		return ordemServicoMaterialId;
	}

	public void setOrdemServicoMaterialId(Long ordemServicoMaterialId) {
		this.ordemServicoMaterialId = ordemServicoMaterialId;
	}

	public AlmoxarifadoMaterial getAlmoxarifadoMaterial() {
		return almoxarifadoMaterial;
	}

	public void setAlmoxarifadoMaterial(AlmoxarifadoMaterial almoxarifadoMaterial) {
		this.almoxarifadoMaterial = almoxarifadoMaterial;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public LocalDate getOrdemServicoMaterialData() {
		return ordemServicoMaterialData;
	}

	public void setOrdemServicoMaterialData(LocalDate ordemServicoMaterialData) {
		this.ordemServicoMaterialData = ordemServicoMaterialData;
	}

	public String getOrdemServicoMaterialStatus() {
		return ordemServicoMaterialStatus;
	}

	public void setOrdemServicoMaterialStatus(String ordemServicoMaterialStatus) {
		this.ordemServicoMaterialStatus = ordemServicoMaterialStatus;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getOrdemServicoMaterialValor() {
		return ordemServicoMaterialValor;
	}

	public void setOrdemServicoMaterialValor(String ordemServicoMaterialValor) {
		this.ordemServicoMaterialValor = ordemServicoMaterialValor;
	}

	public String getAlmoxarifado_material_valor() {
		return almoxarifado_material_valor;
	}

	public void setAlmoxarifado_material_valor(String almoxarifado_material_valor) {
		this.almoxarifado_material_valor = almoxarifado_material_valor;
	}

	public Integer getOrdem_servico_material_qtd() {
		return ordem_servico_material_qtd;
	}

	public void setOrdem_servico_material_qtd(Integer ordem_servico_material_qtd) {
		this.ordem_servico_material_qtd = ordem_servico_material_qtd;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ordemServicoMaterialId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServicoMaterial other = (OrdemServicoMaterial) obj;
		return Objects.equals(ordemServicoMaterialId, other.ordemServicoMaterialId);
	}

	@Override
	public String toString() {
		return "OrdemServicoMaterial [ordemServicoMaterialId=" + ordemServicoMaterialId + ", almoxarifadoMaterial="
				+ almoxarifadoMaterial + ", ordemServico=" + ordemServico + ", ordemServicoMaterialData="
				+ ordemServicoMaterialData + ", ordemServicoMaterialStatus=" + ordemServicoMaterialStatus
				+ ", funcionario=" + funcionario + ", ordemServicoMaterialValor=" + ordemServicoMaterialValor
				+ ", almoxarifado_material_valor=" + almoxarifado_material_valor + ", ordem_servico_material_qtd="
				+ ordem_servico_material_qtd + "]";
	}

	
} 
