package com.epicode.spring.runner;

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
import com.epicode.spring.service.PostazioneService;
import com.epicode.spring.service.PrenotazioneService;

@Component
//@PropertySource("classpath:application.properties")
public class Runner implements CommandLineRunner{
	
	@Autowired PrenotazioneService ediSvc;
	@Autowired PostazioneService postSvc;
	
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
	}

}
