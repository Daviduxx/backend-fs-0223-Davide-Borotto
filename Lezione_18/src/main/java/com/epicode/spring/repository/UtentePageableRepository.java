package com.epicode.spring.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.epicode.spring.model.Utente;

@Repository
public interface UtentePageableRepository extends PagingAndSortingRepository<Utente, Long>{
	
	//serve per creare la paginazione
	//si usa pi che altro sul get all, dove riceviamo potenzialmente tanti dati col client

}
