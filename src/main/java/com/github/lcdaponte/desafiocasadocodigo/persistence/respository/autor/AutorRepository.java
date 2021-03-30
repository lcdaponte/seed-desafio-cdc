package com.github.lcdaponte.desafiocasadocodigo.persistence.respository.autor;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.lcdaponte.desafiocasadocodigo.aplicacao.ws.v1.rs.dto.AutorDTO;
import com.github.lcdaponte.desafiocasadocodigo.persistence.jpa.Autor;

@Repository
@Transactional
public class AutorRepository implements IAutorRepository{
	
	private final EntityManager em;
	
	@Autowired
	public AutorRepository(final EntityManager em) {
		this.em = em;
	}

	@Override
	public Optional<Autor> buscarAutorPorEmail(String email) {
		Query query = em.createQuery("SELECT a FROM Autor a WHERE a.email = :email");
		query.setParameter("email", email);
		
		
		
		try {
			return Optional.of((Autor) query.getSingleResult());	
		}catch(NoResultException nre) {
			return Optional.empty();
		}
	}
	
	
	@Override
	public void cadastrarAutor(final UUID uuid, final AutorDTO autorDto) {
		Autor autor = new Autor(uuid, autorDto.getNome(), autorDto.getEmail(), autorDto.getDescricao(), autorDto.getDataCriacao());
		
		em.persist(autor);
		
	}


}
