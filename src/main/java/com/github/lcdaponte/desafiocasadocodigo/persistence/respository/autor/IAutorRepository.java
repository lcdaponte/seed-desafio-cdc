package com.github.lcdaponte.desafiocasadocodigo.persistence.respository.autor;

import java.util.Optional;
import java.util.UUID;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.dto.AutorDTO;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Autor;



public interface IAutorRepository {
	
	Optional<Autor> buscarAutorPorEmail(final String email);
	
	void cadastrarAutor(final UUID uuid, final AutorDTO autorDto);

}
