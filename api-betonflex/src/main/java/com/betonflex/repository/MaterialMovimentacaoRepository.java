package com.betonflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.betonflex.model.MaterialMovimentacao;

@Repository
public interface MaterialMovimentacaoRepository extends JpaRepository<MaterialMovimentacao, Long>{ 
	
} 