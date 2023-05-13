package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.exceptions.BetonflexException;
import com.betonflex.model.AlmoxarifadoMaterial;
import com.betonflex.repository.AlmoxarifadoMaterialRepository;

@Service
public class AlmoxarifadoMaterialService {

	@Autowired
	private AlmoxarifadoMaterialRepository almoxarifadomaterialRepository;

	public AlmoxarifadoMaterial salvar(AlmoxarifadoMaterial almoxarifadomaterial) {
		return almoxarifadomaterialRepository.save(almoxarifadomaterial);
	}

	public AlmoxarifadoMaterial buscarPeloCodigo(Long codigo) {
		AlmoxarifadoMaterial almoxarifadomaterialSalva = almoxarifadomaterialRepository
				.findById(codigo)
				.orElseThrow(()->new BetonflexException("Id não encontrado"));
		
		return almoxarifadomaterialSalva;
	}

	public AlmoxarifadoMaterial atualizar(Long codigo, AlmoxarifadoMaterial almoxarifadomaterial) {
		AlmoxarifadoMaterial almoxarifadomaterialSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(almoxarifadomaterial, almoxarifadomaterialSave, "almoxarifadoMaterialId");
		return almoxarifadomaterialRepository.save(almoxarifadomaterialSave);
	}

	public Page<AlmoxarifadoMaterial> pesquisar(Pageable pageable){
		return almoxarifadomaterialRepository.findAll(pageable);
	}

	public List<AlmoxarifadoMaterial> listarTodos() {
		return almoxarifadomaterialRepository.findAll();
	}

	public void remover(Long codigo) {
		//AlmoxarifadoMaterial almoxarifadomaterialSave = buscarPeloCodigo(codigo);
	}

}