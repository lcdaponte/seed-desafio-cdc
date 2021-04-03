package com.github.lcdaponte.desafiocasadocodigo.persistence.respository.categoria;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{
	
	Optional<Categoria> findByNome(String nome);
	

}
