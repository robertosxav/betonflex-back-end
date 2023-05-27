package com.betonflex.model;

import java.io.Serializable;
import java.util.Objects;

import com.betonflex.model.enuns.ContentTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "ordem_servico_anexos", schema = "public") 
public class OrdemServicoAnexos implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ordem_servico_anexo_id")
	private Long ordemServicoAnexoId;

	@ManyToOne()
	@JoinColumn(name = "ordem_servico_id",referencedColumnName = "ordem_servico_id")
	private OrdemServico ordemServico;

	@Column(name = "ordem_servico_anexo_arq")
	private byte[] ordemServicoAnexoArq;

	@Column(name = "ordem_servico_anexo_arq_tipo")
	private String ordemServicoAnexoArqTipo;

	@Column(name = "ordem_servico_anexo_arq_nome")
	private String ordemServicoAnexoArqNome;

	public Long getOrdemServicoAnexoId() {
		return ordemServicoAnexoId;
	}
	 
	public void setOrdemServicoAnexoId(Long ordemServicoAnexoId) {
		this.ordemServicoAnexoId = ordemServicoAnexoId;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}


	public byte[] getOrdemServicoAnexoArq() {
		return ordemServicoAnexoArq;
	}

	public void setOrdemServicoAnexoArq(byte[] ordemServicoAnexoArq) {
		this.ordemServicoAnexoArq = ordemServicoAnexoArq;
	}

	public String getOrdemServicoAnexoArqTipo() {
		return ordemServicoAnexoArqTipo;
	}

	public void setOrdemServicoAnexoArqTipo(String ordemServicoAnexoArqTipo) {
		this.ordemServicoAnexoArqTipo = ordemServicoAnexoArqTipo;
	}

	public String getOrdemServicoAnexoArqNome() {
		return ordemServicoAnexoArqNome;
	}

	public void setOrdemServicoAnexoArqNome(String ordemServicoAnexoArqNome) {
		this.ordemServicoAnexoArqNome = ordemServicoAnexoArqNome;
	}
	
	public String getContentType() {
		ContentTypeEnum contentTypeEnum = ContentTypeEnum.toEnum(this.getOrdemServicoAnexoArqTipo());
		return contentTypeEnum.getMimeType();
	}

	public OrdemServicoAnexos() {
		super();
	}

	public OrdemServicoAnexos(Long ordemServicoAnexoId, OrdemServico ordemServico, byte[] ordemServicoAnexoArq,
			String ordemServicoAnexoArqTipo, String ordemServicoAnexoArqNome) {
		super();
		this.ordemServicoAnexoId = ordemServicoAnexoId;
		this.ordemServico = ordemServico;
		this.ordemServicoAnexoArq = ordemServicoAnexoArq;
		this.ordemServicoAnexoArqTipo = ordemServicoAnexoArqTipo;
		this.ordemServicoAnexoArqNome = ordemServicoAnexoArqNome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ordemServicoAnexoId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemServicoAnexos other = (OrdemServicoAnexos) obj;
		return Objects.equals(ordemServicoAnexoId, other.ordemServicoAnexoId);
	}

	@Override
	public String toString() {
		return "OrdemServicoAnexos [ordemServicoAnexoId=" + ordemServicoAnexoId + ", ordemServico=" + ordemServico
				+ ", ordemServicoAnexoArq=" + ordemServicoAnexoArq + ", ordemServicoAnexoArqTipo="
				+ ordemServicoAnexoArqTipo + ", ordemServicoAnexoArqNome=" + ordemServicoAnexoArqNome + "]";
	}

} 
