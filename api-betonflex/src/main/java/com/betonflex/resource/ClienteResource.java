package com.betonflex.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betonflex.model.Cliente;
import com.betonflex.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity<Cliente> criar(@Validated @RequestBody Cliente cliente, HttpServletResponse response) {
		 Cliente clienteSalva = clienteService.salvar(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Cliente> buscarPeloCodigo(@PathVariable Long codigo) {
		Cliente cliente = clienteService.buscarPeloCodigo(codigo);
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long codigo, @Validated @RequestBody Cliente cliente) {
		Cliente clienteSalva = clienteService.atualizar(codigo, cliente);
		return ResponseEntity.ok(clienteSalva);
	}

	@GetMapping
	public Page<Cliente> pesquisar(Pageable pageable) {
		return clienteService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Cliente> pesquisar() {
		return clienteService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		clienteService.remover(codigo);
	}

}