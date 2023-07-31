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
		System.out.println("Ho creato il seguente utente: " + u.getNome() + " " + u.getCognome() + " " + u.getEta());
		return u;
	}
	
	
	// conviene fare una funzione unicac che faccia entrambe le cose
	public void salvaUtente(Utente u) {
		uRepo.save(u);
		System.out.println("Utente " + u.getNome() + " salvato nel db");
	}
	
	public List<Utente> getUtenti(){
		return (List<Utente>) uRepo.findAll();
	}

}
