package com.betonflex.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "ordem_servico_produto",schema="public") 
public class OrdemServicoProduto implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ordem_servico_produto")
	private Long ordemServicoProduto;

	@Column(name = "ordem_servico_id")
	private Integer ordemServicoId;

	@Column(name = "ordem_servico_produto_dimensao")
	private String ordemServicoProdutoDimensao;

	@Column(name = "ordem_servico_produto_data_con")
	private String ordemServicoProdutoDataCon;

	@Column(name = "ordem_servico_produto_traco")
	private String ordemServicoProdutoTraco;

	@Column(name = "ordem_servico_produto_resisten")
	private String ordemServicoProdutoResisten;

	@Column(name = "ordem_servico_produto_laudo")
	private String ordemServicoProdutoLaudo;

	public Long getOrdemServicoProduto() {
		return ordemServicoProduto;
	}
	 
	public void setOrdemServicoProduto(Long ordemServicoProduto) {
		this.ordemServicoProduto = ordemServicoProduto;
	}
	 
	public Integer getOrdemServicoId() {
		return ordemServicoId;
	}
	 
	public void setOrdemServicoId(Integer ordemServicoId) {
		this.ordemServicoId = ordemServicoId;
	}
	 
	public String getOrdemServicoProdutoDimensao() {
		return ordemServicoProdutoDimensao;
	}
	 
	public void setOrdemServicoProdutoDimensao(String ordemServicoProdutoDimensao) {
		this.ordemServicoProdutoDimensao = ordemServicoProdutoDimensao;
	}
	 
	public String getOrdemServicoProdutoDataCon() {
		return ordemServicoProdutoDataCon;
	}
	 
	public void setOrdemServicoProdutoDataCon(String ordemServicoProdutoDataCon) {
		this.ordemServicoProdutoDataCon = ordemServicoProdutoDataCon;
	}
	 
	public String getOrdemServicoProdutoTraco() {
		return ordemServicoProdutoTraco;
	}
	 
	public void setOrdemServicoProdutoTraco(String ordemServicoProdutoTraco) {
		this.ordemServicoProdutoTraco = ordemServicoProdutoTraco;
	}
	 
	public String getOrdemServicoProdutoResisten() {
		return ordemServicoProdutoResisten;
	}
	 
	public void setOrdemServicoProdutoResisten(String ordemServicoProdutoResisten) {
		this.ordemServicoProdutoResisten = ordemServicoProdutoResisten;
	}
	 
	public String getOrdemServicoProdutoLaudo() {
		return ordemServicoProdutoLaudo;
	}
	 
	public void setOrdemServicoProdutoLaudo(String ordemServicoProdutoLaudo) {
		this.ordemServicoProdutoLaudo = ordemServicoProdutoLaudo;
	}
	 

} 
