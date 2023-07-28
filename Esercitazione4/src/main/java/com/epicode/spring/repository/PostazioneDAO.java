package com.epicode.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.spring.model.Edificio;
import com.epicode.spring.model.Postazione;

public interface PostazioneDAO extends CrudRepository<Postazione, Long>{

}
