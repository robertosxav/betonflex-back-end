package com.betonflex.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betonflex.model.OrdemServicoAnexos;
import com.betonflex.service.OrdemServicoAnexosService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ordemservicoanexos")
public class OrdemServicoAnexosResource {

	@Autowired
	private OrdemServicoAnexosService ordemservicoanexosService;

	@PostMapping
	public ResponseEntity<OrdemServicoAnexos> criar(@Validated @RequestBody OrdemServicoAnexos ordemservicoanexos, HttpServletResponse response) {
		 OrdemServicoAnexos ordemservicoanexosSalva = ordemservicoanexosService.salvar(ordemservicoanexos);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemservicoanexosSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<OrdemServicoAnexos> buscarPeloCodigo(@PathVariable Long codigo) {
		OrdemServicoAnexos ordemservicoanexos = ordemservicoanexosService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(ordemservicoanexos);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<OrdemServicoAnexos> atualizar(@PathVariable Long codigo, @Validated @RequestBody OrdemServicoAnexos ordemservicoanexos) {
		OrdemServicoAnexos ordemservicoanexosSalva = ordemservicoanexosService.atualizar(codigo, ordemservicoanexos);
		return ResponseEntity.ok(ordemservicoanexosSalva);
	}

	@GetMapping
	public Page<OrdemServicoAnexos> pesquisar(Pageable pageable) {
		return ordemservicoanexosService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<OrdemServicoAnexos> pesquisar() {
		return ordemservicoanexosService.listarTodos();
	}

	
	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		ordemservicoanexosService.remover(codigo);
	}

	@ApiOperation(value = "Listar anexos de uma ordem de serviço")
	@GetMapping("/ordemservico/{ordemServicoId}")
	public Page<OrdemServicoAnexos> listarAnexosOrdemServico(@PathVariable Long ordemServicoId,Pageable pageable) {
		return ordemservicoanexosService.listarAnexosOrdemServico(ordemServicoId,pageable);
	}
	
	@ApiOperation(value = "Fazer download arquivo")
	@GetMapping("/download/{idenAdiantamentoArquivo}")
	public ResponseEntity<Resource> downloadArquivo(@PathVariable Long ordemServicoAnexoId) {
		OrdemServicoAnexos arquivo = ordemservicoanexosService.obterDownloadArquivo(ordemServicoAnexoId);
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(arquivo.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + arquivo.getOrdemServicoAnexoArqNome()+"."+
                		arquivo.getOrdemServicoAnexoArqTipo()+"\"")
                .body(new ByteArrayResource(arquivo.getOrdemServicoAnexoArq()));
	}
	
	@ApiOperation(value = "Fazer download arquivo,base 64")
	@GetMapping("/download/base64/{ordemServicoAnexoId}")
	public ResponseEntity<String> downloadArquivoBase64(@PathVariable Long ordemServicoAnexoId) {

		OrdemServicoAnexos arquivo = ordemservicoanexosService.obterDownloadArquivo(ordemServicoAnexoId); 		
		String dados = new String(Base64.encodeBase64(arquivo.getOrdemServicoAnexoArq()));
				
		dados ="data:"+arquivo.getContentType()+";base64," + dados;		
		
		return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + arquivo.getOrdemServicoAnexoArqNome()+"."+
                		arquivo.getOrdemServicoAnexoArqTipo()+"\"")
                .body(dados);
	}

}