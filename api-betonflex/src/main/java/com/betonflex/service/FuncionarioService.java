package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.model.Funcionario;
import com.betonflex.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public Funcionario buscarPeloCodigo(Long codigo) {
		Funcionario funcionarioSalva = funcionarioRepository.findById(codigo).get();
		if (funcionarioSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return funcionarioSalva;
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

	public void remover(Long codigo) {
		funcionarioRepository.deleteById(codigo);
	}

}