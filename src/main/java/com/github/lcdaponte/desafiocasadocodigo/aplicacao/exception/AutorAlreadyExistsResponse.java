package com.github.lcdaponte.desafiocasadocodigo.aplicacao.exception;

public class AutorAlreadyExistsResponse {
	
	private String message;
	
	public AutorAlreadyExistsResponse(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
