package com.epicode.spring.config;

import java.time.LocalTime;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.spring.model.Franchise;
import com.epicode.spring.model.Hawaian;
import com.epicode.spring.model.Lemonade;
import com.epicode.spring.model.Margherita;
import com.epicode.spring.model.Menu;
import com.epicode.spring.model.Ordine;
import com.epicode.spring.model.Salami;
import com.epicode.spring.model.StatoOrdine;
import com.epicode.spring.model.Water;
import com.epicode.spring.model.Wine;


@Configuration
public class GodfatherConfiguration {
	
	@Bean
	@Scope("prototype")
	public Ordine creaOrdine() {
		Ordine o1 = new Ordine();
		
		o1.setCostoCoperto(1.5);
		o1.setNumCoperti(5);
		o1.setNumeroOrdine(10);
		o1.setOra(LocalTime.of(12, 34));
		o1.setStato(StatoOrdine.IN_CORSO);
		return o1;
	}
	
	
	@Bean
	@Scope("singleton")
	public Menu menuPizzaConfig() {
		Menu m = new Menu();
		m.getMenuPizze().add(margherita());
		m.getMenuPizze().add(salami());
		m.getMenuPizze().add(hawaian());
		
		m.getMenuDrink().add(lemonade());
		m.getMenuDrink().add(water());
		m.getMenuDrink().add(wine());
		
		m.getMenuFranchise().add(franchise(21.99, "Taglia XL", "T-Shirt"));
		m.getMenuFranchise().add(franchise(4.99, null, "Mug"));
		return m;
	}
	
	@Bean
	@Scope("singleton")
	public Margherita margherita() {
		return new Margherita();
	}
	
	@Bean
	@Scope("singleton")
	public Salami salami() {
		return new Salami();
	}
	
	@Bean
	@Scope("singleton")
	public Hawaian hawaian() {
		return new Hawaian();
	}
	
	@Bean
	@Scope("singleton")
	public Lemonade lemonade() {
		return new Lemonade();
	}
	
	@Bean
	@Scope("singleton")
	public Water water() {
		return new Water();
	}
	
	@Bean
	@Scope("singleton")
	public Wine wine() {
		return new Wine();
	}
	
	@Bean
	@Scope("prototype")
	public Franchise franchise(double price, String nota, String name) {
		return new Franchise(price, name, name);
	}

}
