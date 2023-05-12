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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.betonflex.model.OrdemServicoCliente;
import com.betonflex.service.OrdemServicoClienteService;

@RestController
@RequestMapping("/ordemservicoclientes")
public class OrdemServicoClienteResource {

	@Autowired
	private OrdemServicoClienteService ordemservicoclienteService;
	
	@PostMapping
	public ResponseEntity<OrdemServicoCliente> criar(@Validated @RequestBody OrdemServicoCliente ordemservicocliente, HttpServletResponse response) {
		 OrdemServicoCliente ordemservicoclienteSalva = ordemservicoclienteService.salvar(ordemservicocliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemservicoclienteSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<OrdemServicoCliente> buscarPeloCodigo(@PathVariable Long codigo) {
		OrdemServicoCliente ordemservicocliente = ordemservicoclienteService.buscarPeloCodigo(codigo);
		return ordemservicocliente != null ? ResponseEntity.ok(ordemservicocliente) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<OrdemServicoCliente> atualizar(@PathVariable Long codigo, @Validated @RequestBody OrdemServicoCliente ordemservicocliente) {
		OrdemServicoCliente ordemservicoclienteSalva = ordemservicoclienteService.atualizar(codigo, ordemservicocliente);
		return ResponseEntity.ok(ordemservicoclienteSalva);
	}

	@GetMapping
	public Page<OrdemServicoCliente> pesquisar(Pageable pageable) {
		return ordemservicoclienteService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<OrdemServicoCliente> pesquisar() {
		return ordemservicoclienteService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		ordemservicoclienteService.remover(codigo);
	}

}