package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.exceptions.BetonflexException;
import com.betonflex.model.OrdemServico;
import com.betonflex.model.TipoServico;
import com.betonflex.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemservicoRepository;
	
	@Autowired
	private TipoServicoService tipoServicoService;

	public OrdemServico salvar(OrdemServico ordemservico) {
		validar(ordemservico);
		ordemservico.ativar();
		return ordemservicoRepository.save(ordemservico);
	}

	private void validar(OrdemServico ordemservico) {
		TipoServico tipoServico = tipoServicoService
				.buscarPeloCodigo(ordemservico.getTipoServico().getTipoServicoId());
		
		ordemservico.setTipoServico(tipoServico);
	}

	public OrdemServico buscarPeloCodigo(Long codigo) {
		OrdemServico ordemservicoSalva = ordemservicoRepository
				.findById(codigo)
				.orElseThrow(()-> new BetonflexException("Id não encontrado"));
		
		return ordemservicoSalva;
	}

	public OrdemServico atualizar(Long codigo, OrdemServico ordemservico) {
		OrdemServico ordemservicoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(ordemservico, ordemservicoSave, "ordemServicoId");
		return ordemservicoRepository.save(ordemservicoSave);
	}

	public Page<OrdemServico> pesquisar(Pageable pageable){
		return ordemservicoRepository.findAll(pageable);
	}

	public List<OrdemServico> listarTodos() {
		return ordemservicoRepository.findAll();
	}


	public Page<OrdemServico> buscaGenerica(String pesquisa, Pageable pageable) {
		return ordemservicoRepository.buscaGenerica(pesquisa.toUpperCase(),pageable);
	}

	public Page<OrdemServico> buscaTipoServico(Long tipoServicoId, Pageable pageable) {
		return ordemservicoRepository.findByTipoServicoTipoServicoId(tipoServicoId,pageable);
	}

	public Page<OrdemServico> listarTodasOrdemServicosCliente(Long clienteId, Pageable pageable) {
		return ordemservicoRepository.listarTodasOrdemServicosCliente(clienteId,pageable);
	}

}