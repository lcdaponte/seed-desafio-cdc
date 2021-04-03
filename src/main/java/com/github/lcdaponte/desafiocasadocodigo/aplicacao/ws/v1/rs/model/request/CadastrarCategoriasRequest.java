package com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.validators.UniqueValue;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Categoria;

public class CadastrarCategoriasRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Já existe uma Categoria cadastrada com o nome ${validatedValue}")
	@JsonProperty("nome")
	private String nome;
	
	public CadastrarCategoriasRequest() {
		
	}

	public CadastrarCategoriasRequest(final String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
