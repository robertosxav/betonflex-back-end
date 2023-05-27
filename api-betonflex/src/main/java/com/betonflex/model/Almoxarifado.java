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
@Table(name = "almoxarifado", schema = "public")
public class Almoxarifado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ALMOXARIFADO")
	@SequenceGenerator(name = "SEQUENCE_ALMOXARIFADO", sequenceName = "public.almoxarifado_id", allocationSize = 1)
	@Column(name = "almoxarifado_id")
	private Long almoxarifadoId;

	@Column(name = "almoxarifado_nome")
	private String almoxarifadoNome;

	@Column(name = "almoxarifado_descricao")
	private String almoxarifadoDescricao;

	@Column(name = "almoxarifado_ativo")
	private Boolean almoxarifadoAtivo;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "almoxarifado_createat")
	private LocalDate almoxarifadoCreateat;

	/*@OneToMany()
	@JoinColumn(name ="material_id")
	private List<Material> listaMateriais;*/

	public Long getAlmoxarifadoId() {
		return almoxarifadoId;
	}

	public void setAlmoxarifadoId(Long almoxarifadoId) {
		this.almoxarifadoId = almoxarifadoId;
	}

	public String getAlmoxarifadoNome() {
		return almoxarifadoNome;
	}

	public void setAlmoxarifadoNome(String almoxarifadoNome) {
		this.almoxarifadoNome = almoxarifadoNome;
	}

	public String getAlmoxarifadoDescricao() {
		return almoxarifadoDescricao;
	}

	public void setAlmoxarifadoDescricao(String almoxarifadoDescricao) {
		this.almoxarifadoDescricao = almoxarifadoDescricao;
	}

	public Boolean getAlmoxarifadoAtivo() {
		return almoxarifadoAtivo;
	}

	public LocalDate getAlmoxarifadoCreateat() {
		return almoxarifadoCreateat;
	}

	/*public List<Material> getListaMateriais() {
		return listaMateriais;
	}*/

	/*public void setListaMateriais(List<Material> listaMateriais) {
		this.listaMateriais = listaMateriais;
	}*/

	public void ativar() {
		this.almoxarifadoAtivo = true;
		this.almoxarifadoCreateat = LocalDate.now();
	}

	public void inativar() {
		this.almoxarifadoAtivo = false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(almoxarifadoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Almoxarifado other = (Almoxarifado) obj;
		return Objects.equals(almoxarifadoId, other.almoxarifadoId);
	}

	@Override
	public String toString() {
		return "Almoxarifado [almoxarifadoId=" + almoxarifadoId + ", almoxarifadoNome=" + almoxarifadoNome
				+ ", almoxarifadoDescricao=" + almoxarifadoDescricao + ", almoxarifadoAtivo=" + almoxarifadoAtivo
				+ ", almoxarifadoCreateat=" + almoxarifadoCreateat + "]";
	}

}
