package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.model.OrdemServicoMaterial;
import com.betonflex.repository.OrdemServicoMaterialRepository;

@Service
public class OrdemServicoMaterialService {

	@Autowired
	private OrdemServicoMaterialRepository ordemservicomaterialRepository;

	public OrdemServicoMaterial salvar(OrdemServicoMaterial ordemservicomaterial) {
		return ordemservicomaterialRepository.save(ordemservicomaterial);
	}

	public OrdemServicoMaterial buscarPeloCodigo(Long codigo) {
		OrdemServicoMaterial ordemservicomaterialSalva = ordemservicomaterialRepository.findById(codigo).get();
		if (ordemservicomaterialSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return ordemservicomaterialSalva;
	}

	public OrdemServicoMaterial atualizar(Long codigo, OrdemServicoMaterial ordemservicomaterial) {
		OrdemServicoMaterial ordemservicomaterialSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(ordemservicomaterial, ordemservicomaterialSave, "ordemServicoMaterialId");
		return ordemservicomaterialRepository.save(ordemservicomaterialSave);
	}

	public Page<OrdemServicoMaterial> pesquisar(Pageable pageable){
		return ordemservicomaterialRepository.findAll(pageable);
	}

	public List<OrdemServicoMaterial> listarTodos() {
		return ordemservicomaterialRepository.findAll();
	}

	public void remover(Long codigo) {
		ordemservicomaterialRepository.deleteById(codigo);
	}

}