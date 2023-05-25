package com.betonflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.betonflex.model.OrdemServicoMaterial;

@Repository
public interface OrdemServicoMaterialRepository extends JpaRepository<OrdemServicoMaterial, Long>{ 
	
} 