package com.betonflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.betonflex.model.Almoxarifado;

@Repository
public interface AlmoxarifadoRepository extends JpaRepository<Almoxarifado, Long>{ 
	
} 