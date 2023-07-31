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
		
		Utente u1 = uSvc.creaUtente();
		Utente u2 = uSvc.creaUtente();
		Utente u3 = uSvc.creaUtente();
		Utente u4 = uSvc.creaUtente();
		
		uSvc.salvaUtente(u1);
		uSvc.salvaUtente(u2);
		uSvc.salvaUtente(u3);
		uSvc.salvaUtente(u4);
		
	}

}
