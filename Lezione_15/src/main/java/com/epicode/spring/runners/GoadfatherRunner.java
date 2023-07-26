package com.epicode.spring.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.epicode.spring.config.GodfatherConfiguration;
import com.epicode.spring.model.Menu;
import com.epicode.spring.model.Ordine;



@Component 
public class GoadfatherRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
	
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(GodfatherConfiguration.class);
		Menu menu = (Menu) appContext.getBean("menuPizzaConfig");
		Ordine o1 = (Ordine) appContext.getBean("creaOrdine");
		
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
		
		System.out.println();
		System.out.println("------------ORDINI------------");
		System.out.println();
		
		o1.addItemMenu(menu.getMenuDrink().get(1));
		o1.addItemMenu(menu.getMenuDrink().get(1));
		o1.addItemMenu(menu.getMenuPizze().get(2));
		o1.addItemMenu(menu.getMenuFranchise().get(0));
		
		System.out.println(o1.mostraOrdine());
		o1.getTotale();
		
		appContext.close();
	}

}
