package com.betonflex.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.betonflex.model.OrdemServicoFechamento;
import com.betonflex.service.OrdemServicoFechamentoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/ordemservicofechamentos")
public class OrdemServicoFechamentoResource {

	@Autowired
	private OrdemServicoFechamentoService ordemservicofechamentoService;

	@PostMapping
	public ResponseEntity<OrdemServicoFechamento> criar(@Valid @RequestBody OrdemServicoFechamento ordemservicofechamento) {
		 OrdemServicoFechamento ordemservicofechamentoSalva = ordemservicofechamentoService.salvar(ordemservicofechamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemservicofechamentoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<OrdemServicoFechamento> buscarPeloCodigo(@PathVariable Long codigo) {
		OrdemServicoFechamento ordemservicofechamento = ordemservicofechamentoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(ordemservicofechamento);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<OrdemServicoFechamento> atualizar(@PathVariable Long codigo, @Valid @RequestBody OrdemServicoFechamento ordemservicofechamento) {
		OrdemServicoFechamento ordemservicofechamentoSalva = ordemservicofechamentoService.atualizar(codigo, ordemservicofechamento);
		return ResponseEntity.ok(ordemservicofechamentoSalva);
	}

	@GetMapping
	public Page<OrdemServicoFechamento> pesquisar(Pageable pageable) {
		return ordemservicofechamentoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<OrdemServicoFechamento> pesquisar() {
		return ordemservicofechamentoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		ordemservicofechamentoService.remover(codigo);
	}

}