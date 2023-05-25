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

import com.betonflex.model.OrdemServicoProduto;
import com.betonflex.service.OrdemServicoProdutoService;

@RestController
@RequestMapping("/ordemservicoprodutos")
public class OrdemServicoProdutoResource {

	@Autowired
	private OrdemServicoProdutoService ordemservicoprodutoService;

	@PostMapping
	public ResponseEntity<OrdemServicoProduto> criar(@Validated @RequestBody OrdemServicoProduto ordemservicoproduto, HttpServletResponse response) {
		 OrdemServicoProduto ordemservicoprodutoSalva = ordemservicoprodutoService.salvar(ordemservicoproduto);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemservicoprodutoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<OrdemServicoProduto> buscarPeloCodigo(@PathVariable Long codigo) {
		OrdemServicoProduto ordemservicoproduto = ordemservicoprodutoService.buscarPeloCodigo(codigo);
		return ordemservicoproduto != null ? ResponseEntity.ok(ordemservicoproduto) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<OrdemServicoProduto> atualizar(@PathVariable Long codigo, @Validated @RequestBody OrdemServicoProduto ordemservicoproduto) {
		OrdemServicoProduto ordemservicoprodutoSalva = ordemservicoprodutoService.atualizar(codigo, ordemservicoproduto);
		return ResponseEntity.ok(ordemservicoprodutoSalva);
	}

	@GetMapping
	public Page<OrdemServicoProduto> pesquisar(Pageable pageable) {
		return ordemservicoprodutoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<OrdemServicoProduto> pesquisar() {
		return ordemservicoprodutoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		ordemservicoprodutoService.remover(codigo);
	}

}