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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betonflex.model.Funcionario;
import com.betonflex.service.FuncionarioService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioResource {

	@Autowired
	private FuncionarioService funcionarioService;

	//@ApiOperation(value = "Criar um funcionario")
	@PostMapping
	public ResponseEntity<Funcionario> criar(@Valid @RequestBody Funcionario funcionario, HttpServletResponse response) {
		 Funcionario funcionarioSalva = funcionarioService.salvar(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalva);
	}

	//@ApiOperation(value = "Buscar um funcionario pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<Funcionario> buscarPeloCodigo(@PathVariable Long codigo) {
		Funcionario funcionario = funcionarioService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(funcionario);
	}

	//@ApiOperation(value = "Atualizar um funcionario")
	@PutMapping("/{codigo}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long codigo, @Valid @RequestBody Funcionario funcionario) {
		Funcionario funcionarioSalva = funcionarioService.atualizar(codigo, funcionario);
		return ResponseEntity.ok(funcionarioSalva);
	}

	//@ApiOperation(value = "Pesquisar todos funcionarios, resposta paginada")
	@GetMapping
	public Page<Funcionario> pesquisar(Pageable pageable) {
		return funcionarioService.pesquisar(pageable);
	}

	//@ApiOperation(value = "Pesquisar todos funcionarios")
	@GetMapping("/all")
	public List<Funcionario> pesquisar() {
		return funcionarioService.listarTodos();
	}

	//@ApiOperation(value = "Pesquisar todos funcionarios ativos")
	@GetMapping("/ativos")
	public List<Funcionario> listarTodosAtivos() {
		return funcionarioService.listarTodosAtivos();
	}
	
	//@ApiOperation(value = "Pesquisar todos funcionarios ativos, resposta paginada")
	@GetMapping("/ativos/paginado")
	public Page<Funcionario> listarTodosAtivo(Pageable pageable) {
		return funcionarioService.listarTodosAtivos(pageable);
	}
	
	//@ApiOperation(value = "Pesquisar funcionarios ativos passando um parametro de busca, resposta paginada")
	@GetMapping("/buscanegenerica")
	public Page<Funcionario> buscaGenerica(@RequestParam String pesquisa, Pageable pageable) {
		return funcionarioService.buscaGenerica(pesquisa, pageable);
	}
	
	//@ApiOperation(value = "Excluir um funcionario (exclusão lógica)")
	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		funcionarioService.remover(codigo);
	}

}