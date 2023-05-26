package com.betonflex.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.exceptions.BetonflexException;
import com.betonflex.model.Cliente;
import com.betonflex.model.OrdemServico;
import com.betonflex.model.OrdemServicoCliente;
import com.betonflex.repository.OrdemServicoClienteRepository;

@Service
public class OrdemServicoClienteService {

	@Autowired
	private OrdemServicoClienteRepository ordemservicoclienteRepository;
	
	@Autowired
	private OrdemServicoService ordemServicoService;
	
	@Autowired
	private ClienteService clienteService;

	@Transactional
	public OrdemServicoCliente salvar(OrdemServicoCliente ordemServicocliente) {
		//OrdemServico ordemServico = ordemServicoService.buscarPeloCodigo(ordemServicocliente.getOrdemServico().getOrdemServicoId());
		//ordemServicocliente.setOrdemServico(ordemServico);
		OrdemServico ordemServico = ordemServicoService.salvar(ordemServicocliente.getOrdemServico());
		
		ordemServicocliente.setOrdemServico(ordemServico);
		Cliente cliente =  clienteService.buscarPeloCodigo(ordemServicocliente.getCliente().getClienteId());
		ordemServicocliente.setCliente(cliente);
		
		return ordemservicoclienteRepository.save(ordemServicocliente);
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