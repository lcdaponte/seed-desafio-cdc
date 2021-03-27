package com.github.lcdaponte.desafiocasadocodigo.aplicacao.exception;

public class NoBodyException {
	
	private String message;
	
	public NoBodyException(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	

}
