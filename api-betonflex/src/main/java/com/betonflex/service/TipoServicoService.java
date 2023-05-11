package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.model.TipoServico;
import com.betonflex.repository.TipoServicoRepository;

@Service
public class TipoServicoService {

	@Autowired
	private TipoServicoRepository tiposervicoRepository;

	public TipoServico salvar(TipoServico tiposervico) {
		return tiposervicoRepository.save(tiposervico);
	}

	public TipoServico buscarPeloCodigo(Long codigo) {
		TipoServico tiposervicoSalva = tiposervicoRepository.findById(codigo).get();
		if (tiposervicoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return tiposervicoSalva;
	}

	public TipoServico atualizar(Long codigo, TipoServico tiposervico) {
		TipoServico tiposervicoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(tiposervico, tiposervicoSave, "tipoServicoId");
		return tiposervicoRepository.save(tiposervicoSave);
	}

	public Page<TipoServico> pesquisar(Pageable pageable){
		return tiposervicoRepository.findAll(pageable);
	}

	public List<TipoServico> listarTodos() {
		return tiposervicoRepository.findAll();
	}

	public void remover(Long codigo) {
		tiposervicoRepository.deleteById(codigo);
	}

}