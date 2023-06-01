package com.betonflex.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.betonflex.model.Cliente;
import com.betonflex.model.Material;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Query("SELECT c from Cliente c "
			+ "where UPPER(c.clienteNome) like concat('%',:pesquisa,'%') and clienteAtivo = true")
	Page<Cliente> buscaGenerica(String pesquisa,Pageable pageable);

	@Query(nativeQuery = true, value = " SELECT c.* from cliente c "
			+ " where c.cliente_id not in ( select osc.cliente_id from ordem_servico_cliente osc "
			+ " INNER JOIN ordem_servico os ON os.ordem_servico_id = osc.ordem_servico_id "
			+ " INNER JOIN cliente c2 ON c2.cliente_id = osc.cliente_id "
			+ "	where os.ordem_servico_id = :ordemServicoId "
			+ ")")
	List<Cliente> buscarTodosClientesNaoEstaoNaOrdemServicoOrdemServico(Long ordemServicoId);

	@Query("SELECT c from Cliente c where clienteAtivo = true")
	List<Cliente> listarTodosAtivos();

	@Query("SELECT c from Cliente c where clienteAtivo = true")
	Page<Cliente> listarTodosAtivos(Pageable pageable); 
	
} 