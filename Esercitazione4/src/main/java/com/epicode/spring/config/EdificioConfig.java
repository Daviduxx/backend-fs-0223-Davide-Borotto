package com.epicode.spring.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.spring.model.Edificio;
import com.github.javafaker.Faker;

@Configuration
public class EdificioConfig {
	
	@Bean("edificio")
	@Scope("prototype")
	public Edificio creaEdificio() {
		Faker faker = new Faker(new Locale("it-IT"));
		Edificio e = new Edificio();
		e.setCitta(faker.address().city());
		e.setIndirizzo(faker.address().streetName());
		e.setName(faker.company().name());
		return e;
	}

}
