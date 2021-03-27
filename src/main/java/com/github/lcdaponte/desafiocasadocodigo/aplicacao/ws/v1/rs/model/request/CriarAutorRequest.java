package com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarAutorRequest {
	
	@JsonProperty("nome")
	@NotEmpty
	private String nome;
	@JsonProperty("email")
	@Email
	@NotEmpty
	private String email;
	@JsonProperty("descricao")
	@NotEmpty
	@Size(max = 400)
    private String descricao;
	
	public CriarAutorRequest(final String nome, final String email, final String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}
}
