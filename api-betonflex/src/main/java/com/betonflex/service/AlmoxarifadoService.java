package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.model.Almoxarifado;
import com.betonflex.repository.AlmoxarifadoRepository;

@Service
public class AlmoxarifadoService {

	@Autowired
	private AlmoxarifadoRepository almoxarifadoRepository;

	public Almoxarifado salvar(Almoxarifado almoxarifado) {
		return almoxarifadoRepository.save(almoxarifado);
	}

	public Almoxarifado buscarPeloCodigo(Long codigo) {
		Almoxarifado almoxarifadoSalva = almoxarifadoRepository.findById(codigo).get();
		if (almoxarifadoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return almoxarifadoSalva;
	}

	public Almoxarifado atualizar(Long codigo, Almoxarifado almoxarifado) {
		Almoxarifado almoxarifadoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(almoxarifado, almoxarifadoSave, "almoxarifadoId");
		return almoxarifadoRepository.save(almoxarifadoSave);
	}

	public Page<Almoxarifado> pesquisar(Pageable pageable){
		return almoxarifadoRepository.findAll(pageable);
	}

	public List<Almoxarifado> listarTodos() {
		return almoxarifadoRepository.findAll();
	}

	public void remover(Long codigo) {
		almoxarifadoRepository.deleteById(codigo);
	}

}