package com.betonflex.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.betonflex.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("SELECT c from Cliente c "
			+ "where UPPER(c.clienteNome) like concat('%',:pesquisa,'%')")
	Page<Cliente> buscaGenerica(String pesquisa,Pageable pageable); 
	
} 