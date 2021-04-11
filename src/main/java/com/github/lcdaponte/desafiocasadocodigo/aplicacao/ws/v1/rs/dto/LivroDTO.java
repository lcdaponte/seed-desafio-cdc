package com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.dto;

import java.util.UUID;

public class LivroDTO {
	
	private String nome;
	private UUID uuid;

	public LivroDTO(String nome, UUID uuid) {
		this.nome = nome;
		this.uuid = uuid;
	}

	public String getNome() {
		return nome;
	}

	public UUID getUuid() {
		return uuid;
	}
	
	

}
