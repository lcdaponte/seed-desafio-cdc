package com.github.lcdaponte.desafiocasadocodigo.aplicacao.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.exception.AutorAlreadyExistsException;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.dto.AutorDTO;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.dto.AutorDtoBuilder;
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
	@DisplayName("Deve disparar erro caso o email já esteja cadastrado")
	void deveDispararErroEmailJaCadastrado() {
		CriarAutorRequest request = new CriarAutorRequest("Lucas", "lucas@email.com", "excelente autor");
		AutorDTO autorDTO = new AutorDtoBuilder().comNome("Lucas").comEmail("lucas@email.com").comDescricao("excelente autor").build();
		Autor autor = new Autor(uuid, "Lucas", "lucas@email.com", "excelente autor", LocalDateTime.now());

		
		
		when(autorRepository.buscarAutorPorEmail("lucas@email.com")).thenReturn(Optional.of(autor));
		doNothing().when(autorRepository).cadastrarAutor(uuid, autorDTO);
		
		assertThrows(AutorAlreadyExistsException.class, () -> autorService.cadastrarAutor(request));
	}
	
	@Test
	@DisplayName("Não deve disparar erro caso o email não esteja cadastrado")
	void naoDeveDispararErroEmailJaCadastrado() throws AutorAlreadyExistsException {
		CriarAutorRequest request = new CriarAutorRequest("Lucas", "lucas@email.com", "excelente autor");
		AutorDTO autorDTO = new AutorDtoBuilder().comNome("Lucas").comEmail("lucas@email.com").comDescricao("excelente autor").build();
		
		when(autorRepository.buscarAutorPorEmail(autorDTO.getEmail())).thenReturn(Optional.empty());
		doNothing().when(autorRepository).cadastrarAutor(uuid, autorDTO);
		
		UUID uuidAutor = autorService.cadastrarAutor(request);
		
		assertNotNull(uuidAutor);
	}

}
