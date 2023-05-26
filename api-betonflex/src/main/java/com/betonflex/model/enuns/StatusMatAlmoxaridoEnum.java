package com.betonflex.model.enuns;

import com.betonflex.exceptions.BetonflexException;

public enum StatusMatAlmoxaridoEnum {
	NOVO("NOVO");
	
	private String descricao;
	
	StatusMatAlmoxaridoEnum( String descricao) {
		this.descricao	=	descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static StatusMatAlmoxaridoEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new BetonflexException("Enum inválido: "+descricao);
		}
		
		for(StatusMatAlmoxaridoEnum s : StatusMatAlmoxaridoEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new BetonflexException("Enum inválido: "+descricao);
	}
}
