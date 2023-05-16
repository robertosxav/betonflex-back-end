package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.exceptions.BetonflexException;
import com.betonflex.model.TipoServico;
import com.betonflex.repository.TipoServicoRepository;

@Service
public class TipoServicoService {

	@Autowired
	private TipoServicoRepository tiposervicoRepository;

	public TipoServico salvar(TipoServico tiposervico) {
		tiposervico.ativar();
		return tiposervicoRepository.save(tiposervico);
	}

	public TipoServico buscarPeloCodigo(Long codigo) {
		TipoServico tiposervicoSalva = tiposervicoRepository
				.findById(codigo)
				.orElseThrow(()-> new BetonflexException("Id não encontrado"));
		return tiposervicoSalva;
	}

	public TipoServico atualizar(Long codigo, TipoServico tiposervico) {
		TipoServico tiposervicoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(tiposervico, tiposervicoSave, "tipoServicoId","tipoServicoCreateat");
		return tiposervicoRepository.save(tiposervicoSave);
	}

	public Page<TipoServico> pesquisar(Pageable pageable){
		return tiposervicoRepository.findAll(pageable);
	}

	public List<TipoServico> listarTodos() {
		return tiposervicoRepository.findAll();
	}
	
	public List<TipoServico> listarTodosAtivos() {
		return tiposervicoRepository.listarTodosAtivos();
	}
	
	public Page<TipoServico> listarTodosAtivos(Pageable pageable) {
		return tiposervicoRepository.listarTodosAtivos(pageable);
	}

	public Page<TipoServico> buscaGenerica(String pesquisa, Pageable pageable) {
		return tiposervicoRepository.buscaGenerica(pesquisa.toUpperCase(),pageable);
	}

	public void remover(Long codigo) {
		TipoServico tipoServicoSalvo = buscarPeloCodigo(codigo);
		tipoServicoSalvo.inativar();
		tiposervicoRepository.save(tipoServicoSalvo);
	}

}