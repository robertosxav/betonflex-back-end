package com.betonflex.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.betonflex.model.TipoServico;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServico, Long>{ 
	@Query("SELECT t from TipoServico t where t.tipoServicoAtivo = true")
	List<TipoServico> listarTodosAtivos(); 
	
	@Query("SELECT t from TipoServico t where t.tipoServicoAtivo = true")
	Page<TipoServico> listarTodosAtivos(Pageable pageable);

	@Query("SELECT t from TipoServico t "
			+ "where t.tipoServicoAtivo = true "
			+ "and (UPPER(t.tipoServicoNome) like concat('%',:pesquisa,'%') or UPPER(t.tipoServicoDescricao) like concat('%',:pesquisa,'%'))")
	Page<TipoServico> buscaGenerica(String pesquisa, Pageable pageable); 
} 