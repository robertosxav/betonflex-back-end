package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.exceptions.BetonflexException;
import com.betonflex.model.Cliente;
import com.betonflex.model.OrdemServico;
import com.betonflex.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	/*@Autowired
	private OrdemServicoService ordemServicoService;
	
	@Autowired
	private OrdemServicoClienteService ordemServicoClienteService;*/

	public Cliente salvar(Cliente cliente) {
		cliente.ativar();
		return clienteRepository.save(cliente);
	}

	public Cliente buscarPeloCodigo(Long codigo) {
		Cliente clienteSalva = clienteRepository.findById(codigo)
				.orElseThrow(() -> new BetonflexException("Id não encontrado"));

		return clienteSalva;
	}

	public Cliente atualizar(Long codigo, Cliente cliente) {
		Cliente clienteSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(cliente, clienteSave, "clienteId", "clienteCreateat");
		return clienteRepository.save(clienteSave);
	}

	public Page<Cliente> pesquisar(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}

	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public Page<Cliente> buscaGenerica(String pesquisa, Pageable pageable) {
		return clienteRepository.buscaGenerica(pesquisa, pageable);
	}

	public void adicionarOrdensServicos(Long codigo, List<OrdemServico> listaOrdensServico) {
		/*Cliente clienteSave = buscarPeloCodigo(codigo);

		// adicionarMateriais
		for (OrdemServico ordemServico : listaOrdensServico) {
			OrdemServicoCliente ordemServicoClienteBanco = ordemServicoClienteService.buscarPeloCLienteEOrdemServico(codigo,ordemServico.getOrdemServicoId());
			if (ordemServicoClienteBanco != null) {
				continue;
			} else {
				OrdemServico ordemServicoBanco = ordemServicoService.buscarPeloCodigo(ordemServico.getOrdemServicoId());
				OrdemServicoCliente ordemServicoCliente = new OrdemServicoCliente(clienteSave, ordemServicoBanco);
				ordemServicoClienteService.salvar(ordemServicoCliente);
			}
		}*/

	}


	public List<Cliente> buscarTodosClientesNaoEstaoNaOrdemServicoOrdemServico(Long ordemServicoId) {
		return clienteRepository.buscarTodosClientesNaoEstaoNaOrdemServicoOrdemServico(ordemServicoId);
	
	}

	public void remover(Long codigo) {
		Cliente clienteSalvo = buscarPeloCodigo(codigo);
		clienteSalvo.inativar();
		clienteRepository.save(clienteSalvo);
	}

	public List<Cliente> listarTodosAtivos() {
		return clienteRepository.listarTodosAtivos();
	}

	public Page<Cliente> listarTodosAtivos(Pageable pageable) {
		return clienteRepository.listarTodosAtivos(pageable);
	}

}