package com.betonflex.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betonflex.model.Cliente;
import com.betonflex.model.OrdemServico;
import com.betonflex.service.ClienteService;

import javax.validation.Valid;


@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	//@ApiOperation(value = "Criar um cliente")
	@PostMapping
	public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente cliente) {
		Cliente clienteSalva = clienteService.salvar(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalva);
	}
	
	//@ApiOperation(value = "Adicionar ordens de serviço de um cliente")
	@PutMapping("/adicionarordenservicos/{codigo}")
	public ResponseEntity<String> adicionarOrdensServicos(@PathVariable Long codigo, @RequestBody List<OrdemServico> listaOrdensServico) {
		clienteService.adicionarOrdensServicos(codigo,listaOrdensServico);
		return ResponseEntity.status(HttpStatus.OK).body("Registro adicionado com sucesso");
	}

	//@ApiOperation(value = "Buscar um cliente pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<Cliente> buscarPeloCodigo(@PathVariable Long codigo) {
		Cliente cliente = clienteService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(cliente);
	}

	//@ApiOperation(value = "Atualizar um ciente")
	@PutMapping("/{codigo}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long codigo, @Valid @RequestBody Cliente cliente) {
		Cliente clienteSalva = clienteService.atualizar(codigo, cliente);
		return ResponseEntity.ok(clienteSalva);
	}

	//@ApiOperation(value = "Pesquisar todos clientes, resposta paginada")
	@GetMapping
	public Page<Cliente> pesquisar(Pageable pageable) {
		return clienteService.pesquisar(pageable);
	}

	//@ApiOperation(value = "Pesquisar todos clientes")
	@GetMapping("/all")
	public List<Cliente> pesquisar() {
		return clienteService.listarTodos();
	}
	
	//@ApiOperation(value = "Pesquisar clientes passando um parametro de busca, resposta paginada")
	@GetMapping("/buscanegenerica")
	public Page<Cliente> buscaGenerica(@RequestParam String pesquisa, Pageable pageable) {
		return clienteService.buscaGenerica(pesquisa, pageable);
	}
	

	
	//@ApiOperation(value = "Pesquisar todos clientes")
	@GetMapping("/notInOrdemServico/{ordemServicoId}")
	public List<Cliente> buscarTodosClientesNaoEstaoNaOrdemServicoOrdemServico(@PathVariable Long ordemServicoId) {
		return clienteService.buscarTodosClientesNaoEstaoNaOrdemServicoOrdemServico(ordemServicoId);
	}
	
	/*@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		clienteService.remover(codigo);
	}
*/
}