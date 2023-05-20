package com.betonflex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.betonflex.model.OrdemServicoCliente;

@Repository
public interface OrdemServicoClienteRepository extends JpaRepository<OrdemServicoCliente, Long>{

	@Query("SELECT osc FROM OrdemServicoCliente osc "
			+ "WHERE osc.cliente.clienteId = :clienteId "
			+ "and osc.ordemServico.ordemServicoId = :ordemServicoId")
	OrdemServicoCliente buscarPeloCLienteEOrdemServico(Long clienteId, Long ordemServicoId); 
	
} 