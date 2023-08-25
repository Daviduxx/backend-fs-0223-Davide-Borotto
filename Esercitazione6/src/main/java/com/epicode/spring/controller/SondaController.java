package com.epicode.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epicode.spring.model.Sonda;
import com.epicode.spring.service.SondaService;

@RestController
@RequestMapping("/alarm")
public class SondaController {
	
	@Autowired SondaService sSvc;
	
	@PostMapping
	public ResponseEntity<Sonda> creaSonda(@RequestBody Sonda sonda){
		Sonda s = sSvc.creaSonda(sonda);
		System.out.println(sonda);
		return new ResponseEntity<Sonda>(s, HttpStatus.OK);
}

}
