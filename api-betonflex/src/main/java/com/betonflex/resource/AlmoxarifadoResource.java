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

import com.betonflex.model.Almoxarifado;
import com.betonflex.service.AlmoxarifadoService;

@RestController
@RequestMapping("/almoxarifados")
public class AlmoxarifadoResource {

	@Autowired
	private AlmoxarifadoService almoxarifadoService;

	@PostMapping
	public ResponseEntity<Almoxarifado> criar(@Validated @RequestBody Almoxarifado almoxarifado, HttpServletResponse response) {
		 Almoxarifado almoxarifadoSalva = almoxarifadoService.salvar(almoxarifado);
		return ResponseEntity.status(HttpStatus.CREATED).body(almoxarifadoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Almoxarifado> buscarPeloCodigo(@PathVariable Long codigo) {
		Almoxarifado almoxarifado = almoxarifadoService.buscarPeloCodigo(codigo);
		return almoxarifado != null ? ResponseEntity.ok(almoxarifado) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Almoxarifado> atualizar(@PathVariable Long codigo, @Validated @RequestBody Almoxarifado almoxarifado) {
		Almoxarifado almoxarifadoSalva = almoxarifadoService.atualizar(codigo, almoxarifado);
		return ResponseEntity.ok(almoxarifadoSalva);
	}

	@GetMapping
	public Page<Almoxarifado> pesquisar(Pageable pageable) {
		return almoxarifadoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Almoxarifado> pesquisar() {
		return almoxarifadoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		almoxarifadoService.remover(codigo);
	}

}