package com.betonflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.betonflex.model.TipoServico;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServico, Long>{ 
	
} 