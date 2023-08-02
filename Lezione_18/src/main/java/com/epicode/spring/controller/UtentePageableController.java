package com.epicode.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.spring.model.Utente;
import com.epicode.spring.service.UtenteService;

@RestController
@RequestMapping("api/utenti/pageable")
public class UtentePageableController {
	
	@Autowired UtenteService uSvc;
	
	@GetMapping
	public ResponseEntity<Page<Utente>> returnAll(Pageable pageable) {
		Page<Utente> lista = uSvc.getUtentiPageable(pageable);
		ResponseEntity<Page<Utente>> resp = new ResponseEntity<Page<Utente>>(lista, HttpStatus.OK);
		return resp;
	}

}
