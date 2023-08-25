package com.epicode.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.spring.model.Sonda;

@Configuration
public class SondaConfiguration {
	
	@Bean("sonda")
	@Scope("prototype")
	public Sonda creaSonda() {
		return new Sonda();
	}

}
