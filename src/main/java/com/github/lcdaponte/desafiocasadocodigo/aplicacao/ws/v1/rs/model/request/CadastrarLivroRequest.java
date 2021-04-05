package com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.validators.UniqueValue;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Livro;

public class CadastrarLivroRequest {
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	
	@NotBlank
	@Max(value = 500)
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
	
	@NotBlank
	private String uuidcategoria;
	
	@NotBlank
	private String uuidautor;

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

	public String getUuidcategoria() {
		return uuidcategoria;
	}

	public void setUuidcategoria(String uuidcategoria) {
		this.uuidcategoria = uuidcategoria;
	}

	public String getUuidautor() {
		return uuidautor;
	}

	public void setUuidautor(String uuidautor) {
		this.uuidautor = uuidautor;
	}

	@Override
	public String toString() {
		return "CadastrarLivroRequest [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", numeropaginas=" + numeropaginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", uuidcategoria=" + uuidcategoria + ", uuidautor=" + uuidautor + "]";
	}
	
	
	

}
