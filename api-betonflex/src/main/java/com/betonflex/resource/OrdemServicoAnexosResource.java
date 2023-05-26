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

import com.betonflex.model.OrdemServicoAnexos;
import com.betonflex.service.OrdemServicoAnexosService;

@RestController
@RequestMapping("/ordemservicoanexos")
public class OrdemServicoAnexosResource {

	@Autowired
	private OrdemServicoAnexosService ordemservicoanexosService;

	@PostMapping
	public ResponseEntity<OrdemServicoAnexos> criar(@Validated @RequestBody OrdemServicoAnexos ordemservicoanexos, HttpServletResponse response) {
		 OrdemServicoAnexos ordemservicoanexosSalva = ordemservicoanexosService.salvar(ordemservicoanexos);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemservicoanexosSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<OrdemServicoAnexos> buscarPeloCodigo(@PathVariable Long codigo) {
		OrdemServicoAnexos ordemservicoanexos = ordemservicoanexosService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(ordemservicoanexos);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<OrdemServicoAnexos> atualizar(@PathVariable Long codigo, @Validated @RequestBody OrdemServicoAnexos ordemservicoanexos) {
		OrdemServicoAnexos ordemservicoanexosSalva = ordemservicoanexosService.atualizar(codigo, ordemservicoanexos);
		return ResponseEntity.ok(ordemservicoanexosSalva);
	}

	@GetMapping
	public Page<OrdemServicoAnexos> pesquisar(Pageable pageable) {
		return ordemservicoanexosService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<OrdemServicoAnexos> pesquisar() {
		return ordemservicoanexosService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		ordemservicoanexosService.remover(codigo);
	}

}