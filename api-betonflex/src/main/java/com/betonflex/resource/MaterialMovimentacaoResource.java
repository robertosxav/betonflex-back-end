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

import com.betonflex.model.MaterialMovimentacao;
import com.betonflex.service.MaterialMovimentacaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/materialmovimentacaos")
public class MaterialMovimentacaoResource {

	@Autowired
	private MaterialMovimentacaoService materialmovimentacaoService;


	@PostMapping
	public ResponseEntity<MaterialMovimentacao> criar(@Valid @RequestBody MaterialMovimentacao materialmovimentacao) {
		 MaterialMovimentacao materialmovimentacaoSalva = materialmovimentacaoService.salvar(materialmovimentacao);
		return ResponseEntity.status(HttpStatus.CREATED).body(materialmovimentacaoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<MaterialMovimentacao> buscarPeloCodigo(@PathVariable Long codigo) {
		MaterialMovimentacao materialmovimentacao = materialmovimentacaoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(materialmovimentacao);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<MaterialMovimentacao> atualizar(@PathVariable Long codigo, @Valid @RequestBody MaterialMovimentacao materialmovimentacao) {
		MaterialMovimentacao materialmovimentacaoSalva = materialmovimentacaoService.atualizar(codigo, materialmovimentacao);
		return ResponseEntity.ok(materialmovimentacaoSalva);
	}

	@GetMapping
	public Page<MaterialMovimentacao> pesquisar(Pageable pageable) {
		return materialmovimentacaoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<MaterialMovimentacao> pesquisar() {
		return materialmovimentacaoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		materialmovimentacaoService.remover(codigo);
	}

}