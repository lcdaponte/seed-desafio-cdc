package com.github.lcdaponte.desafiocasadocodigo.aplicacao.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request.CriarAutorRequest;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Autor;
import com.github.lcdaponte.desafiocasadocodigo.persistence.respository.autor.IAutorRepository;

@Service
public class AutorService implements IAutorService{
	
	//1
	private IAutorRepository autorRepository;
	
	@Autowired
	public AutorService(final IAutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	@Override
	public UUID cadastrar(final CriarAutorRequest autorRequest) {
		
		final UUID uuid = UUID.randomUUID();
				
		Autor autor = new Autor(uuid, autorRequest.getNome(), autorRequest.getEmail(), autorRequest.getDescricao(), LocalDateTime.now());
		
		autorRepository.save(autor);
		
		return uuid;
	}

}
