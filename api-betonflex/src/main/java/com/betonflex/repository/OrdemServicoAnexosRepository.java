package com.betonflex.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.betonflex.model.OrdemServicoAnexos;

@Repository
public interface OrdemServicoAnexosRepository extends JpaRepository<OrdemServicoAnexos, Long>{
	
	@Query("SELECT osa FROM OrdemServicoAnexos osa where osa.ordemServico.ordemServicoId = :ordemServicoId")
	Page<OrdemServicoAnexos> listarAnexosOrdemServico(Long ordemServicoId, Pageable pageable); 
	
} 