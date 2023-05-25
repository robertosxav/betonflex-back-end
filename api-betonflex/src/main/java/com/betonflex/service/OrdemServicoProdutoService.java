package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.model.OrdemServicoProduto;
import com.betonflex.repository.OrdemServicoProdutoRepository;

@Service
public class OrdemServicoProdutoService {

	@Autowired
	private OrdemServicoProdutoRepository ordemservicoprodutoRepository;

	public OrdemServicoProduto salvar(OrdemServicoProduto ordemservicoproduto) {
		return ordemservicoprodutoRepository.save(ordemservicoproduto);
	}

	public OrdemServicoProduto buscarPeloCodigo(Long codigo) {
		OrdemServicoProduto ordemservicoprodutoSalva = ordemservicoprodutoRepository.findById(codigo).get();
		if (ordemservicoprodutoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return ordemservicoprodutoSalva;
	}

	public OrdemServicoProduto atualizar(Long codigo, OrdemServicoProduto ordemservicoproduto) {
		OrdemServicoProduto ordemservicoprodutoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(ordemservicoproduto, ordemservicoprodutoSave, "ordemServicoProduto");
		return ordemservicoprodutoRepository.save(ordemservicoprodutoSave);
	}

	public Page<OrdemServicoProduto> pesquisar(Pageable pageable){
		return ordemservicoprodutoRepository.findAll(pageable);
	}

	public List<OrdemServicoProduto> listarTodos() {
		return ordemservicoprodutoRepository.findAll();
	}

	public void remover(Long codigo) {
		ordemservicoprodutoRepository.deleteById(codigo);
	}

}