package com.epicode.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	 Logger log = LoggerFactory.getLogger(Main.class);
	
	static List<Product> listaProdotti = new ArrayList<Product>();
	static List<Order> listaOrdini = new ArrayList<Order>();
	
	

	public static void main(String[] args) {
		
		Product p1 = new Product(100, "Computer", "Baby", 1000.50);
		Product p2 = new Product(101, "Lord of the Rings", "books", 123.50);
		Product p3 = new Product(102, "The Hobbit", "books", 119.50);
		Product p4 = new Product(103, "Smartphone", "Baby", 800.23);
		Product p5 = new Product(104, "Harry Potter", "books", 99.50);
		Product p6 = new Product(105, "Prodotto", "Boys", 99.50);
		Product p7 = new Product(106, "prodotto", "Boys", 99.50);
		
		listaProdotti.add(p1);
		listaProdotti.add(p2);
		listaProdotti.add(p3);
		listaProdotti.add(p4);
		listaProdotti.add(p5);
		listaProdotti.add(p6);
		listaProdotti.add(p7);
		
		Customer c1 = new Customer(1000L, "Pippo", 1);
		Customer c2 = new Customer(2000L, "Pluto", 2);
		Customer c3 = new Customer(3000L, "Mario", 2);
		Customer c4 = new Customer(4000L, "Gianni", 3);
		
		Order o1 = new Order(1001L, "SPEDITO", LocalDate.of(2021, 1,1), LocalDate.of(2023, 1,1), Arrays.asList(p1,p2,p3), c1);
		Order o2 = new Order(1002L, "DA SPEDIRE", LocalDate.of(2021, 3, 20), LocalDate.of(2023, 3, 12), Arrays.asList(p4,p5,p6), c2);
		Order o3 = new Order(1003L, "RICEVUTO", LocalDate.of(2021, 3, 20), LocalDate.of(2023, 3, 12), Arrays.asList(p2,p7), c3);
		
		listaOrdini.add(o1);
		listaOrdini.add(o2);
		listaOrdini.add(o3);
		
		//ESERCIZIO 1		
		List<Product> listaFiltrata = esercizio1(listaProdotti);
		listaFiltrata.forEach(o -> System.out.println(o));
		
		//ESERCIZIO 2
		List<Order> ordiniFiltrati = esercizio2(listaOrdini);
		ordiniFiltrati.forEach(o -> System.out.println(o));
		
		//ESERCIZIO 3
		List<Product> listaBoys = esercizio3(listaProdotti);
		listaBoys.forEach(l -> System.out.println(l));
		
		//ESERCIZIO 4
		List<Product> listaData = esercizio4(listaOrdini);
		listaData.forEach(l -> System.out.println(l));
	}
	
	public static List<Product> esercizio1(List<Product> lista) {
		return lista.stream().filter(p -> p.getCategory().equalsIgnoreCase("Books"))
		.filter(p -> p.getPrice() > 100)
		.collect(Collectors.toList());
	}
	
	public static List<Order> esercizio2(List<Order> lista){
		return lista.stream()
				.filter(l -> l.getProduct()
				.stream()
				.anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby"))
						).collect(Collectors.toList());
	}
	
	public static List<Product> esercizio3(List<Product> lista){
		return lista.stream()
				.filter(p -> p.getCategory().equalsIgnoreCase("boys"))
				.map(p -> {
					p.setPrice(p.getPrice() * 0.9);
					return p;
				})
				.collect(Collectors.toList());
	}

	
	public static List<Product> esercizio4(List<Order> ordini){
		return ordini.stream()
				.filter(c -> c.getCustomer().getTier() == 2)
				.filter(c -> c.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
				.filter(c -> c.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
				.flatMap(c -> c.getProduct().stream())
				.distinct()
				.collect(Collectors.toList());
	}
	


}
