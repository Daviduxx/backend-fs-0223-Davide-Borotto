package com.epicode.spring.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.epicode.spring.config.GodfatherConfiguration;
import com.epicode.spring.model.Margherita;
import com.epicode.spring.model.Menu;
import com.epicode.spring.model.Ordine;
import com.epicode.spring.model.Salami;
import com.epicode.spring.model.Stato;
import com.epicode.spring.model.Tavolo;
import com.epicode.spring.services.Services;



@Component 
public class GoadfatherRunner implements CommandLineRunner{
	
	@Autowired Services svc;

	@Override
	public void run(String... args) throws Exception {
	
		
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(GodfatherConfiguration.class);
//		Menu menu = (Menu) appContext.getBean("menuPizzaConfig");
//		Tavolo t4 = (Tavolo) appContext.getBean("creaTavoloConfig", 8, 7);
//		Ordine o1 = (Ordine) appContext.getBean("creaOrdine", 10, 1, t4);
//		
//		System.out.println();
//		System.out.println("------------GODFATHER PIZZA------------");
//		System.out.println("------------PIZZAS------------");
//		System.out.println();
//		
//		menu.getMenuPizze().forEach(p -> System.out.println(p.getMenuLine()));
//		
//		System.out.println("------------DRINKS------------");
//		System.out.println();
//		
//		menu.getMenuDrink().forEach(d -> System.out.println(d.getMenuLine()));
//		
//		System.out.println("------------MERCHANDISE------------");
//		System.out.println();
//		
//		menu.getMenuFranchise().forEach(f -> System.out.println(f.getMenuLine()));
//		
//		System.out.println();
//		System.out.println("------------ORDINI------------");
//		System.out.println();
//		
//		o1.addItemMenu(menu.getMenuDrink().get(1));
//		o1.addItemMenu(menu.getMenuDrink().get(1));
//		o1.addItemMenu(menu.getMenuPizze().get(2));
//		o1.addItemMenu(menu.getMenuFranchise().get(0));
//		
//		System.out.println(o1.mostraOrdine());
//		o1.getTotale();
//		
//		appContext.close();
//		
//		Tavolo t1 = svc.creaTavolo(1, 5, Stato.LIBERO);
//		Tavolo t2 = svc.creaTavolo(2, 6, Stato.LIBERO);
//		Tavolo t3 = svc.creaTavolo(3, 2, Stato.OCCUPATO);	
//		Ordine o2 = svc.creaOrdine(5, 1, t1);
//		Ordine o3 = svc.creaOrdine(4, 3, t2);
//		Ordine o4 = svc.creaOrdine(2, 2, t3);
//		
//		System.out.println();
//		System.out.println("------------ORDINI DEL SERVICE ------------");
//		System.out.println();
//		System.out.println(o2);
		
		//commento perche al momento mi interessa solamente creare le tabelle
		
		Margherita m1 = svc.creaMaegherita();
		//Margherita m2 = svc.creaMaegherita();
		System.out.println("Pizza creata: " + m1.getMenuLine());
		svc.salvaElemento(m1);
		//svc.salvaPizza(m2);
		
		Salami s1 = svc.creaSalami();
		svc.salvaElemento(s1);
	}

}
