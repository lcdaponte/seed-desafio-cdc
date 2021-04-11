package com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.livro;

import static com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.livro.LivroControllerV1RS.NOME_SERVICO;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.response.Response;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.service.ILivroService;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.autor.AutorControllerV1RS;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.dto.LivroDTO;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request.CadastrarLivroRequest;

@RestController
@RequestMapping(NOME_SERVICO)
public class LivroControllerV1RS {
	
	static final String NOME_SERVICO = "/v1/livros";
	
	private static final Logger log = LoggerFactory.getLogger(AutorControllerV1RS.class);
	private ILivroService livroService;
	
	public LivroControllerV1RS(ILivroService livroService) {
		this.livroService = livroService;
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Response<List<LivroDTO>>> listarTodos() {
		
		
		List<LivroDTO> livros = livroService.listarTodos();
		
		return new ResponseEntity<>(new Response<>(livros), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Response<UUID>> cadastrar(@Valid @RequestBody final CadastrarLivroRequest livrorequest) {
		
		log.debug("livrorequest: {}", livrorequest);
		
		UUID uuid = livroService.cadastrar(livrorequest);
		System.out.println(uuid);
				
		
		return new ResponseEntity<>(new Response<>(uuid), HttpStatus.OK);
	}
	
	
	

}
