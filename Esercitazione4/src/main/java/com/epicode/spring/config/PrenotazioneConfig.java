package com.epicode.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.spring.model.Prenotazione;

@Configuration
public class PrenotazioneConfig {
	
	@Bean("prenotazione")
	@Scope("prototype")
	public Prenotazione creaPrenotazione() {
		Prenotazione p = new Prenotazione();
		return p;
	}

}
