package com.betonflex.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "material",schema="public") 
public class Material implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_MATERIAL")
	@SequenceGenerator(name = "SEQUENCE_MATERIAL",sequenceName = "public.material_id",allocationSize = 1)
	@Column(name = "material_id")
	private Long materialId;

	@Column(name = "material_nome",nullable = false)
	private String materialNome;

	@Column(name = "material_descricao",nullable = false)
	private String materialDescricao;

	@Column(name = "material_observacao",nullable = false)
	private String materialObservacao;

	@Column(name = "material_sku",nullable = false)
	private String materialSku;

	@Column(name = "material_ativo",nullable = false)
	private Boolean materialAtivo;

	@JsonFormat(pattern = "dd/MM/yyy")
	@Column(name = "material_createat",nullable = false)
	private LocalDate materialCreateat;

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

	public Boolean getMaterialAtivo() {
		return materialAtivo;
	}


	public LocalDate getMaterialCreateat() {
		return materialCreateat;
	}

	public void ativar() {
		this.materialAtivo = true;
		this.materialCreateat = LocalDate.now();
	}
	
	public void inativar() {
		this.materialAtivo = false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(materialId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		return Objects.equals(materialId, other.materialId);
	}

	@Override
	public String toString() {
		return "Material [materialId=" + materialId + ", materialNome=" + materialNome + ", materialDescricao="
				+ materialDescricao + ", materialObservacao=" + materialObservacao + ", materialSku=" + materialSku
				+ ", materialAtivo=" + materialAtivo + ", materialCreateat=" + materialCreateat + "]";
	}
} 
