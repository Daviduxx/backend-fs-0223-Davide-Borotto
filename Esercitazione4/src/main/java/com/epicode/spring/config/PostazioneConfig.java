package com.epicode.spring.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.spring.model.Postazione;
import com.github.javafaker.Faker;

@Configuration
public class PostazioneConfig {
	
	@Bean("postazione")
	@Scope("prototype")
	public Postazione creaPostazione() {
		Postazione p = new Postazione();
		Faker faker = new Faker(new Locale("it-IT"));
		p.setDescrizione(faker.lorem().sentence());
		return p;
	}

}
