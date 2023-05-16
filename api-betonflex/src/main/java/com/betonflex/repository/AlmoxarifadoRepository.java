package com.betonflex.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.betonflex.model.Almoxarifado;

@Repository
public interface AlmoxarifadoRepository extends JpaRepository<Almoxarifado, Long>{

	@Query("SELECT a from Almoxarifado a where a.almoxarifadoAtivo = true")
	List<Almoxarifado> listarTodosAtivos(); 
	
	@Query("SELECT a from Almoxarifado a where a.almoxarifadoAtivo = true")
	Page<Almoxarifado> listarTodosAtivos(Pageable pageable);

	@Query("SELECT a from Almoxarifado a "
			+ "where a.almoxarifadoAtivo = true "
			+ "and UPPER(a.almoxarifadoNome) like concat('%',:pesquisa,'%')")
	Page<Almoxarifado> buscaGenerica(String pesquisa, Pageable pageable); 
	
} 