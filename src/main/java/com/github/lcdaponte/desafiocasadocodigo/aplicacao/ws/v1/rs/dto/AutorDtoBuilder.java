package com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.dto;

import java.time.LocalDateTime;

public class AutorDtoBuilder {
	
	private String nome;
	private String email;
    private String descricao;
    
    public AutorDtoBuilder() {
    	
    }
	
	public AutorDtoBuilder(final String nome, final String email, final String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public AutorDtoBuilder comNome(final String nome) {
		this.nome = nome;
		return this;
	}

	public AutorDtoBuilder comEmail(final String email) {
		this.email = email;
		return this;
	}
	
	public AutorDtoBuilder comDescricao(final String descricao) {
		this.descricao = descricao;
		return this;
	}
	
	
	public AutorDTO build() {
		return new AutorDTO(this.nome, this.email, this.descricao, LocalDateTime.now());
	}
	
	
	

}
