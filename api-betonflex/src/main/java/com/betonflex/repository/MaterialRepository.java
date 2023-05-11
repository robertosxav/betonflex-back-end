package com.betonflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.betonflex.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>{ 
	
} 