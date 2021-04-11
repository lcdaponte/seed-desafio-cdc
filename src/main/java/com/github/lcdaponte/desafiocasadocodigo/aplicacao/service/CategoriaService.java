package com.github.lcdaponte.desafiocasadocodigo.aplicacao.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.model.request.CadastrarCategoriasRequest;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Categoria;
import com.github.lcdaponte.desafiocasadocodigo.persistence.respository.categoria.ICategoriaRepository;

@Service
public class CategoriaService implements ICategoriaService{
	
	private ICategoriaRepository categoriaRepository;
	

	public CategoriaService(ICategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}



	@Override
	public UUID cadastrar(CadastrarCategoriasRequest request) {
		
		
		UUID uuid = UUID.randomUUID();
		
		
		Categoria categoria = new Categoria(request.getNome(), uuid);
		
		categoriaRepository.save(categoria);
		
		return uuid;
	}

}
