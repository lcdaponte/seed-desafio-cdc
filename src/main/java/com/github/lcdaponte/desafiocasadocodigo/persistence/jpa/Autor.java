package com.github.lcdaponte.desafiocasadocodigo.persistence.jpa;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Type(type = "uuid-char")
	@NotNull
	private UUID uuid;
	
	@Column
	private String nome;
	@Column
	private String email;
	@Column(length = 400)
	private String descricao;
	
	@Column(name = "data_criacao")
	private LocalDateTime dataCricao;
	
	
	public Autor() {
		
	}

	public Autor(final UUID uuid, final String nome, final String email, final String descricao, final LocalDateTime dataCricao) {
		this.uuid = uuid;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.dataCricao = dataCricao;
	}
	
	

}
