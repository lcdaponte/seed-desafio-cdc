package com.github.lcdaponte.desafiocasadocodigo.persistence.respository.livro;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Livro;

public interface ILivroRepository extends CrudRepository<Livro, Long>{
	
	List<Livro> findAll();

}
