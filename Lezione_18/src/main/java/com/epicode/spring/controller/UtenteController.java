package com.epicode.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.spring.model.Utente;
import com.epicode.spring.service.UtenteService;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {
	
	@Autowired UtenteService uSvc;
	
	@GetMapping
	public ResponseEntity<List<Utente>> returnAll() {
		List<Utente> lista = uSvc.getUtenti();
		ResponseEntity<List<Utente>> resp = new ResponseEntity<List<Utente>>(lista, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Utente> returnOne(@PathVariable Long id ) {
		Utente u = uSvc.getUtente(id);
		return new ResponseEntity<Utente>(u, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Utente> creaUtente(@RequestBody Utente utente){
		Utente u = uSvc.creaUtenteCustom(utente);
		System.out.println(utente);
		return new ResponseEntity<Utente>(u, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> rimuoviUtente(@PathVariable Long id){
		try {
			String msg = uSvc.eliminaUtente(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);			
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> aggiornaUtente(@PathVariable Utente u){
		Utente ut = uSvc.aggiornaUtente(u);
		return new ResponseEntity<Utente>(ut, HttpStatus.OK);
	}


}
