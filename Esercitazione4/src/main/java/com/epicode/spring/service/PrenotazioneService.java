package com.epicode.spring.service;

import java.time.LocalDate;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.spring.model.Postazione;
import com.epicode.spring.model.Prenotazione;
import com.epicode.spring.model.Utente;
import com.epicode.spring.repository.PrenotazioneDAO;

@Service
public class PrenotazioneService {
	
	@Autowired PrenotazioneDAO preRepo;
	
	@Autowired @Qualifier("prenotazione") private ObjectProvider<Prenotazione> prenotazioneProvider;
	
	public Prenotazione creaPrenotazione(LocalDate giorno, Utente u, Postazione postazione) {
		Prenotazione p = prenotazioneProvider.getObject();
		p.setGiornoPrenotazione(giorno);
		p.setUtente(u);
		p.setPostazione(postazione);
		System.out.println("Prenotazione del " + p.getGiornoPrenotazione() + " salvata creata");
		return p;
	}
	
	public void salvaPrenotazione(Prenotazione p) {
		preRepo.save(p);
		System.out.println("Prenotazione salvata nel db");
	}

}
