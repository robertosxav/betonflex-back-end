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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betonflex.model.Almoxarifado;
import com.betonflex.service.AlmoxarifadoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/almoxarifados")
public class AlmoxarifadoResource {

	@Autowired
	private AlmoxarifadoService almoxarifadoService;

	@ApiOperation(value = "Criar um almoxarifado")
	@PostMapping
	public ResponseEntity<Almoxarifado> criar(@Validated @RequestBody Almoxarifado almoxarifado, HttpServletResponse response) {
		 Almoxarifado almoxarifadoSalva = almoxarifadoService.salvar(almoxarifado);
		return ResponseEntity.status(HttpStatus.CREATED).body(almoxarifadoSalva);
	}

	@ApiOperation(value = "Buscar um almoxarifado pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<Almoxarifado> buscarPeloCodigo(@PathVariable Long codigo) {
		Almoxarifado almoxarifado = almoxarifadoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(almoxarifado);
	}

	@ApiOperation(value = "Atualizar um almoxarifado")
	@PutMapping("/{codigo}")
	public ResponseEntity<Almoxarifado> atualizar(@PathVariable Long codigo, @Validated @RequestBody Almoxarifado almoxarifado) {
		Almoxarifado almoxarifadoSalva = almoxarifadoService.atualizar(codigo, almoxarifado);
		return ResponseEntity.ok(almoxarifadoSalva);
	}

	@ApiOperation(value = "Pesquisar todos almoxarifados, resposta paginada")
	@GetMapping
	public Page<Almoxarifado> pesquisar(Pageable pageable) {
		return almoxarifadoService.pesquisar(pageable);
	}

	@ApiOperation(value = "Pesquisar todos almoxarifados")
	@GetMapping("/all")
	public List<Almoxarifado> pesquisar() {
		return almoxarifadoService.listarTodos();
	}
	
	@ApiOperation(value = "Pesquisar todos almoxarifados que estão ativos")
	@GetMapping("/ativos")
	public List<Almoxarifado> listarTodosAtivos() {
		return almoxarifadoService.listarTodosAtivos();
	}
	
	@ApiOperation(value = "Pesquisar todos almoxarifados ativos, resposta paginada")
	@GetMapping("/ativos/paginado")
	public Page<Almoxarifado> listarTodosAtivo(Pageable pageable) {
		return almoxarifadoService.listarTodosAtivos(pageable);
	}
	
	@ApiOperation(value = "Pesquisar almoxarifados passando um parametro de busca, resposta paginada")
	@GetMapping("/buscanegenerica")
	public Page<Almoxarifado> buscaGenerica(@RequestParam String pesquisa, Pageable pageable) {
		return almoxarifadoService.buscaGenerica(pesquisa, pageable);
	}

	@ApiOperation(value = "Excluir um almoxarifado (exclusão lógica)")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable Long codigo) {
		almoxarifadoService.remover(codigo);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}
}