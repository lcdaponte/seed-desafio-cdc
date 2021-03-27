package com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.dto;

import java.time.LocalDateTime;

public class AutorDTO {
	
	private String nome;
	private String email;
    private String descricao;
    private LocalDateTime dataCriacao;
    
	
	public AutorDTO(final String nome, final String email, final String descricao, final LocalDateTime dataCriacao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	
	
}
