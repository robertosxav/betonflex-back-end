package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.model.OrdemServicoFechamento;
import com.betonflex.repository.OrdemServicoFechamentoRepository;

@Service
public class OrdemServicoFechamentoService {

	@Autowired
	private OrdemServicoFechamentoRepository ordemservicofechamentoRepository;

	public OrdemServicoFechamento salvar(OrdemServicoFechamento ordemservicofechamento) {
		return ordemservicofechamentoRepository.save(ordemservicofechamento);
	}

	public OrdemServicoFechamento buscarPeloCodigo(Long codigo) {
		OrdemServicoFechamento ordemservicofechamentoSalva = ordemservicofechamentoRepository.findById(codigo).get();
		if (ordemservicofechamentoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return ordemservicofechamentoSalva;
	}

	public OrdemServicoFechamento atualizar(Long codigo, OrdemServicoFechamento ordemservicofechamento) {
		OrdemServicoFechamento ordemservicofechamentoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(ordemservicofechamento, ordemservicofechamentoSave, "ordemServicoFechamentoId");
		return ordemservicofechamentoRepository.save(ordemservicofechamentoSave);
	}

	public Page<OrdemServicoFechamento> pesquisar(Pageable pageable){
		return ordemservicofechamentoRepository.findAll(pageable);
	}

	public List<OrdemServicoFechamento> listarTodos() {
		return ordemservicofechamentoRepository.findAll();
	}

	public void remover(Long codigo) {
		ordemservicofechamentoRepository.deleteById(codigo);
	}

}