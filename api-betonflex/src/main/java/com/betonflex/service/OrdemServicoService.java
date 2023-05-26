package com.betonflex.service;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.betonflex.exceptions.BetonflexException;
import com.betonflex.model.OrdemServico;
import com.betonflex.model.OrdemServicoAnexos;
import com.betonflex.model.TipoServico;
import com.betonflex.repository.OrdemServicoRepository;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository ordemservicoRepository;
	
	@Autowired
	private OrdemServicoAnexosService anexoService;
	
	@Autowired
	private TipoServicoService tipoServicoService;

	public OrdemServico salvar(OrdemServico ordemservico) {
		validar(ordemservico);
		ordemservico.ativar();
		return ordemservicoRepository.save(ordemservico);
	}

	private void validar(OrdemServico ordemservico) {
		TipoServico tipoServico = tipoServicoService
				.buscarPeloCodigo(ordemservico.getTipoServico().getTipoServicoId());
		
		ordemservico.setTipoServico(tipoServico);
	}

	public OrdemServico buscarPeloCodigo(Long codigo) {
		OrdemServico ordemservicoSalva = ordemservicoRepository
				.findById(codigo)
				.orElseThrow(()-> new BetonflexException("Id não encontrado"));
		
		return ordemservicoSalva;
	}

	public OrdemServico atualizar(Long codigo, OrdemServico ordemservico) {
		OrdemServico ordemservicoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(ordemservico, ordemservicoSave, "ordemServicoId");
		return ordemservicoRepository.save(ordemservicoSave);
	}

	public Page<OrdemServico> pesquisar(Pageable pageable){
		return ordemservicoRepository.findAll(pageable);
	}

	public List<OrdemServico> listarTodos() {
		return ordemservicoRepository.findAll();
	}


	public Page<OrdemServico> buscaGenerica(String pesquisa, Pageable pageable) {
		return ordemservicoRepository.buscaGenerica(pesquisa.toUpperCase(),pageable);
	}

	public Page<OrdemServico> buscaTipoServico(Long tipoServicoId, Pageable pageable) {
		return ordemservicoRepository.findByTipoServicoTipoServicoId(tipoServicoId,pageable);
	}

	public Page<OrdemServico> listarTodasOrdemServicosCliente(Long clienteId, Pageable pageable) {
		return ordemservicoRepository.listarTodasOrdemServicosCliente(clienteId,pageable);
	}

	public void fazerUploadArquivo(Long ordemServicoId, MultipartFile[] files) {

		OrdemServico ordemServico = buscarPeloCodigo(ordemServicoId);
	
		// Verifica se há algum arquivo na lista
		if (files.length < 1)
			throw new BetonflexException("Deve ser inserido pelo menos 1 arquivo");


		for (MultipartFile file : files) {
			if (calcularTamanhoArquivo(file) > 2) {
				throw new BetonflexException("Tamanho de arquivo inválido, máximo 2MB");
			}

			try {

				String extensaoArquivo = obterExtensaoArquivo(file).replace(".", "");
				
				OrdemServicoAnexos anexo = new OrdemServicoAnexos(ordemServicoId, ordemServico, file.getBytes(),extensaoArquivo, file.getOriginalFilename());
				
				anexoService.salvar(anexo);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private double calcularTamanhoArquivo(MultipartFile arquivo) {
		if (arquivo.getSize() <= 0)
			throw new BetonflexException("Tamanho de arquivo inválido");
			double tamanhoMB = ((arquivo.getSize() / 1024) / 1024);
			System.out.println(tamanhoMB);
		return tamanhoMB;
	}
	
	private String obterExtensaoArquivo(MultipartFile arquivo) {
		String regexExtensao = ".\\w+$";

		String extensaoEncontrada = "";
		String nomeArquivo = arquivo.getOriginalFilename();
		Pattern p = Pattern.compile(regexExtensao);
		Matcher m = p.matcher(nomeArquivo);

		if (m.find()) {
			extensaoEncontrada = m.group(0);
		}

		return extensaoEncontrada;

	}


}