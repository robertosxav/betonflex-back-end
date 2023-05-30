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

import com.betonflex.model.TipoServico;
import com.betonflex.service.TipoServicoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/tiposervicos")
public class TipoServicoResource {

	@Autowired
	private TipoServicoService tiposervicoService;

	//@ApiOperation(value = "Criar um tipo de serviço")
	@PostMapping
	public ResponseEntity<TipoServico> criar(@Valid @RequestBody TipoServico tiposervico) {
		 TipoServico tiposervicoSalva = tiposervicoService.salvar(tiposervico);
		return ResponseEntity.status(HttpStatus.CREATED).body(tiposervicoSalva);
	}

	//@ApiOperation(value = "Buscar um tipo de serviço pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<TipoServico> buscarPeloCodigo(@PathVariable Long codigo) {
		TipoServico tiposervico = tiposervicoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(tiposervico);
	}

	//@ApiOperation(value = "Atualizar um tipo de serviço")
	@PutMapping("/{codigo}")
	public ResponseEntity<TipoServico> atualizar(@PathVariable Long codigo, @Valid @RequestBody TipoServico tiposervico) {
		TipoServico tiposervicoSalva = tiposervicoService.atualizar(codigo, tiposervico);
		return ResponseEntity.ok(tiposervicoSalva);
	}

	//@ApiOperation(value = "Pesquisar todos tipos de serviço, resposta paginada")
	@GetMapping
	public Page<TipoServico> pesquisar(Pageable pageable) {
		return tiposervicoService.pesquisar(pageable);
	}

	//@ApiOperation(value = "Pesquisar todos tipos de serviço, resposta paginada")
	@GetMapping("/all")
	public List<TipoServico> pesquisar() {
		return tiposervicoService.listarTodos();
	}
	
	//@ApiOperation(value = "Pesquisar todos tipos de serviço")
	@GetMapping("/ativos")
	public List<TipoServico> listarTodosAtivos() {
		return tiposervicoService.listarTodosAtivos();
	}
	
	//@ApiOperation(value = "Pesquisar todos tipos de serviço, resposta paginada")
	@GetMapping("/ativos/paginado")
	public Page<TipoServico> listarTodosAtivo(Pageable pageable) {
		return tiposervicoService.listarTodosAtivos(pageable);
	}
	
	//@ApiOperation(value = "Pesquisar tipos de serviço passando um parametro de busca, resposta paginada")
	@GetMapping("/buscanegenerica")
	public Page<TipoServico> buscaGenerica(@RequestParam String pesquisa, Pageable pageable) {
		return tiposervicoService.buscaGenerica(pesquisa, pageable);
	}

	//@ApiOperation(value = "Excluir um tipo de Serviço(Exclusão lógica)")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable Long codigo) {
		tiposervicoService.remover(codigo);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}

}