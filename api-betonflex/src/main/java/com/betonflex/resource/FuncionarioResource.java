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

import com.betonflex.model.Funcionario;
import com.betonflex.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService funcionarioService;

	@PostMapping
	public ResponseEntity<Funcionario> criar(@Validated @RequestBody Funcionario funcionario, HttpServletResponse response) {
		 Funcionario funcionarioSalva = funcionarioService.salvar(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Funcionario> buscarPeloCodigo(@PathVariable Long codigo) {
		Funcionario funcionario = funcionarioService.buscarPeloCodigo(codigo);
		return funcionario != null ? ResponseEntity.ok(funcionario) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long codigo, @Validated @RequestBody Funcionario funcionario) {
		Funcionario funcionarioSalva = funcionarioService.atualizar(codigo, funcionario);
		return ResponseEntity.ok(funcionarioSalva);
	}

	@GetMapping
	public Page<Funcionario> pesquisar(Pageable pageable) {
		return funcionarioService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Funcionario> pesquisar() {
		return funcionarioService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		funcionarioService.remover(codigo);
	}

}