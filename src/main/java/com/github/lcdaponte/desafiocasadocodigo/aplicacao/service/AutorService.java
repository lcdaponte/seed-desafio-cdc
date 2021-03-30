package com.github.lcdaponte.desafiocasadocodigo.aplicacao.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.exception.AutorAlreadyExistsException;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.dto.AutorDTO;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.dto.AutorDtoBuilder;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request.CriarAutorRequest;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Autor;
import com.github.lcdaponte.desafiocasadocodigo.persistence.respository.autor.IAutorRepository;

@Service
public class AutorService implements IAutorService{
	
	private IAutorRepository autorRepository;
	
	@Autowired
	public AutorService(final IAutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@Override
	public UUID cadastrarAutor(final CriarAutorRequest autorRequest) throws AutorAlreadyExistsException {
		
		Optional<Autor> autorPorEmail = autorRepository.buscarAutorPorEmail(autorRequest.getEmail());
		
		if(autorPorEmail.isPresent()) {
			throw new AutorAlreadyExistsException("O autor já está cadastrado");
		}
		
		final UUID uuid = UUID.randomUUID();
		
		AutorDTO autorDto = new AutorDtoBuilder()
		.comNome(autorRequest.getNome())
		.comEmail(autorRequest.getEmail())
		.comDescricao(autorRequest.getDescricao())
		.build();
		
		autorRepository.cadastrarAutor(uuid, autorDto);
		
		return uuid;
	}

}
