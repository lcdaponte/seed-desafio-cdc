package com.github.lcdaponte.desafiocasadocodigo.aplicacao.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request.CriarAutorRequest;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Autor;
import com.github.lcdaponte.desafiocasadocodigo.persistence.respository.autor.IAutorRepository;


public class AutorServiceTest {
	
	@Autowired
	private IAutorService autorService;
	
	private IAutorRepository autorRepository;
	private UUID uuid;
	
	
	@BeforeEach
	void init() {
		autorRepository = mock(IAutorRepository.class);
		autorService = new AutorService(autorRepository);
		uuid = UUID.randomUUID();
	}
	
	@Test
	@DisplayName("Não deve disparar erro caso o email não esteja cadastrado")
	void naoDeveDispararErroEmailJaCadastrado() {
		CriarAutorRequest request = new CriarAutorRequest("Lucas", "lucas@email.com", "excelente autor");
		
		Autor autor = new Autor(uuid, request.getNome(), request.getEmail(), request.getDescricao(), LocalDateTime.now());
		
		when(autorRepository.findByEmail(request.getEmail())).thenReturn(Optional.empty());
		when(autorRepository.save(autor)).thenReturn(autor);
//		doNothing().when(autorRepository).save(autor);
		
		UUID uuidAutor = autorService.cadastrar(request);
		
		assertNotNull(uuidAutor);
	}

}
