package com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CadastrarCategoriasRequest {
	
	@NotBlank
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
