package com.betonflex.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betonflex.service.OrdemServicoClienteService;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/ordemservicoclientes")
public class OrdemServicoClienteResource {

	@Autowired
	private OrdemServicoClienteService ordemservicoclienteService;
	
	@ApiOperation(value = "Excluir relacionamento entre ordem servico e cliente(exclusão fisica)")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable Long codigo) {
		ordemservicoclienteService.remover(codigo);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}
	
	/*@PostMapping
	public ResponseEntity<OrdemServicoCliente> criar(@Validated @RequestBody OrdemServicoCliente ordemservicocliente, HttpServletResponse response) {
		 OrdemServicoCliente ordemservicoclienteSalva = ordemservicoclienteService.salvar(ordemservicocliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemservicoclienteSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<OrdemServicoCliente> buscarPeloCodigo(@PathVariable Long codigo) {
		OrdemServicoCliente ordemservicocliente = ordemservicoclienteService.buscarPeloCodigo(codigo);
		return ordemservicocliente != null ? ResponseEntity.ok(ordemservicocliente) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<OrdemServicoCliente> atualizar(@PathVariable Long codigo, @Validated @RequestBody OrdemServicoCliente ordemservicocliente) {
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