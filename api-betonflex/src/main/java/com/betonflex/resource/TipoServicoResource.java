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

import com.betonflex.model.TipoServico;
import com.betonflex.service.TipoServicoService;

@RestController
@RequestMapping("/tiposervicos")
public class TipoServicoResource {

	@Autowired
	private TipoServicoService tiposervicoService;

	@PostMapping
	public ResponseEntity<TipoServico> criar(@Validated @RequestBody TipoServico tiposervico, HttpServletResponse response) {
		 TipoServico tiposervicoSalva = tiposervicoService.salvar(tiposervico);
		return ResponseEntity.status(HttpStatus.CREATED).body(tiposervicoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<TipoServico> buscarPeloCodigo(@PathVariable Long codigo) {
		TipoServico tiposervico = tiposervicoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(tiposervico);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<TipoServico> atualizar(@PathVariable Long codigo, @Validated @RequestBody TipoServico tiposervico) {
		TipoServico tiposervicoSalva = tiposervicoService.atualizar(codigo, tiposervico);
		return ResponseEntity.ok(tiposervicoSalva);
	}

	@GetMapping
	public Page<TipoServico> pesquisar(Pageable pageable) {
		return tiposervicoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<TipoServico> pesquisar() {
		return tiposervicoService.listarTodos();
	}
	
	@GetMapping("/ativos")
	public List<TipoServico> listarTodosAtivos() {
		return tiposervicoService.listarTodosAtivos();
	}
	
	@GetMapping("/ativos/paginado")
	public Page<TipoServico> listarTodosAtivo(Pageable pageable) {
		return tiposervicoService.listarTodosAtivos(pageable);
	}
	
	@GetMapping("/buscanegenerica")
	public Page<TipoServico> buscaGenerica(@RequestParam String pesquisa, Pageable pageable) {
		return tiposervicoService.buscaGenerica(pesquisa, pageable);
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable Long codigo) {
		tiposervicoService.remover(codigo);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}

}