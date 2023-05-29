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
import org.springframework.web.bind.annotation.RestController;

import com.betonflex.model.OrdemServicoCliente;
import com.betonflex.model.OrdemServicoMaterial;
import com.betonflex.service.OrdemServicoMaterialService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ordemservicomaterials")
public class OrdemServicoMaterialResource {

	@Autowired
	private OrdemServicoMaterialService ordemservicomaterialService;

	@PostMapping
	public ResponseEntity<OrdemServicoMaterial> criar(@Valid @RequestBody OrdemServicoMaterial ordemservicomaterial, HttpServletResponse response) {
		 OrdemServicoMaterial ordemservicomaterialSalva = ordemservicomaterialService.salvar(ordemservicomaterial);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemservicomaterialSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<OrdemServicoMaterial> buscarPeloCodigo(@PathVariable Long codigo) {
		OrdemServicoMaterial ordemservicomaterial = ordemservicomaterialService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(ordemservicomaterial);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<OrdemServicoMaterial> atualizar(@PathVariable Long codigo, @Valid @RequestBody OrdemServicoMaterial ordemservicomaterial) {
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
	public void remover(@PathVariable Long codigo) {
		ordemservicomaterialService.remover(codigo);
	}
	
	@GetMapping("/ordemServico/{ordemServicoId}")
	public Page<OrdemServicoMaterial> buscarPeloOrdemServico(@PathVariable Long ordemServicoId,Pageable pageable){
		return ordemservicomaterialService.buscarPeloOrdemServico(ordemServicoId,pageable);
	}
	

}