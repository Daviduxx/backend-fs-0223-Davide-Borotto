package com.epicode.spring.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.spring.model.Utente;
import com.epicode.spring.service.UtenteService;

@Component
public class UtenteRunner implements CommandLineRunner{
	
	@Autowired UtenteService uSvc;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Runner works!");
		
		for(int i = 0; i < 10; i++) {
			uSvc.creaUtente();
		}
		
	}

}
