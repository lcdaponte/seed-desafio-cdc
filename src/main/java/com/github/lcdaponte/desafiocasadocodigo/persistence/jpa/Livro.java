package com.github.lcdaponte.desafiocasadocodigo.persistence.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Type(type = "uuid-char")
	@Column
	private UUID uuid;
	
	@Column
	private String titulo;
	@Column
	private String resumo;
	@Column
	private String sumario;
	@Column
	private BigDecimal preco;
	@Column
	private int numeropaginas;
	@Column
	private String isbn;
	@Column
	private LocalDate dataPublicacao;
	@OneToOne
	private Categoria categoria;
	@OneToOne
	private Autor autor;
	
	public Livro() {
	}
	
	

	public Livro(final UUID uuid, final String titulo, final String resumo, final String sumario, final BigDecimal preco, final int numeropaginas,
			final String isbn, final LocalDate dataPublicacao, final Categoria categoria, final Autor autor) {
		this.setUuid(uuid);
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeropaginas = numeropaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.categoria = categoria;
		this.autor = autor;
	}



	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public int getNumeropaginas() {
		return numeropaginas;
	}

	public void setNumeropaginas(int numeropaginas) {
		this.numeropaginas = numeropaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public UUID getUuid() {
		return uuid;
	}


	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
}
