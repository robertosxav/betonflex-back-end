package com.betonflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.betonflex.model.AlmoxarifadoMaterial;

@Repository
public interface AlmoxarifadoMaterialRepository extends JpaRepository<AlmoxarifadoMaterial, Long>{ 
	
} 