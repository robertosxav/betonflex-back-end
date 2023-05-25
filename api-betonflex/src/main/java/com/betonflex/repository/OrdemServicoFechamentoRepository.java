package com.betonflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.betonflex.model.OrdemServicoFechamento;

@Repository
public interface OrdemServicoFechamentoRepository extends JpaRepository<OrdemServicoFechamento, Long>{ 
	
} 