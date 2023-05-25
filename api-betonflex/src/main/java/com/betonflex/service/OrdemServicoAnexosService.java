package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.model.OrdemServicoAnexos;
import com.betonflex.repository.OrdemServicoAnexosRepository;

@Service
public class OrdemServicoAnexosService {

	@Autowired
	private OrdemServicoAnexosRepository ordemservicoanexosRepository;

	public OrdemServicoAnexos salvar(OrdemServicoAnexos ordemservicoanexos) {
		return ordemservicoanexosRepository.save(ordemservicoanexos);
	}

	public OrdemServicoAnexos buscarPeloCodigo(Long codigo) {
		OrdemServicoAnexos ordemservicoanexosSalva = ordemservicoanexosRepository.findById(codigo).get();
		if (ordemservicoanexosSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return ordemservicoanexosSalva;
	}

	public OrdemServicoAnexos atualizar(Long codigo, OrdemServicoAnexos ordemservicoanexos) {
		OrdemServicoAnexos ordemservicoanexosSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(ordemservicoanexos, ordemservicoanexosSave, "ordemServicoAnexoId");
		return ordemservicoanexosRepository.save(ordemservicoanexosSave);
	}

	public Page<OrdemServicoAnexos> pesquisar(Pageable pageable){
		return ordemservicoanexosRepository.findAll(pageable);
	}

	public List<OrdemServicoAnexos> listarTodos() {
		return ordemservicoanexosRepository.findAll();
	}

	public void remover(Long codigo) {
		ordemservicoanexosRepository.deleteById(codigo);
	}

}