package com.betonflex.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.betonflex.model.AlmoxarifadoMaterial;

@Repository
public interface AlmoxarifadoMaterialRepository extends JpaRepository<AlmoxarifadoMaterial, Long>{

	@Query("SELECT am FROM AlmoxarifadoMaterial am WHERE am.material.materialId =:materialId and am.almoxarifado.almoxarifadoId = :almoxarifadoId")
	AlmoxarifadoMaterial buscarPeloAlmoxarifadoEMaterial(Long materialId, Long almoxarifadoId); 
	
	@Query("SELECT distinct am FROM AlmoxarifadoMaterial am where am.almoxarifado.almoxarifadoId = :almoxarifadoId")
	List<AlmoxarifadoMaterial> buscarPeloAlmoxarifado(Long almoxarifadoId);
	
	@Query("SELECT distinct am FROM AlmoxarifadoMaterial am where am.almoxarifado.almoxarifadoId = :almoxarifadoId")
	Page<AlmoxarifadoMaterial> buscarPeloAlmoxarifado(Long almoxarifadoId, Pageable pageable);

	
	
} 