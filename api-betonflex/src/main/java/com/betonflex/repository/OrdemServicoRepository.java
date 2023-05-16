package com.betonflex.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.betonflex.model.OrdemServico;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>{ 
	
	@Query("SELECT p from OrdemServico p where UPPER(p.ordemServicoNumero) like concat('%',:pesquisa,'%')")
	Page<OrdemServico> buscaGenerica(String pesquisa, Pageable pageable);

	Page<OrdemServico> findByTipoServicoTipoServicoId(Long tipoServicoId, Pageable pageable); 
} 