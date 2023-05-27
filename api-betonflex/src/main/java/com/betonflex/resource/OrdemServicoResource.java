package com.betonflex.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.betonflex.model.OrdemServico;
import com.betonflex.service.OrdemServicoService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ordemservicos")
public class OrdemServicoResource {

	@Autowired
	private OrdemServicoService ordemservicoService;

	//@ApiOperation(value = "Criar uma ordem de serviço")
	@PostMapping
	public ResponseEntity<OrdemServico> criar(@Valid @RequestBody OrdemServico ordemservico, HttpServletResponse response) {
		 OrdemServico ordemservicoSalva = ordemservicoService.salvar(ordemservico);
		return ResponseEntity.status(HttpStatus.CREATED).body(ordemservicoSalva);
	}

	//@ApiOperation(value = "Buscar uma ordem de serviço pelo código")
	@GetMapping("/{codigo}")
	public ResponseEntity<OrdemServico> buscarPeloCodigo(@PathVariable Long codigo) {
		OrdemServico ordemservico = ordemservicoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(ordemservico);
	}

	//@ApiOperation(value = "Atualizar uma ordem de serviço")
	@PutMapping("/{codigo}")
	public ResponseEntity<OrdemServico> atualizar(@PathVariable Long codigo,  @Valid @RequestBody OrdemServico ordemservico) {
		OrdemServico ordemservicoSalva = ordemservicoService.atualizar(codigo, ordemservico);
		return ResponseEntity.ok(ordemservicoSalva);
	}

	//@ApiOperation(value = "Buscar todas ordens de serviço, resposta de forma paginada")
	@GetMapping
	public Page<OrdemServico> pesquisar(Pageable pageable) {
		return ordemservicoService.pesquisar(pageable);
	}

	//@ApiOperation(value = "Buscar todas ordens de serviço")
	@GetMapping("/all")
	public List<OrdemServico> pesquisar() {
		return ordemservicoService.listarTodos();
	}

	//@ApiOperation(value = "Pesquisar ordens de serviço passando um parametro de busca, resposta paginada")
	@GetMapping("/buscanegenerica")
	public Page<OrdemServico> buscaGenerica(@RequestParam String pesquisa, Pageable pageable) {
		return ordemservicoService.buscaGenerica(pesquisa, pageable);
	}
	
	//@ApiOperation(value = "Buscar todas ordens de serviço por um tipo de serviço, resposta paginada")
	@GetMapping("/buscatiposervico/{tipoServicoId}")
	public Page<OrdemServico> buscaTipoServico(@PathVariable Long tipoServicoId, Pageable pageable) {
		return ordemservicoService.buscaTipoServico(tipoServicoId, pageable);
	}
	
	//@ApiOperation(value = "Pesquisar todas ordens de serviço ativas de um cliente")
	@GetMapping("/cliente/{clienteId}")
	public Page<OrdemServico> listarTodasOrdemServicosCliente(@PathVariable Long clienteId, Pageable pageable) {
		return ordemservicoService.listarTodasOrdemServicosCliente(clienteId, pageable);
	}
	
	//@ApiOperation(value = "Fazer upload do arquivo")
	@PutMapping("/upload/{ordemServicoId}")
	public ResponseEntity<String> uploadArquivos(@PathVariable Long ordemServicoId, @RequestParam("file") MultipartFile[] arquivos){
		ordemservicoService.fazerUploadArquivo(ordemServicoId, arquivos);
		return ResponseEntity.status(HttpStatus.CREATED).body("Envio de arquivo realizado com sucesso");
	}
	
	//@ApiOperation(value = "Trazer ultimas 10 ordens de serviços")
	@GetMapping("/ultimasordemservicos")
	public List<OrdemServico> listarUltimasOrdemServiços() {
		return ordemservicoService.listarUltimasOrdemServiços();
	}
}