package com.epicode.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.epicode.spring.enumerations.Tipo;
import com.epicode.spring.model.Edificio;
import com.epicode.spring.model.Postazione;

public interface PostazioneDAO extends CrudRepository<Postazione, Long>{
	
	@Query("SELECT p FROM Postazione p WHERE p.tipo =:tipo AND p.edificio.citta = :citta")
	public List<Postazione> findPostazion(Tipo tipo, String citta);
	
}
