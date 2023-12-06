package com.epicode.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.config.MenuConfig;
import com.epicode.controller.GestioneMenu;
import com.epicode.model.Menu;

@SpringBootApplication
public class PizzaApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PizzaApplication.class, args);
		
		GestioneMenu menu = new GestioneMenu();
		menu.showMenu();
		
		
	}


}
