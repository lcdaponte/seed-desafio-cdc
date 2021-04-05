package com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.livro;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request.CadastrarLivroRequest;

@RestController
@RequestMapping("/v1/livros")
public class LivroControllerV1RS {
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity cadastrar(@Valid @RequestBody CadastrarLivroRequest livrorequest) {
		
		
		System.out.println(livrorequest);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
