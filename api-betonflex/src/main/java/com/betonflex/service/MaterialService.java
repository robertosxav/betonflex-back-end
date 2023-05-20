package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.exceptions.BetonflexException;
import com.betonflex.model.Material;
import com.betonflex.repository.MaterialRepository;

@Service
public class MaterialService {

	@Autowired
	private MaterialRepository materialRepository;

	public Material salvar(Material material) {
		material.ativar();
		return materialRepository.save(material);
	}

	public Material buscarPeloCodigo(Long codigo) {
		Material materialSalva = materialRepository
				.findById(codigo)
				.orElseThrow(()-> new BetonflexException("Id não encontrado"));
		
		return materialSalva;
	}

	public Material atualizar(Long codigo, Material material) {
		Material materialSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(material, materialSave, "materialId","materialCreateat");
		return materialRepository.save(materialSave);
	}

	public Page<Material> pesquisar(Pageable pageable){
		return materialRepository.findAll(pageable);
	}

	public List<Material> listarTodos() {
		return materialRepository.findAll();
	}

	public void remover(Long codigo) {
		Material materialSalvo = buscarPeloCodigo(codigo);
		materialSalvo.inativar();
		materialRepository.save(materialSalvo);
	}

	public List<Material> listarTodosAtivos() {
		return materialRepository.listarTodosAtivos();
	}
	
	public Page<Material> listarTodosAtivos(Pageable pageable) {
		return materialRepository.listarTodosAtivos(pageable);
	}
	public Page<Material> buscaGenerica(String pesquisa, Pageable pageable) {
		return materialRepository.buscaGenerica(pesquisa.toUpperCase(),pageable);
	}

	public Page<Material> listarTodosMateriasAlmoxarifado(Long almoxarifadoId,Pageable pageable) {
		return materialRepository.listarTodosMateriasAlmoxarifado(almoxarifadoId, pageable);
	}

	public List<Material> listarTodosMateriasQueNaPertencemAlmoxarifado(Long almoxarifadoId) {
		return materialRepository.listarTodosMateriasQueNaPertencemAlmoxarifado(almoxarifadoId);
	}

}