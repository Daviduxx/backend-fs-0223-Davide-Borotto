package com.epicode.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
		
		// questo è il main
		
		System.out.println("Benvenuto nella pizzeria 'Godfather's Pizza!'");
	}

}
