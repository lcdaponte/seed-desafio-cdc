package com.github.lcdaponte.desafiocasadocodigo.aplicacao.service;

import java.util.List;
import java.util.UUID;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.dto.LivroDTO;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request.CadastrarLivroRequest;

public interface ILivroService {
	
	public UUID cadastrar(final CadastrarLivroRequest request);
	
	List<LivroDTO> listarTodos();

}
