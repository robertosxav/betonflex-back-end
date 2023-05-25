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

import com.betonflex.model.OrdemServicoMaterial;
import com.betonflex.service.OrdemServicoMaterialService;

@RestController
@RequestMapping("/ordemservicomaterials")
public class OrdemServicoMaterialResource {

	@Autowired
	private OrdemServicoMaterialService ordemservicomaterialService;

	@PostMapping
	public ResponseEntity<OrdemServicoMaterial> criar(@Validated @RequestBody OrdemServicoMaterial ordemservicomaterial, HttpServletResponse response) {
		 OrdemServicoMaterial ordemservicomaterialSalva = ordemservicomaterialService.salvar(ordemservicomaterial);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemservicomaterialSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<OrdemServicoMaterial> buscarPeloCodigo(@PathVariable Long codigo) {
		OrdemServicoMaterial ordemservicomaterial = ordemservicomaterialService.buscarPeloCodigo(codigo);
		return ordemservicomaterial != null ? ResponseEntity.ok(ordemservicomaterial) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<OrdemServicoMaterial> atualizar(@PathVariable Long codigo, @Validated @RequestBody OrdemServicoMaterial ordemservicomaterial) {
		OrdemServicoMaterial ordemservicomaterialSalva = ordemservicomaterialService.atualizar(codigo, ordemservicomaterial);
		return ResponseEntity.ok(ordemservicomaterialSalva);
	}

	@GetMapping
	public Page<OrdemServicoMaterial> pesquisar(Pageable pageable) {
		return ordemservicomaterialService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<OrdemServicoMaterial> pesquisar() {
		return ordemservicomaterialService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		ordemservicomaterialService.remover(codigo);
	}

}