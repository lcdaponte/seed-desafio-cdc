package com.github.lcdaponte.desafiocasadocodigo.persistence.jpa;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
public class Categoria {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotNull
	private String nome;
	
	@Type(type = "uuid-char")
	@NotNull
	private UUID uuid;
	
	@Column(name = "data_criacao")
	private LocalDateTime dataCricao;
	
	@Deprecated
	public Categoria() {
		
	}

	public Categoria(final @NotNull String nome, final @NotNull UUID uuid) {
		super();
		this.nome = nome;
		this.uuid = uuid;
		this.dataCricao = LocalDateTime.now();
	}
	
	
}
