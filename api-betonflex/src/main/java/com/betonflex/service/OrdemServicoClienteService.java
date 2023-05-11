package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
		OrdemServicoCliente ordemservicoclienteSalva = ordemservicoclienteRepository.findById(codigo).get();
		if (ordemservicoclienteSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return ordemservicoclienteSalva;
	}

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
	}

	public void remover(Long codigo) {
		ordemservicoclienteRepository.deleteById(codigo);
	}

}