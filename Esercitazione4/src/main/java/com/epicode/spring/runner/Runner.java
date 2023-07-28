package com.epicode.spring.runner;

import java.time.LocalDate;

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
//@PropertySource("classpath:application.properties")
public class Runner implements CommandLineRunner{
	
	@Autowired EdificioService ediSvc;
	@Autowired PostazioneService postSvc;
	@Autowired UtenteService uSvc;
	@Autowired PrenotazioneService preSvc;
	
//	@Value("${postazione.privata}") private Integer singola;
//	@Value("${postazione.openspace}") private Integer open;
//	@Value("${postazione.riunione}") private Integer riunione;
	
	static Logger log = LoggerFactory.getLogger(Runner.class);

	@Override
	public void run(String... args) throws Exception {
		
		//creo degli edifici
		Edificio e1 = ediSvc.creaEdificio();
		Edificio e2 = ediSvc.creaEdificio();
		Edificio e3 = ediSvc.creaEdificio();
		
		//salvo nel db
		ediSvc.salvaEdificio(e1);
		ediSvc.salvaEdificio(e2);
		ediSvc.salvaEdificio(e3);
		
		//creo le postazioni
		Postazione p1 = postSvc.creaPostazione(Tipo.PRIVATO, 1, e1);
		Postazione p2 = postSvc.creaPostazione(Tipo.OPENSPACE, 5, e2);
		Postazione p3 = postSvc.creaPostazione(Tipo.SALA_RIUNIONI, 12, e3);
		
		postSvc.salvaPostazione(p1);
		postSvc.salvaPostazione(p2);
		postSvc.salvaPostazione(p3);
		
		//UTENTI
		Utente u1 = uSvc.creaUtente();
		Utente u2 = uSvc.creaUtente();
		Utente u3 = uSvc.creaUtente();
		
		uSvc.salvaUtente(u1);
		uSvc.salvaUtente(u2);
		uSvc.salvaUtente(u3);
		
		//PRENOTAZIONI
		Prenotazione pre1 = preSvc.creaPrenotazione(LocalDate.of(2023, 7, 29), u3, p3);
		Prenotazione pre2 = preSvc.creaPrenotazione(LocalDate.of(2023, 8, 2), u2, p3);
		Prenotazione pre3 = preSvc.creaPrenotazione(LocalDate.of(2023, 8, 5), u1, p1);
		
		preSvc.salvaPrenotazione(pre1);
		preSvc.salvaPrenotazione(pre2);
		preSvc.salvaPrenotazione(pre3);
	}

}
