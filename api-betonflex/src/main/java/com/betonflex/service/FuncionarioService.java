package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.exceptions.BetonflexException;
import com.betonflex.model.Funcionario;
import com.betonflex.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario salvar(Funcionario funcionario) {
		funcionario.ativar();
		return funcionarioRepository.save(funcionario);
	}

	public Funcionario buscarPeloCodigo(Long codigo) {
		return funcionarioRepository
				.findById(codigo)
				.orElseThrow(()-> new BetonflexException("Id não encontrado"));	
	}

	public Funcionario atualizar(Long codigo, Funcionario funcionario) {
		Funcionario funcionarioSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(funcionario, funcionarioSave, "funcionarioId");
		return funcionarioRepository.save(funcionarioSave);
	}

	public Page<Funcionario> pesquisar(Pageable pageable){
		return funcionarioRepository.findAll(pageable);
	}

	public List<Funcionario> listarTodos() {
		return funcionarioRepository.findAll();
	}

	public List<Funcionario> listarTodosAtivos() {
		return funcionarioRepository.listarTodosAtivos();
	}

	public Page<Funcionario> listarTodosAtivos(Pageable pageable) {
		return funcionarioRepository.listarTodosAtivos(pageable);
	}
	
	public Page<Funcionario> buscaGenerica(String pesquisa, Pageable pageable) {
		return funcionarioRepository.buscaGenerica(pesquisa.toUpperCase(),pageable);
	}

	public void remover(Long codigo) {
		Funcionario funcionarioSave = buscarPeloCodigo(codigo);
		funcionarioSave.inativar();
		funcionarioRepository.save(funcionarioSave);
	}
}