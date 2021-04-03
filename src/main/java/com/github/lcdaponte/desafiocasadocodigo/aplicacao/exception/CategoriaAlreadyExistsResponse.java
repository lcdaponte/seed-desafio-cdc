package com.github.lcdaponte.desafiocasadocodigo.aplicacao.exception;

public class CategoriaAlreadyExistsResponse {
	
	private String message;
	
	public CategoriaAlreadyExistsResponse(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
