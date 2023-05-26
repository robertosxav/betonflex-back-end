package com.betonflex.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.betonflex.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	@Query("SELECT f FROM Funcionario f WHERE f.funcionarioAtivo = true")
	List<Funcionario> listarTodosAtivos(); 
	
	@Query("SELECT f FROM Funcionario f WHERE f.funcionarioAtivo = true")
	Page<Funcionario> listarTodosAtivos(Pageable pageable);

	@Query("SELECT f FROM Funcionario f "
			+ "WHERE f.funcionarioAtivo = true "
			+ "AND f.funcionarioNome like CONCAT('%',:pesquisa,'%')")
	Page<Funcionario> buscaGenerica(String pesquisa,Pageable pageable); 
	
} 