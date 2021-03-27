package com.github.lcdaponte.desafiocasadocodigo.persistence.respository.autor;

import java.util.UUID;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.dto.AutorDTO;



public interface IAutorRepository {
	
	void cadastrarAutor(final UUID uuid, final AutorDTO autorDto);

}
