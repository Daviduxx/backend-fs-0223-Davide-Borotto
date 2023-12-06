package com.epicode.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.epicode.config.MenuConfig;
import com.epicode.model.Menu;

@Component
public class GestioneMenu {
	
	AnnotationConfigApplicationContext appContext;
	Menu menu;
	
	public void showMenu() {
		appContext = new AnnotationConfigApplicationContext(MenuConfig.class);
		menu = (Menu) appContext.getBean("menu");
		
		System.out.println("************ MENU ************");
		System.out.println();
		System.out.println("************ PIZZAS ************");
		System.out.println();
		menu.getMenuPizze().forEach(p -> System.out.println(p));
		System.out.println();
		System.out.println("************ DRINKS ************");
		System.out.println();
		menu.getMenuDrink().forEach(d -> System.out.println(d));
		System.out.println();
		System.out.println("************ FRANCHISE ************");
		System.out.println();
		menu.getFranchise().forEach(f-> System.out.println(f));
	}
	
	
	

}
