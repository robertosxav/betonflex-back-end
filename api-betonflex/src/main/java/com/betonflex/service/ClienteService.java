package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.model.Cliente;
import com.betonflex.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public Cliente buscarPeloCodigo(Long codigo) {
		Cliente clienteSalva = clienteRepository.findById(codigo).get();
		if (clienteSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return clienteSalva;
	}

	public Cliente atualizar(Long codigo, Cliente cliente) {
		Cliente clienteSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(cliente, clienteSave, "clienteId");
		return clienteRepository.save(clienteSave);
	}

	public Page<Cliente> pesquisar(Pageable pageable){
		return clienteRepository.findAll(pageable);
	}

	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public void remover(Long codigo) {
		clienteRepository.deleteById(codigo);
	}

}