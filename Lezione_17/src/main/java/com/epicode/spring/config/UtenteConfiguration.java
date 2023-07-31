package com.epicode.spring.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.spring.model.Utente;
import com.github.javafaker.Faker;

@Configuration
public class UtenteConfiguration {
	
	@Bean("utente")
	@Scope("prototype")
	public Utente creaUtente() {
		Utente u = new Utente();
		Faker faker = new Faker(new Locale("it-IT"));
		u.setNome(faker.name().firstName());
		u.setCognome(faker.name().lastName());
		u.setEta(faker.number().numberBetween(18, 99));
		return u;
	}

}
