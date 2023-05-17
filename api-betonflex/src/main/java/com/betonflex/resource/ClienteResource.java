package com.betonflex.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betonflex.model.Cliente;
import com.betonflex.service.ClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@ApiOperation(value = "Criar um cliente")
	@PostMapping
	public ResponseEntity<Cliente> criar(@Validated @RequestBody Cliente cliente, HttpServletResponse response) {
		Cliente clienteSalva = clienteService.salvar(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalva);
	}

	@ApiOperation(value = "Buscar um cliente pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<Cliente> buscarPeloCodigo(@PathVariable Long codigo) {
		Cliente cliente = clienteService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(cliente);
	}

	@ApiOperation(value = "Atualizar um ciente")
	@PutMapping("/{codigo}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long codigo, @Validated @RequestBody Cliente cliente) {
		Cliente clienteSalva = clienteService.atualizar(codigo, cliente);
		return ResponseEntity.ok(clienteSalva);
	}

	@ApiOperation(value = "Pesquisar todos clientes, resposta paginada")
	@GetMapping
	public Page<Cliente> pesquisar(Pageable pageable) {
		return clienteService.pesquisar(pageable);
	}

	@ApiOperation(value = "Pesquisar todos clientes")
	@GetMapping("/all")
	public List<Cliente> pesquisar() {
		return clienteService.listarTodos();
	}
	
	@ApiOperation(value = "Pesquisar clientes passando um parametro de busca, resposta paginada")
	@GetMapping("/buscanegenerica")
	public Page<Cliente> buscaGenerica(@RequestParam String pesquisa, Pageable pageable) {
		return clienteService.buscaGenerica(pesquisa, pageable);
	}
	
	/*@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		clienteService.remover(codigo);
	}
*/
}