package com.epicode.spring.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import classes.Menu;
import configuration.GodfatherConfiguration;

@Component 
public class GoadfatherRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Runner Works");
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(GodfatherConfiguration.class);
		Menu menu = (Menu) appContext.getBean("menuPizzaConfig");
		
		System.out.println("------------GODFATHER PIZZA------------");
		System.out.println("------------PIZZAS------------");
		
		menu.getMenuPizze().forEach(p -> System.out.println(p.getMenuLine()));
	}

}
