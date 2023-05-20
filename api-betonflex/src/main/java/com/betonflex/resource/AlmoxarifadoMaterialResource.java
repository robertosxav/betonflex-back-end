package com.betonflex.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betonflex.service.AlmoxarifadoMaterialService;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;
@ApiIgnore
@RestController
@RequestMapping("/almoxarifadomaterials")
public class AlmoxarifadoMaterialResource {

	@Autowired
	private AlmoxarifadoMaterialService almoxarifadomaterialService;

	@ApiOperation(value = "Excluir relacionamento entre ordem servico e cliente(exclusão fisica)")
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> remover(@PathVariable Long codigo) {
		almoxarifadomaterialService.remover(codigo);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}
	
	/*
	@PostMapping
	public ResponseEntity<AlmoxarifadoMaterial> criar(@Validated @RequestBody AlmoxarifadoMaterial almoxarifadomaterial, HttpServletResponse response) {
		 AlmoxarifadoMaterial almoxarifadomaterialSalva = almoxarifadomaterialService.salvar(almoxarifadomaterial);
		return ResponseEntity.status(HttpStatus.CREATED).body(almoxarifadomaterialSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<AlmoxarifadoMaterial> buscarPeloCodigo(@PathVariable Long codigo) {
		AlmoxarifadoMaterial almoxarifadomaterial = almoxarifadomaterialService.buscarPeloCodigo(codigo);
		return almoxarifadomaterial != null ? ResponseEntity.ok(almoxarifadomaterial) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<AlmoxarifadoMaterial> atualizar(@PathVariable Long codigo, @Validated @RequestBody AlmoxarifadoMaterial almoxarifadomaterial) {
		AlmoxarifadoMaterial almoxarifadomaterialSalva = almoxarifadomaterialService.atualizar(codigo, almoxarifadomaterial);
		return ResponseEntity.ok(almoxarifadomaterialSalva);
	}

	@GetMapping
	public Page<AlmoxarifadoMaterial> pesquisar(Pageable pageable) {
		return almoxarifadomaterialService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<AlmoxarifadoMaterial> pesquisar() {
		return almoxarifadomaterialService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		almoxarifadomaterialService.remover(codigo);
	}
*/
}