package com.betonflex.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betonflex.model.OrdemServicoCliente;
import com.betonflex.service.OrdemServicoClienteService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/ordemservicoclientes")
public class OrdemServicoClienteResource {

	@Autowired
	private OrdemServicoClienteService ordemservicoclienteService;
	
	//@ApiOperation(value = "Criar uma linha tabela nxn de OrdemServicoCliente")
	@PostMapping
	public ResponseEntity<OrdemServicoCliente> criar(@Valid @RequestBody OrdemServicoCliente ordemservicocliente) {
		OrdemServicoCliente ordemservicoclienteSalva = ordemservicoclienteService.salvar(ordemservicocliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemservicoclienteSalva);
	}
	//@ApiOperation(value = "Criar uma linha tabela nxn de OrdemServicoCliente")
	@PostMapping("/vincularClienteOrdemServico")
	public ResponseEntity<OrdemServicoCliente> vincularClienteOrdemServico(@Valid @RequestBody OrdemServicoCliente ordemservicocliente) {
		OrdemServicoCliente ordemservicoclienteSalva = ordemservicoclienteService.vincularClienteOrdemServico(ordemservicocliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemservicoclienteSalva);
	}
	
	
	//@ApiOperation(value = "Excluir relacionamento entre ordem servico e cliente(exclusão fisica)")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable Long codigo) {
		ordemservicoclienteService.remover(codigo);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}
	
	//@ApiOperation(value = "Lista de objetos do tipo OrdemServicoCliente passando o clienteId")
	@GetMapping("/cliente/{clienteId}")
	public Page<OrdemServicoCliente> buscarPeloCLienteEOrdemServico(@PathVariable Long clienteId,Pageable pageable){
		return ordemservicoclienteService.buscarPeloCiente(clienteId,pageable);
	}
	
	//@ApiOperation(value = "Lista de objetos do tipo OrdemServicoCliente passando o ordemServicoId")
	@GetMapping("/ordemServico/{ordemServicoId}")
	public Page<OrdemServicoCliente> buscarPeloOrdemServico(@PathVariable Long ordemServicoId,Pageable pageable){
		return ordemservicoclienteService.buscarPelaOrdemServico(ordemServicoId,pageable);
	}
	
/*
	@GetMapping("/{codigo}")
	public ResponseEntity<OrdemServicoCliente> buscarPeloCodigo(@PathVariable Long codigo) {
		OrdemServicoCliente ordemservicocliente = ordemservicoclienteService.buscarPeloCodigo(codigo);
		return ordemservicocliente != null ? ResponseEntity.ok(ordemservicocliente) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<OrdemServicoCliente> atualizar(@PathVariable Long codigo, @Valid @RequestBody OrdemServicoCliente ordemservicocliente) {
		OrdemServicoCliente ordemservicoclienteSalva = ordemservicoclienteService.atualizar(codigo, ordemservicocliente);
		return ResponseEntity.ok(ordemservicoclienteSalva);
	}

	@GetMapping
	public Page<OrdemServicoCliente> pesquisar(Pageable pageable) {
		return ordemservicoclienteService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<OrdemServicoCliente> pesquisar() {
		return ordemservicoclienteService.listarTodos();
	}
*/

}