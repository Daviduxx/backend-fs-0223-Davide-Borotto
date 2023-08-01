package com.epicode.spring.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.spring.model.Utente;
import com.epicode.spring.repository.UtenteDAORepository;

@Service
public class UtenteService {
	
	@Autowired UtenteDAORepository uRepo;
	
	@Autowired @Qualifier("utente") private ObjectProvider<Utente> utenteProvider;
	
	public Utente creaUtente() {
		Utente u = utenteProvider.getObject();
		uRepo.save(u);
		System.out.println("Ho creato il seguente utente: " + u.getNome() + " " + u.getCognome() + " " + u.getEta());
		return u;
	}
	
	
	public List<Utente> getUtenti(){
		return (List<Utente>) uRepo.findAll();
	}
	
	public Utente getUtente(Long id) {
		return uRepo.findById(id).get();	
	}
	
	public Utente creaUtenteCustom(Utente utente) {
		return uRepo.save(utente);
	}

}
