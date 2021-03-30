package com.github.lcdaponte.desafiocasadocodigo.aplicacao.exception;

public class AutorAlreadyExistsException extends Exception{

	private static final long serialVersionUID = 4305321356777864857L;
	
	public AutorAlreadyExistsException(String message) {
		super(message);
	}

}
