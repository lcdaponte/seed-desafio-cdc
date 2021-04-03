package com.github.lcdaponte.desafiocasadocodigo.aplicacao.exception;

public class CategoriaAlreadyExistsException extends Exception{

	private static final long serialVersionUID = 4305321356777864857L;
	
	public CategoriaAlreadyExistsException(String message) {
		super(message);
	}

}
