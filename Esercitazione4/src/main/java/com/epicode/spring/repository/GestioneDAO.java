package com.epicode.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.spring.model.Edificio;

public interface GestioneDAO extends CrudRepository<Edificio, Long>{

}
