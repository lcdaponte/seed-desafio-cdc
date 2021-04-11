package com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.dto;

import java.util.UUID;

public class LivroDtoBuilder {
	
	private String nome;
	private UUID uuid;
    
    public LivroDtoBuilder() {
    	
    }
	
	public LivroDtoBuilder(final String nome, final UUID uuid) {
		this.nome = nome;
		this.uuid = uuid;
	}

	public LivroDtoBuilder comNome(final String nome) {
		this.nome = nome;
		return this;
	}

	public LivroDtoBuilder comUuid(final UUID uuid) {
		this.uuid = uuid;
		return this;
	}
	
	
	
	public LivroDTO build() {
		return new LivroDTO(this.nome, this.uuid);
	}
	
	
	

}
