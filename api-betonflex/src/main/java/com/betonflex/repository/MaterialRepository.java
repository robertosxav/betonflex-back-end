package com.betonflex.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.betonflex.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>{

	@Query("SELECT m from Material m where m.materialAtivo = true")
	List<Material> listarTodosAtivos(); 
	
	@Query("SELECT m from Material m where m.materialAtivo = true")
	Page<Material> listarTodosAtivos(Pageable pageable);

	@Query("SELECT m from Material m "
			+ "where m.materialAtivo = true "
			+ "and(UPPER(m.materialNome) like concat('%',:pesquisa,'%') or UPPER(m.materialDescricao) like concat('%',:pesquisa,'%'))")
	Page<Material> buscaGenerica(String pesquisa, Pageable pageable);

	@Query("SELECT m from Material m "
			+ "inner join AlmoxarifadoMaterial am on am.material.materialId = m.materialId "
			+ "inner join Almoxarifado a on a.almoxarifadoId = am.almoxarifado.almoxarifadoId "
			+ "where a.almoxarifadoId = :almoxarifadoId")
	Page<Material> listarTodosMateriasAlmoxarifado(Long almoxarifadoId,Pageable pageable); 
	
} 