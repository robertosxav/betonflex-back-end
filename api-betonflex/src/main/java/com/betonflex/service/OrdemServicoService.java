package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.model.OrdemServico;
import com.betonflex.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemservicoRepository;

	public OrdemServico salvar(OrdemServico ordemservico) {
		return ordemservicoRepository.save(ordemservico);
	}

	public OrdemServico buscarPeloCodigo(Long codigo) {
		OrdemServico ordemservicoSalva = ordemservicoRepository.findById(codigo).get();
		if (ordemservicoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
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

	public void remover(Long codigo) {
		ordemservicoRepository.deleteById(codigo);
	}

}