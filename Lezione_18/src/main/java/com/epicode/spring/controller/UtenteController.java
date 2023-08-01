package com.epicode.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.epicode.spring.model.Utente;
import com.epicode.spring.service.UtenteService;

@Controller
public class UtenteController {
	
	// è giusto fare l'autowired del service sul controller
	@Autowired UtenteService uSvc;
	
	@GetMapping("/")
	public @ResponseBody String getHomePage() {
		return "<h1>Questa è una pagina di test</h1>";
	}
	
	@GetMapping("/about")
	public String getAbout() {
		return "about.html";
	}
	@GetMapping("/users")
	public String getDb() {
		//leggo tutti gli utenti dal database
		List<Utente> listaUtenti = uSvc.getUtenti();
		System.out.println("nel dv sono presenti " + listaUtenti.size() + " utenti");
		return "users.html";
	}

}
