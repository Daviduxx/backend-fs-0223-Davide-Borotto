package com.epicode.spring.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.epicode.spring.model.Utente;
import com.epicode.spring.repository.UtenteDAORepository;
import com.epicode.spring.repository.UtentePageableRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UtenteService {
	
	@Autowired UtenteDAORepository uRepo;
	
	@Autowired @Qualifier("utente") private ObjectProvider<Utente> utenteProvider;
	
	@Autowired UtentePageableRepository cuRepo;
	
	
	//metodo getall che usa la paginazione, usa una repository diversa
	public Page<Utente> getUtentiPageable(Pageable pageable){
		return cuRepo.findAll(pageable);
	}
	
	public Utente creaUtente() {
		Utente u = utenteProvider.getObject();
		uRepo.save(u);
		System.out.println("Ho creato il seguente utente: " + u.getNome() + " " + u.getCognome() + " " + u.getEta());
		return u;
	}
	
	//metodo getall normale
	public List<Utente> getUtenti(){
		return (List<Utente>) uRepo.findAll();
	}
	
	public Utente getUtente(Long id) {
		if(!uRepo.existsById(id)) {
			throw new EntityNotFoundException("L'utente riuchiesto è inesistente!");
		}
		return uRepo.findById(id).get();	
	}
	
	public Utente creaUtenteCustom(Utente utente) {
		if(uRepo.existsByCognome(utente.getCognome())) {
			throw new EntityExistsException("Questo cognome esiste già!");
		}
		return uRepo.save(utente);
	}
	
	public String eliminaUtente(Long id) {
		if(!uRepo.existsById(id)) {
			throw new EntityNotFoundException("L'utente riuchiesto è inesistente!");
		}
		Utente u = uRepo.findById(id).get();
		uRepo.delete(u);
		return "Utente eliminato";
	}
	
	public Utente aggiornaUtente(Utente u, Long id) {
		if(!uRepo.existsById(id)) {
			throw new EntityNotFoundException("L'utente riuchiesto è inesistente!");
		}
		if(id != u.getId()) {
			throw new EntityNotFoundException("L'id e l'id dell'utente non corrispondono!");
		}
		return uRepo.save(u);
	}

}
