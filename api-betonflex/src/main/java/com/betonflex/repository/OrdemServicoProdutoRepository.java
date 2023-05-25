package com.betonflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.betonflex.model.OrdemServicoProduto;

@Repository
public interface OrdemServicoProdutoRepository extends JpaRepository<OrdemServicoProduto, Long>{ 
	
} 