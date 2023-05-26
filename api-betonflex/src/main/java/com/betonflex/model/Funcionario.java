package com.betonflex.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.funcionario") 
public class Funcionario implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_id")
	private Long funcionarioId;

	@Column(name = "funcionario_nome")
	private String funcionarioNome;

	@Column(name = "funcionario_cargo")
	private String funcionarioCargo;

	@Column(name = "funcionario_ativo")
	private Boolean funcionarioAtivo;

	public Long getFuncionarioId() {
		return funcionarioId;
	}
	 
	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}
	 
	public String getFuncionarioNome() {
		return funcionarioNome;
	}
	 
	public void setFuncionarioNome(String funcionarioNome) {
		this.funcionarioNome = funcionarioNome;
	}
	 
	public String getFuncionarioCargo() {
		return funcionarioCargo;
	}
	 
	public void setFuncionarioCargo(String funcionarioCargo) {
		this.funcionarioCargo = funcionarioCargo;
	}

	public Boolean getFuncionarioAtivo() {
		return funcionarioAtivo;
	}

	public void ativar() {
		this.funcionarioAtivo = true;
	}
	
	public void inativar() {
		this.funcionarioAtivo = false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(funcionarioAtivo, funcionarioCargo, funcionarioId, funcionarioNome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(funcionarioAtivo, other.funcionarioAtivo)
				&& Objects.equals(funcionarioCargo, other.funcionarioCargo)
				&& Objects.equals(funcionarioId, other.funcionarioId)
				&& Objects.equals(funcionarioNome, other.funcionarioNome);
	}

	@Override
	public String toString() {
		return "Funcionario [funcionarioId=" + funcionarioId + ", funcionarioNome=" + funcionarioNome
				+ ", funcionarioCargo=" + funcionarioCargo + ", funcionarioAtivo=" + funcionarioAtivo + "]";
	}
} 
