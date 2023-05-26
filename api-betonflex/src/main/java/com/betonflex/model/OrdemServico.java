package com.betonflex.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.betonflex.model.enuns.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ordem_servico",schema="public") 
public class OrdemServico implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordem_servico_id")
	private Long ordemServicoId;

	@Column(name = "ordem_servico_numero")
	private String ordemServicoNumero;

	@ManyToOne
	@JoinColumn(name = "tipo_servico_id", referencedColumnName = "tipo_servico_id")
	private TipoServico tipoServico;

	@Column(name = "ordem_servico_status")
	private StatusEnum ordemServicoStatus;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "ordem_servico_data_abertura")
	private LocalDate ordemServicoDataAbertura;
	
	@Column(name = "ordem_servico_valor")
	private BigDecimal ordemServicoValor;

	public Long getOrdemServicoId() {
		return ordemServicoId;
	}

	public void setOrdemServicoId(Long ordemServicoId) {
		this.ordemServicoId = ordemServicoId;
	}

	public String getOrdemServicoNumero() {
		return ordemServicoNumero;
	}

	public void setOrdemServicoNumero(String ordemServicoNumero) {
		this.ordemServicoNumero = ordemServicoNumero;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public StatusEnum getOrdemServicoStatus() {
		return ordemServicoStatus;
	}

	public void setOrdemServicoStatus(StatusEnum ordemServicoStatus) {
		this.ordemServicoStatus = ordemServicoStatus;
	}

	public LocalDate getOrdemServicoDataAbertura() {
		return ordemServicoDataAbertura;
	}

	public void setOrdemServicoDataAbertura(LocalDate ordemServicoDataAbertura) {
		this.ordemServicoDataAbertura = ordemServicoDataAbertura;
	}
	
	
	public BigDecimal getOrdemServicoValor() {
		return ordemServicoValor;
	}

	public void setOrdemServicoValor(BigDecimal ordemServicoValor) {
		this.ordemServicoValor = ordemServicoValor;
	}

	public void ativar() {
		this.ordemServicoStatus = StatusEnum.NOVO;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(ordemServicoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServico other = (OrdemServico) obj;
		return Objects.equals(ordemServicoId, other.ordemServicoId);
	}

	@Override
	public String toString() {
		return "OrdemServico [ordemServicoId=" + ordemServicoId + ", ordemServicoNumero=" + ordemServicoNumero
				+ ", tipoServico=" + tipoServico + ", ordemServicoStatus=" + ordemServicoStatus
				+ ", ordemServicoDataAbertura=" + ordemServicoDataAbertura + ", ordemServicoValor=" + ordemServicoValor
				+ "]";
	}

	
} 
