package com.betonflex.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private Integer funcionarioAtivo;

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
	 
	public Integer getFuncionarioAtivo() {
		return funcionarioAtivo;
	}
	 
	public void setFuncionarioAtivo(Integer funcionarioAtivo) {
		this.funcionarioAtivo = funcionarioAtivo;
	}
	 

} 
