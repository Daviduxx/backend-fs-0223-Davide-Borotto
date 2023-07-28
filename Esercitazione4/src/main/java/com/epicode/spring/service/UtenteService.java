package com.epicode.spring.service;

import java.util.Set;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.spring.model.Prenotazione;
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
	
	public Utente findUtente(Long id) {
		return utenteRepo.findById(id).get();
	}
	
//	public void aggiungiPrenotazione(Utente u, Prenotazione prenotazione) {
//		Set<Prenotazione> prenotazioni = u.getPrenotazioni();
//		prenotazioni.forEach(p -> {
//			if(p.getGiornoPrenotazione().equals(prenotazione.getGiornoPrenotazione())) {
//				 System.out.println("Hai già una prenotazione per questa data");
//			} else {
//				u.getPrenotazioni().add(prenotazione);
//				utenteRepo.save(u);
//				System.out.println("Prenotazione aggiunta!");
//			}
//		});
//	}
}
