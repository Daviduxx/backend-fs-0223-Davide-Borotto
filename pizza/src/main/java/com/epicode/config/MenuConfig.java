package com.epicode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.epicode.model.Diavola;
import com.epicode.model.Drink;
import com.epicode.model.Franchise;
import com.epicode.model.Hawaiana;
import com.epicode.model.Menu;
import com.epicode.model.Pizza;
import com.epicode.model.ProsciuttoEFunghi;

@Configuration
public class MenuConfig {
	
	@Bean
	public Menu menu() {
		Menu m = new Menu();
		
		m.getMenuPizze().add(pizzaMargherita());
		m.getMenuPizze().add(pizzaHawaiana());
		m.getMenuPizze().add(pizzaDiavola());
		m.getMenuPizze().add(prscFunghi());
		
		m.getMenuDrink().add(water());
		m.getMenuDrink().add(cola());
		m.getMenuDrink().add(beer());
		m.getMenuDrink().add(wine());
		
		m.getFranchise().add(tshirt());
		m.getFranchise().add(mug());
		
		return m;
	}
	
	@Bean
	public Pizza pizzaMargherita() {
		return new Pizza(1000, "Margherita");
	}
	@Bean
	public Hawaiana pizzaHawaiana() {
		return new Hawaiana(1200, "Hawaiana");
	}
	@Bean
	public Diavola pizzaDiavola() {
		return new Diavola(1300, "Diavola");
	}
	@Bean
	public ProsciuttoEFunghi prscFunghi() {
		return new ProsciuttoEFunghi(1400, "Prosciutto e Funghi");
	}
	
	@Bean
	public Drink water() {
		return new Drink("Water", 2, 0);
	}
	@Bean
	public Drink cola() {
		return new Drink("Cola", 4, 200);
	}
	@Bean
	public Drink beer() {
		return new Drink("Beer", 5, 400);
	}
	@Bean
	public Drink wine() {
		return new Drink("Red Wine", 6, 300);
	}
	@Bean
	public Franchise tshirt() {
		return new Franchise("T-Shirt", 7.99);
	}
	@Bean
	public Franchise mug() {
		return new Franchise("Mug", 15.99);
	}

}
