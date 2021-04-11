package com.github.lcdaponte.desafiocasadocodigo.persistence.respository.autor;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Autor;



public interface IAutorRepository extends CrudRepository<Autor, Long>{
	
	Optional<Autor> findByEmail(final String email);
	
	Optional<Autor> findByUuid(UUID uuid);

}
