package com.epicode.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.spring.model.Utente;

public interface UtenteDAORepository extends CrudRepository<Utente, Long>{
	
	public boolean existsByCognome(String cognome);

}
