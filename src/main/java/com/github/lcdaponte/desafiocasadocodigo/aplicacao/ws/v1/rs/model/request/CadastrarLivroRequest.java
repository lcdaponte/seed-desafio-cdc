package com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.validators.EntityExists;
import com.github.lcdaponte.desafiocasadocodigo.aplicacao.validators.UniqueValue;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Autor;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Categoria;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Livro;

public class CadastrarLivroRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@Size(min = 50, max = 500)
	@NotBlank
	private String resumo;
	
	private String sumario;
	
	@NotNull
	@Positive
	@Min(value = 20)
	private BigDecimal preco;
	
	@NotNull
	@Positive
	@Min(value = 20)
	private int numeropaginas;
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	
	@NotNull
	@Future
	private LocalDate dataPublicacao;
	
	@NotNull
	@EntityExists(domainClass = Categoria.class, fieldName = "uuid")
	private UUID uuidcategoria;
	
	@NotNull
	@EntityExists(domainClass = Autor.class, fieldName = "uuid")
	private UUID uuidautor;

	public CadastrarLivroRequest() {
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

	public UUID getUuidcategoria() {
		return uuidcategoria;
	}

	public void setUuidcategoria(UUID uuidcategoria) {
		this.uuidcategoria = uuidcategoria;
	}

	public UUID getUuidautor() {
		return uuidautor;
	}

	public void setUuidautor(UUID uuidautor) {
		this.uuidautor = uuidautor;
	}

	@Override
	public String toString() {
		return "CadastrarLivroRequest [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", numeropaginas=" + numeropaginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", uuidcategoria=" + uuidcategoria + ", uuidautor=" + uuidautor + "]";
	}
	
	
	

}
