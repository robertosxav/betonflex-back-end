package com.betonflex.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betonflex.model.OrdemServico;
import com.betonflex.service.OrdemServicoService;

@RestController
@RequestMapping("/ordemservicos")
public class OrdemServicoResource {

	@Autowired
	private OrdemServicoService ordemservicoService;

	@PostMapping
	public ResponseEntity<OrdemServico> criar(@Validated @RequestBody OrdemServico ordemservico, HttpServletResponse response) {
		 OrdemServico ordemservicoSalva = ordemservicoService.salvar(ordemservico);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemservicoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<OrdemServico> buscarPeloCodigo(@PathVariable Long codigo) {
		OrdemServico ordemservico = ordemservicoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(ordemservico);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<OrdemServico> atualizar(@PathVariable Long codigo, @Validated @RequestBody OrdemServico ordemservico) {
		OrdemServico ordemservicoSalva = ordemservicoService.atualizar(codigo, ordemservico);
		return ResponseEntity.ok(ordemservicoSalva);
	}

	@GetMapping
	public Page<OrdemServico> pesquisar(Pageable pageable) {
		return ordemservicoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<OrdemServico> pesquisar() {
		return ordemservicoService.listarTodos();
	}

	@GetMapping("/buscanegenerica")
	public Page<OrdemServico> buscaGenerica(@RequestParam String pesquisa, Pageable pageable) {
		return ordemservicoService.buscaGenerica(pesquisa, pageable);
	}
	
	@GetMapping("/buscatiposervico/{tipoServicoId}")
	public Page<OrdemServico> buscaTipoServico(@PathVariable Long tipoServicoId, Pageable pageable) {
		return ordemservicoService.buscaTipoServico(tipoServicoId, pageable);
	}
}