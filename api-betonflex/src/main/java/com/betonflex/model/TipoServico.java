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
@Table(name = "tipo_servico",schema="public") 
public class TipoServico implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_TIPO_SERVICO")
	@SequenceGenerator(name = "SEQUENCE_TIPO_SERVICO",sequenceName = "public.tipo_servico_id",allocationSize = 1)
	@Column(name = "tipo_servico_id")
	private Long tipoServicoId;

	@Column(name = "tipo_servico_nome")
	private String tipoServicoNome;

	@Column(name = "tipo_servico_descricao")
	private String tipoServicoDescricao;

	@Column(name = "tipo_servico_ativo")
	private Boolean tipoServicoAtivo;

	@JsonFormat(pattern = "dd/MM/yyy")
	@Column(name = "tipo_servico_createat")
	private LocalDate tipoServicoCreateat;

	public Long getTipoServicoId() {
		return tipoServicoId;
	}
	 
	public void setTipoServicoId(Long tipoServicoId) {
		this.tipoServicoId = tipoServicoId;
	}
	 
	public String getTipoServicoNome() {
		return tipoServicoNome;
	}
	 
	public void setTipoServicoNome(String tipoServicoNome) {
		this.tipoServicoNome = tipoServicoNome;
	}
	 
	public String getTipoServicoDescricao() {
		return tipoServicoDescricao;
	}
	 
	public void setTipoServicoDescricao(String tipoServicoDescricao) {
		this.tipoServicoDescricao = tipoServicoDescricao;
	}
	 
	public Boolean getTipoServicoAtivo() {
		return tipoServicoAtivo;
	}
	 
	public LocalDate getTipoServicoCreateat() {
		return tipoServicoCreateat;
	}
	
	public void ativar() {
		this.tipoServicoAtivo = true;
		this.tipoServicoCreateat = LocalDate.now();
	}
	
	public void inativar() {
		this.tipoServicoAtivo = false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoServicoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoServico other = (TipoServico) obj;
		return Objects.equals(tipoServicoId, other.tipoServicoId);
	}

	@Override
	public String toString() {
		return "TipoServico [tipoServicoId=" + tipoServicoId + ", tipoServicoNome=" + tipoServicoNome
				+ ", tipoServicoDescricao=" + tipoServicoDescricao + ", tipoServicoAtivo=" + tipoServicoAtivo
				+ ", tipoServicoCreateat=" + tipoServicoCreateat + "]";
	}

} 
