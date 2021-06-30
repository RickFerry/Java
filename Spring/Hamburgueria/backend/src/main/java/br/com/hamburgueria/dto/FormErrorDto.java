package br.com.hamburgueria.dto;

import java.io.Serializable;

public class FormErrorDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String campo;
	private String erro;

	public FormErrorDto(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
}
