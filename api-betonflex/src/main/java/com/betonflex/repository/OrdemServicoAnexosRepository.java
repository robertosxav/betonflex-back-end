package com.betonflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.betonflex.model.OrdemServicoAnexos;

@Repository
public interface OrdemServicoAnexosRepository extends JpaRepository<OrdemServicoAnexos, Long>{ 
	
} 