package com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.autor;

import static com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.autor.AutorControllerV1RS.NOME_SERVICO;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.response.Response;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.service.IAutorService;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request.CriarAutorRequest;

@RequestMapping(NOME_SERVICO)
@RestController
public class AutorControllerV1RS {

	static final String NOME_SERVICO = "/v1/autor";
	
	private static final Logger log = LoggerFactory.getLogger(AutorControllerV1RS.class);
	
	private IAutorService autorService;
	
	@Autowired
	public AutorControllerV1RS(final IAutorService autorService) {
		this.autorService = autorService;
	}
	
	
	@RequestMapping(value = "", method = POST)
	public ResponseEntity<Response<UUID>> cadastrarAutor(@RequestBody @Valid final CriarAutorRequest autorRequest){
		
		log.debug("autordto: {}", autorRequest);
		
		UUID autorUuid = autorService.cadastrar(autorRequest);
		
		return new ResponseEntity<>(new Response<>(autorUuid), HttpStatus.OK);
	}
}
