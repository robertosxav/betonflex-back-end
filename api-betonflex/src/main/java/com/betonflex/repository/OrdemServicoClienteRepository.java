package com.betonflex.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	
	@Query("SELECT osc FROM OrdemServicoCliente osc "
			+ "WHERE osc.cliente.clienteId = :clienteId ")
	Page<OrdemServicoCliente> buscarPeloCiente(Long clienteId, Pageable pageable);

	@Query("SELECT osc FROM OrdemServicoCliente osc "
			+ "WHERE osc.ordemServico.ordemServicoId = :ordemServicoId ")
	Page<OrdemServicoCliente> buscarPelaOrdemServico(Long ordemServicoId, Pageable pageable);
	
} 