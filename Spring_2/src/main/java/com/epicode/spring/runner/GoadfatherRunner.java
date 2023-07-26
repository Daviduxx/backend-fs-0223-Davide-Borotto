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
	
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(GodfatherConfiguration.class);
		Menu menu = (Menu) appContext.getBean("menuPizzaConfig");
		
		System.out.println();
		System.out.println("------------GODFATHER PIZZA------------");
		System.out.println("------------PIZZAS------------");
		System.out.println();
		
		menu.getMenuPizze().forEach(p -> System.out.println(p.getMenuLine()));
		
		System.out.println("------------DRINKS------------");
		System.out.println();
		
		menu.getMenuDrink().forEach(d -> System.out.println(d.getMenuLine()));
		
		System.out.println("------------MERCHANDISE------------");
		System.out.println();
		
		menu.getMenuFranchise().forEach(f -> System.out.println(f.getMenuLine()));
	}

}
