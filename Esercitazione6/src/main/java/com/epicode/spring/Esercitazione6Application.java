package com.epicode.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epicode.spring.controller.CentraleController;

@SpringBootApplication
public class Esercitazione6Application {

	public static void main(String[] args) {
		SpringApplication.run(Esercitazione6Application.class, args);
		
		System.out.println("Centrale dei pompieri operativa!");
		
		CentraleController c = new CentraleController();
		c.getSonde();
	}

}
