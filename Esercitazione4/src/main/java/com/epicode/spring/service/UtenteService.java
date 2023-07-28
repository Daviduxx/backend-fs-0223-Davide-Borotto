package com.epicode.spring.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.spring.model.Utente;
import com.epicode.spring.repository.UtenteDAO;

@Service
public class UtenteService {
	
	@Autowired UtenteDAO utenteRepo;
	
	@Autowired @Qualifier("utente") private ObjectProvider<Utente> utenteProvider;
	
	public Utente creaUtente() {
		Utente u = utenteProvider.getObject();
		System.out.println("Ho creato il seguente utente: " + u.getFullName() + " " + u.getEmail() + " " + u.getUserName());
		return u;
	}
	
	public void salvaUtente(Utente u) {
		utenteRepo.save(u);
		System.out.println("Utente " + u.getUserName() + " salvato nel db");
	}
}
