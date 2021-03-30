package com.github.lcdaponte.desafiocasadocodigo.aplicacao.service;

import java.util.UUID;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.exception.AutorAlreadyExistsException;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request.CriarAutorRequest;

public interface IAutorService {
	
	UUID cadastrarAutor(final CriarAutorRequest autorRequest) throws AutorAlreadyExistsException;

}