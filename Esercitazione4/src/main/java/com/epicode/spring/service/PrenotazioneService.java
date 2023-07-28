package com.epicode.spring.service;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.spring.model.Postazione;
import com.epicode.spring.model.Prenotazione;
import com.epicode.spring.model.Utente;
import com.epicode.spring.repository.PostazioneDAO;
import com.epicode.spring.repository.PrenotazioneDAO;

@Service
public class PrenotazioneService {
	
	@Autowired PrenotazioneDAO preRepo;
	@Autowired PostazioneDAO postRepo;
	
	@Autowired @Qualifier("prenotazione") private ObjectProvider<Prenotazione> prenotazioneProvider;
	
	public Prenotazione creaPrenotazione(LocalDate giorno, Utente u, Postazione postazione) {
		Prenotazione pre = prenotazioneProvider.getObject();
		Set<Prenotazione> prenotazioni = u.getPrenotazioni();
		prenotazioni.forEach(pren -> {
			if(pren.getGiornoPrenotazione().equals(giorno)) {
				 System.out.println("Hai già una prenotazione per questa data");
			} 
		});
			if(!postazione.isLibera()){
				System.out.println("Questa postazione è già occupata da un altro utente per il giorno indicato");
			} 	
			else {
				pre.setGiornoPrenotazione(giorno);
				pre.setUtente(u);
				pre.setPostazione(postazione);
				u.getPrenotazioni().add(pre);
				preRepo.save(pre);
				postazione.setLibera(false);
				postRepo.save(postazione);
				System.out.println("Prenotazione del " + pre.getGiornoPrenotazione() + " salvata!");
			}
			System.out.println("works");
			return pre;
		};
		
	
	public void salvaPrenotazione(Prenotazione p) {
		preRepo.save(p);
		System.out.println("Prenotazione salvata nel db");
	}

}
