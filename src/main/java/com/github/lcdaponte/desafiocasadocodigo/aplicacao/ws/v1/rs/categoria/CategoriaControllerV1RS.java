package com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.categoria;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.exception.CategoriaAlreadyExistsException;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.response.Response;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.service.ICategoriaService;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request.CadastrarCategoriasRequest;

@RestController
@RequestMapping("/v1/categorias")
public class CategoriaControllerV1RS {
	
	private ICategoriaService categoriaService;

	public CategoriaControllerV1RS(ICategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}
	
	@RequestMapping(value = "", method = POST)
	public ResponseEntity<Response<UUID>> cadastrar(@RequestBody @Valid final CadastrarCategoriasRequest cadastrarCategoriasRequest) throws CategoriaAlreadyExistsException {
		
		UUID uuid = this.categoriaService.cadastrar(cadastrarCategoriasRequest);
		
		
		return new ResponseEntity<>(new Response<>(uuid), HttpStatus.CREATED);
	}
	
	

}
