package com.betonflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.betonflex.model.OrdemServicoCliente;

@Repository
public interface OrdemServicoClienteRepository extends JpaRepository<OrdemServicoCliente, Long>{ 
	
} 