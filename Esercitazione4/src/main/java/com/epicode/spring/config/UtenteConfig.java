package com.epicode.spring.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.spring.model.Utente;
import com.github.javafaker.Faker;

@Configuration
public class UtenteConfig {
	
	@Bean("utente")
	@Scope("prototype")
	public Utente creaUtente() {
		Utente u = new Utente();
		Faker faker = new Faker(new Locale("it-IT"));
		u.setUserName(faker.name().username());
		u.setEmail(faker.internet().emailAddress());
		u.setFullName(faker.name().fullName());
		return u;
	}
}
