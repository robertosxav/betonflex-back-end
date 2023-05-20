package com.betonflex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.exceptions.BetonflexException;
import com.betonflex.model.OrdemServicoCliente;
import com.betonflex.repository.OrdemServicoClienteRepository;

@Service
public class OrdemServicoClienteService {

	@Autowired
	private OrdemServicoClienteRepository ordemservicoclienteRepository;

	public OrdemServicoCliente salvar(OrdemServicoCliente ordemservicocliente) {
		return ordemservicoclienteRepository.save(ordemservicocliente);
	}

	public OrdemServicoCliente buscarPeloCodigo(Long codigo) {
		return ordemservicoclienteRepository
				.findById(codigo)
				.orElseThrow(()-> new BetonflexException("Id não encontrado"));
	
	}
/*
	public OrdemServicoCliente atualizar(Long codigo, OrdemServicoCliente ordemservicocliente) {
		OrdemServicoCliente ordemservicoclienteSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(ordemservicocliente, ordemservicoclienteSave, "ordemServicoClienteId");
		return ordemservicoclienteRepository.save(ordemservicoclienteSave);
	}

	public Page<OrdemServicoCliente> pesquisar(Pageable pageable){
		return ordemservicoclienteRepository.findAll(pageable);
	}

	public List<OrdemServicoCliente> listarTodos() {
		return ordemservicoclienteRepository.findAll();
	}*/

	public void remover(Long codigo) {
		buscarPeloCodigo(codigo);
		ordemservicoclienteRepository.deleteById(codigo);
	}

	public OrdemServicoCliente buscarPeloCLienteEOrdemServico(Long clienteId, Long ordemServicoId) {
		return ordemservicoclienteRepository.buscarPeloCLienteEOrdemServico(clienteId,ordemServicoId);
	}
	
	public Page<OrdemServicoCliente> buscarPeloCiente(Long clienteId, Pageable pageable) {
		return ordemservicoclienteRepository.buscarPeloCiente(clienteId,pageable);
	}

}