package com.github.lcdaponte.desafiocasadocodigo.aplicacao.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request.CadastrarLivroRequest;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Autor;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Categoria;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Livro;
import com.github.lcdaponte.desafiocasadocodigo.persistence.respository.autor.IAutorRepository;
import com.github.lcdaponte.desafiocasadocodigo.persistence.respository.categoria.ICategoriaRepository;
import com.github.lcdaponte.desafiocasadocodigo.persistence.respository.livro.ILivroRepository;

@Service
public class LivroService implements ILivroService{
	
	private ILivroRepository livroRepository;
	private IAutorRepository autorRepository;
	private ICategoriaRepository categoriaRepository;
	
	public LivroService(final ILivroRepository livroRepository, 
						final IAutorRepository autorRepository, 
						final ICategoriaRepository categRepository) {
		this.livroRepository = livroRepository;
		this.autorRepository = autorRepository;
		this.categoriaRepository = categRepository;
	}
	
	public UUID cadastrar(final CadastrarLivroRequest request) {
		
		Optional<Autor> autor = this.autorRepository.findByUuid(request.getUuidautor());
		Optional<Categoria> categoria = this.categoriaRepository.findByUuid(request.getUuidcategoria());
		

		UUID uuid = UUID.randomUUID();
		Livro livro = new Livro(uuid, request.getTitulo(), request.getResumo(), request.getSumario(), request.getPreco(), request.getNumeropaginas(), request.getIsbn(), request.getDataPublicacao(), categoria.get(), autor.get());
		
		livroRepository.save(livro);
		
		return uuid;			
		
	}

}
