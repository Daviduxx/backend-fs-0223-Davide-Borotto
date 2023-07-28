package com.epicode.spring.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.spring.model.Edificio;
import com.epicode.spring.service.PrenotazioneService;

@Component
public class Runner implements CommandLineRunner{
	
	@Autowired PrenotazioneService ediSvc;
	
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
	}

}
