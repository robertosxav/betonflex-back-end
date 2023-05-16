package com.betonflex.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "cliente",schema="public") 
public class Cliente implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_CLIENTE")
	@SequenceGenerator(name = "SEQUENCE_CLIENTE",sequenceName = "public.cliente_id",allocationSize = 1)
	@Column(name = "cliente_id")
	private Long clienteId;

	@Column(name = "cliente_nome")
	private String clienteNome;

	@Column(name = "cliente_documento")
	private String clienteDocumento;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "cliente_createat")
	private LocalDate clienteCreateat;

	public Long getClienteId() {
		return clienteId;
	}
	 
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	 
	public String getClienteNome() {
		return clienteNome;
	}
	 
	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}
	 
	public String getClienteDocumento() {
		return clienteDocumento;
	}
	 
	public void setClienteDocumento(String clienteDocumento) {
		this.clienteDocumento = clienteDocumento;
	}
	 
	public LocalDate getClienteCreateat() {
		return clienteCreateat;
	}

	public void ativar() {
		this.clienteCreateat = LocalDate.now();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(clienteId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(clienteId, other.clienteId);
	}

	@Override
	public String toString() {
		return "Cliente [clienteId=" + clienteId + ", clienteNome=" + clienteNome + ", clienteDocumento="
				+ clienteDocumento + ", clienteCreateat=" + clienteCreateat + "]";
	}
	
} 
