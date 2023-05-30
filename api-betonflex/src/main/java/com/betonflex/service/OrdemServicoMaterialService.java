package com.betonflex.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.betonflex.exceptions.BetonflexException;
import com.betonflex.model.AlmoxarifadoMaterial;
import com.betonflex.model.Funcionario;
import com.betonflex.model.OrdemServico;
import com.betonflex.model.OrdemServicoMaterial;
import com.betonflex.repository.OrdemServicoMaterialRepository;

@Service
public class OrdemServicoMaterialService {

	@Autowired
	private OrdemServicoMaterialRepository ordemservicomaterialRepository;
	
	@Autowired
	AlmoxarifadoMaterialService almoxarifadoMaterialService;

	@Autowired
	OrdemServicoService ordemServicoService;
	
	@Autowired
	FuncionarioService funcionarioService;
	
	public OrdemServicoMaterial salvar(OrdemServicoMaterial ordemservicomaterial) {
		validar(ordemservicomaterial);
		ordemservicomaterial.ativar();
		return ordemservicomaterialRepository.save(ordemservicomaterial);
	}

	private void validar(OrdemServicoMaterial ordemservicomaterial) {
		AlmoxarifadoMaterial almoxarifadoMaterial = almoxarifadoMaterialService.buscarPeloCodigo(ordemservicomaterial.getAlmoxarifadoMaterial().getAlmoxarifadoMaterialId());
		ordemservicomaterial.setAlmoxarifadoMaterial(almoxarifadoMaterial);
		
		OrdemServico ordemServico = ordemServicoService.buscarPeloCodigo(ordemservicomaterial.getOrdemServico().getOrdemServicoId());
		ordemservicomaterial.setOrdemServico(ordemServico);
		
		Funcionario funcionario=funcionarioService.buscarPeloCodigo(ordemservicomaterial.getFuncionario().getFuncionarioId());
		ordemservicomaterial.setFuncionario(funcionario);
		
	}

	public OrdemServicoMaterial buscarPeloCodigo(Long codigo) {
		return ordemservicomaterialRepository
				.findById(codigo)
				.orElseThrow(()-> new BetonflexException("Id não encontrado"));
		
	}

	public OrdemServicoMaterial atualizar(Long codigo, OrdemServicoMaterial ordemservicomaterial) {
		OrdemServicoMaterial ordemservicomaterialSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(ordemservicomaterial, ordemservicomaterialSave, "ordemServicoMaterialId");
		return ordemservicomaterialRepository.save(ordemservicomaterialSave);
	}

	public Page<OrdemServicoMaterial> pesquisar(Pageable pageable){
		return ordemservicomaterialRepository.findAll(pageable);
	}

	public List<OrdemServicoMaterial> listarTodos() {
		return ordemservicomaterialRepository.findAll();
	}

	public void remover(Long codigo) {
		ordemservicomaterialRepository.deleteById(codigo);
	}

	public Page<OrdemServicoMaterial> buscarPeloOrdemServico(Long ordemServicoId, Pageable pageable) {
		return ordemservicomaterialRepository.buscarPelaOrdemServico(ordemServicoId, pageable);
	}

}