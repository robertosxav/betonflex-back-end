package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.model.MaterialMovimentacao;
import com.betonflex.repository.MaterialMovimentacaoRepository;

@Service
public class MaterialMovimentacaoService {

	@Autowired
	private MaterialMovimentacaoRepository materialmovimentacaoRepository;

	public MaterialMovimentacao salvar(MaterialMovimentacao materialmovimentacao) {
		return materialmovimentacaoRepository.save(materialmovimentacao);
	}

	public MaterialMovimentacao buscarPeloCodigo(Long codigo) {
		MaterialMovimentacao materialmovimentacaoSalva = materialmovimentacaoRepository.findById(codigo).get();
		if (materialmovimentacaoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return materialmovimentacaoSalva;
	}

	public MaterialMovimentacao atualizar(Long codigo, MaterialMovimentacao materialmovimentacao) {
		MaterialMovimentacao materialmovimentacaoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(materialmovimentacao, materialmovimentacaoSave, "materialMovimentacaoId");
		return materialmovimentacaoRepository.save(materialmovimentacaoSave);
	}

	public Page<MaterialMovimentacao> pesquisar(Pageable pageable){
		return materialmovimentacaoRepository.findAll(pageable);
	}

	public List<MaterialMovimentacao> listarTodos() {
		return materialmovimentacaoRepository.findAll();
	}

	public void remover(Long codigo) {
		materialmovimentacaoRepository.deleteById(codigo);
	}

}