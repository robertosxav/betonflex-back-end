package com.betonflex.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.exceptions.BetonflexException;
import com.betonflex.model.Almoxarifado;
import com.betonflex.model.AlmoxarifadoMaterial;
import com.betonflex.model.Material;
import com.betonflex.repository.AlmoxarifadoMaterialRepository;

@Service
public class AlmoxarifadoMaterialService{

	@Autowired
	private AlmoxarifadoMaterialRepository almoxarifadomaterialRepository;
	
	@Autowired
	private AlmoxarifadoService almoxarifadoService;
	
	@Autowired
	private MaterialService materialService;
/*
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
	}*/
	public AlmoxarifadoMaterial salvar(AlmoxarifadoMaterial almoxarifadomaterial) {
		Material material = materialService.buscarPeloCodigo(almoxarifadomaterial.getMaterial().getMaterialId());
		almoxarifadomaterial.setMaterial(material);
		almoxarifadomaterial.setData(LocalDate.now());
		
		Almoxarifado almoxarifado = almoxarifadoService.buscarPeloCodigo(almoxarifadomaterial.getAlmoxarifado().getAlmoxarifadoId());
		almoxarifadomaterial.setAlmoxarifado(almoxarifado);
		
		return almoxarifadomaterialRepository.save(almoxarifadomaterial);
	}

	
	public AlmoxarifadoMaterial buscarPeloCodigo(Long codigo) {
		
		return almoxarifadomaterialRepository
				.findById(codigo)
				.orElseThrow(()-> new BetonflexException("Id não encontrado"));
		
	}

	public void remover(Long codigo) {
		AlmoxarifadoMaterial almoxarifadomaterialSave = buscarPeloCodigo(codigo);
		almoxarifadomaterialRepository.deleteById(codigo);
	}
	
	
	public AlmoxarifadoMaterial buscarPeloAlmoxarifadoEMaterial(Long materialId,Long almoxarifadoId) {
		return almoxarifadomaterialRepository.buscarPeloAlmoxarifadoEMaterial(materialId,almoxarifadoId);
				
	}

	public List<AlmoxarifadoMaterial> buscarPeloAlmoxarifado(Long almoxarifadoId) {
		return almoxarifadomaterialRepository.buscarPeloAlmoxarifado(almoxarifadoId);
	}

	public Page<AlmoxarifadoMaterial> buscarPeloAlmoxarifado(Long almoxarifadoId, Pageable pageable) {
		return almoxarifadomaterialRepository.buscarPeloAlmoxarifado(almoxarifadoId,pageable);
	}

}