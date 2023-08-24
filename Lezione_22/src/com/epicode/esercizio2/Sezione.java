package com.epicode.esercizio2;

import java.util.List;

public class Sezione extends ElementoLibro{
	
	private String titolo;
	private List<ElementoLibro> pagine;

	public Sezione(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public void stampa() {
		System.out.println("Stampa del titolo " + this.titolo);
		this.pagine.forEach(p -> p.stampa());
		
	}

	@Override
	public int numeroPagine() {
		return pagine.size();
	}
	
}
