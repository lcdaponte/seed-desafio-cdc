package com.github.lcdaponte.desafiocasadocodigo.aplicacao.service;

import java.util.UUID;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.exception.CategoriaAlreadyExistsException;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request.CadastrarCategoriasRequest;

public interface ICategoriaService {
	
	UUID cadastrar(final CadastrarCategoriasRequest nome) throws CategoriaAlreadyExistsException;

}
