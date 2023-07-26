package com.epicode.spring.model;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ordine {
	
	private int numeroOrdine;
	private StatoOrdine stato;
	private int numCoperti;
	private LocalTime ora;
	private double costoCoperto;
	private Map<Elemento, Integer> ordinato = new HashMap<Elemento, Integer>();
	
	public void addItemMenu(Elemento item) {
		if(!ordinato.containsKey(item)) {
			ordinato.put(item, 1);			
		} else {
			ordinato.put(item, ordinato.get(item) + 1);
		}
		System.out.println(item + " aggiunto all'ordine");
	}
	
	public String mostraOrdine() {
		return "Numero ordine: " + this.numeroOrdine + " numero Coperti: " + this.numCoperti + " stato dell'ordine "
				+ this.stato + " ora di acquisizione: " + this.ora;
	}
	
	public void getTotale() {
		Double totale = 0.0;
		for(Elemento e : ordinato.keySet()) {
			totale += e.getPrice() * ordinato.get(e);
		}
		
		totale += numCoperti * costoCoperto;
		System.out.println("Totale dell'ordine effettuato: " + totale + " $");
	}
}
