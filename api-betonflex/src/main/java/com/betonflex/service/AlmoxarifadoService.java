package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.exceptions.BetonflexException;
import com.betonflex.model.Almoxarifado;
import com.betonflex.repository.AlmoxarifadoRepository;

@Service
public class AlmoxarifadoService {

	@Autowired
	private AlmoxarifadoRepository almoxarifadoRepository;

	public Almoxarifado salvar(Almoxarifado almoxarifado) {
		almoxarifado.ativar();
		return almoxarifadoRepository.save(almoxarifado);
	}

	public Almoxarifado buscarPeloCodigo(Long codigo) {
		Almoxarifado almoxarifadoSalva = almoxarifadoRepository
				.findById(codigo)
				.orElseThrow(()-> new BetonflexException("Id não encontrado"));
		
		return almoxarifadoSalva;
	}

	public Almoxarifado atualizar(Long codigo, Almoxarifado almoxarifado) {
		Almoxarifado almoxarifadoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(almoxarifado, almoxarifadoSave, "almoxarifadoId","almoxarifadoCreateat");
		return almoxarifadoRepository.save(almoxarifadoSave);
	}

	public Page<Almoxarifado> pesquisar(Pageable pageable){
		return almoxarifadoRepository.findAll(pageable);
	}

	public List<Almoxarifado> listarTodos() {
		return almoxarifadoRepository.findAll();
	}
	
	public List<Almoxarifado> listarTodosAtivos() {
		return almoxarifadoRepository.listarTodosAtivos();
	}
	
	public Page<Almoxarifado> listarTodosAtivos(Pageable pageable) {
		return almoxarifadoRepository.listarTodosAtivos(pageable);
	}

	public Page<Almoxarifado> buscaGenerica(String pesquisa, Pageable pageable) {
		return almoxarifadoRepository.buscaGenerica(pesquisa.toUpperCase(),pageable);
	}
	
	public void remover(Long codigo) {
		Almoxarifado almoxarifadoSave = buscarPeloCodigo(codigo);
		almoxarifadoSave.inativar();
		almoxarifadoRepository.save(almoxarifadoSave);
	}
}