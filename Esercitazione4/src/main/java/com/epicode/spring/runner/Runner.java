package com.epicode.spring.runner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.epicode.spring.enumerations.Tipo;
import com.epicode.spring.model.Edificio;
import com.epicode.spring.model.Postazione;
import com.epicode.spring.model.Prenotazione;
import com.epicode.spring.model.Utente;
import com.epicode.spring.service.EdificioService;
import com.epicode.spring.service.PostazioneService;
import com.epicode.spring.service.PrenotazioneService;
import com.epicode.spring.service.UtenteService;

@Component
public class Runner implements CommandLineRunner{
	
	@Autowired EdificioService ediSvc;
	@Autowired PostazioneService postSvc;
	@Autowired UtenteService uSvc;
	@Autowired PrenotazioneService preSvc;
	
	
	static Logger log = LoggerFactory.getLogger(Runner.class);

	@Override
	public void run(String... args) throws Exception {
		
		//creo degli edifici
		
		System.out.println();
		System.out.println("************* CREAZIONE EDIFICI ************");
		System.out.println();
		
		Edificio e1 = ediSvc.creaEdificio();
		Edificio e2 = ediSvc.creaEdificio();
		Edificio e3 = ediSvc.creaEdificio();
		
		//salvo nel db
//		ediSvc.salvaEdificio(e1);
//		ediSvc.salvaEdificio(e2);
//		ediSvc.salvaEdificio(e3);
		
		
		System.out.println();
		System.out.println("************* TUTTI GLI EDIFICI ************");
		System.out.println();
		
		List<Edificio> edifici = ediSvc.trovaEdifici();
		edifici.forEach(e -> System.out.println("ID edificio: " + e.getId() + " nome: " + e.getName()));
		
//		Edificio edUp = ediSvc.trovaEdificio(1l);
//		edUp.setCitta("Torino");
//		ediSvc.aggioranEdificio(edUp);
		
		//creo le postazioni
		System.out.println();
		System.out.println("************* CREAZIONE POSTAZIONI ************");
		System.out.println();
		
		Postazione p1 = postSvc.creaPostazione(Tipo.PRIVATO, 1, e1);
		Postazione p2 = postSvc.creaPostazione(Tipo.OPENSPACE, 5, e2);
		Postazione p3 = postSvc.creaPostazione(Tipo.SALA_RIUNIONI, 12, e3);
		
		//SAVE
//		postSvc.salvaPostazione(p1);
//		postSvc.salvaPostazione(p2);
//		postSvc.salvaPostazione(p3);
		
		//FIND BY ID
//		Edificio ed1 = ediSvc.trovaEdificio(1L);
//		Edificio ed2 = ediSvc.trovaEdificio(2L);
		Postazione upUpdate = postSvc.trovaPostazione(1l);
		Postazione post2 = postSvc.trovaPostazione(2l);
		Postazione post3 = postSvc.trovaPostazione(3l);
		Postazione post4 = postSvc.trovaPostazione(4l);
//		postSvc.aggiornaPostazione(p1);
//		postSvc.aggiornaPostazione(p2);
		
		//DELETE
//		postSvc.eliminaPostazione(upUpdate);
//		postSvc.eliminaPostazione(post2);
//		postSvc.eliminaPostazione(post3);
//		postSvc.eliminaPostazione(post4);
		
		
		System.out.println();
		System.out.println("************* RICERCA POSTAZIONI DELL'UTENTE ************");
		System.out.println();
		
		//List<Postazione> postazioniTrovate = postSvc.trovaPerCittaETipo("Torino", Tipo.PRIVATO);
		
		//UTENTI
		System.out.println();
		System.out.println("************* CREAZIONE UTENTI ************");
		System.out.println();
		Utente u1 = uSvc.creaUtente();
		Utente u2 = uSvc.creaUtente();
		Utente u3 = uSvc.creaUtente();
//		
//		uSvc.salvaUtente(u1);
//		uSvc.salvaUtente(u2);
//		uSvc.salvaUtente(u3);
		
		//PRENOTAZIONI
		System.out.println();
		System.out.println("************* CREAZIONE PRENOTAZIONI ************");
		System.out.println();
		
		Utente ut1 = uSvc.findUtente(3l);
		
		
		//Prenotazione pre1 = preSvc.creaPrenotazione(LocalDate.of(2023, 11, 29), ut1, upUpdate);
		Prenotazione pre2 = preSvc.creaPrenotazione(LocalDate.of(2023, 9, 4), ut1, post3);
		//Prenotazione pre3 = preSvc.creaPrenotazione(LocalDate.of(2023, 8, 5), u1, p1);
//		
//		preSvc.salvaPrenotazione(pre1);
//		preSvc.salvaPrenotazione(pre2);
//		preSvc.salvaPrenotazione(pre3);
		
//		Prenotazione pren1 = preSvc.findById(4);
//		Prenotazione pren2 = preSvc.findById(5);
//		Prenotazione pren3 = preSvc.findById(6);
//		Prenotazione pren4 = preSvc.findById(7);
//		
//		preSvc.eliminaPrenotazione(pren1);
//		preSvc.eliminaPrenotazione(pren2);
//		preSvc.eliminaPrenotazione(pren3);
//		preSvc.eliminaPrenotazione(pren4);
		
		
		// *************** EXTRA - METODI DEL CRUD NON STRETTAMENTE NECESSARI PER L'ESERCIZIO ************
		//leggo tutte le postazioni
//		System.out.println();
//		System.out.println("************* TUTTE LE POSTAZIONI ************");
//		System.out.println();
//				
//		List<Postazione> postazioni = postSvc.findAll();
//		postazioni.forEach(p -> System.out.println("ID postazione: " + p.getId() + " tipo: " + p.getTipo() + " città: " + p.getEdificio().getCitta()));
	}

}
