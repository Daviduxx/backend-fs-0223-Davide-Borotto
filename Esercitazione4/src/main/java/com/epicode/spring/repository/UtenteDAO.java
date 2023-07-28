package com.epicode.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.spring.model.Utente;

public interface UtenteDAO extends CrudRepository<Utente, Long> {

}
