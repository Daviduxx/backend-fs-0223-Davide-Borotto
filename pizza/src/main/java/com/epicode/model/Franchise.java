package com.epicode.model;

public class Franchise extends Prodotto{
	
	private String nome;
	private double prezzo;
	
	public Franchise(String nome, double prezzo) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
	}

	@Override
	protected double getPrezzo() {
		return this.prezzo;
	}

	@Override
	public String toString() {
		return nome + ", prezzo: " + prezzo + " $";
	}
	
	
	
	
}
