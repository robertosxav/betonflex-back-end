package com.betonflex.model.enuns;

import com.betonflex.exceptions.BetonflexException;

public enum ContentTypeEnum {
	PDF("pdf", "application/pdf"),
	JPG("jpg", "image/jpeg"),
	JPEG("jpeg","image/jpeg"),
	PNG("png","image/png");
	
	private String extensao;
	private String mimeType;

	private ContentTypeEnum(String extensao, String mimeType) {
		this.extensao = extensao;
		this.mimeType = mimeType;
	}

	public String getExtensao() {
		return extensao;
	}

	public String getMimeType() {
		return mimeType;
	}
	
	public static ContentTypeEnum toEnumDesc(String desc) {

		if (desc == null || desc.isEmpty()) {
			throw new BetonflexException("ContentTypeEnum inválido:  " + desc);
		}

		for (ContentTypeEnum x : ContentTypeEnum.values()) {
			if (desc.equals(x.name())) {
				return x;
			}
		}

		throw new BetonflexException("ContentTypeEnum inválido:  " + desc);
	}
	
	public static ContentTypeEnum toEnum(String extensao) {

		if (extensao == null) {
			return null;
		}

		for (ContentTypeEnum x : ContentTypeEnum.values()) {
			if (extensao.equals(x.getExtensao())) {
				return x;
			}
		}

		throw new BetonflexException("Extensão inválida: " + extensao);
	}
	
}

