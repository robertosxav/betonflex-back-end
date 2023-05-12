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
@Table(name = "cliente",schema="public") 
public class Cliente implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private Long clienteId;

	@Column(name = "cliente_nome")
	private String clienteNome;

	@Column(name = "cliente_documento")
	private String clienteDocumento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "cliente_createat")
	private Date clienteCreateat;

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
	 
	public Date getClienteCreateat() {
		return clienteCreateat;
	}
	 
	public void setClienteCreateat(Date clienteCreateat) {
		this.clienteCreateat = clienteCreateat;
	}
	 

} 
