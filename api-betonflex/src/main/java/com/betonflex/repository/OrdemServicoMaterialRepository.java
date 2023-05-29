package com.betonflex.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.betonflex.model.OrdemServicoMaterial;

@Repository
public interface OrdemServicoMaterialRepository extends JpaRepository<OrdemServicoMaterial, Long>{

	@Query("SELECT osm FROM OrdemServicoMaterial osm "
			+ "WHERE osm.ordemServico.ordemServicoId = :ordemServicoId ")
	Page<OrdemServicoMaterial> buscarPelaOrdemServico(Long ordemServicoId, Pageable pageable); 
	
} 