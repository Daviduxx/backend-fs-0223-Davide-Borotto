package com.epicode.model;

public class Drink extends Prodotto{
	
	private String nome;
	private double prezzo;
	private int calorie;
	
	public Drink(String nome, double prezzo, int calorie) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.calorie = calorie;
	}

	@Override
	protected double getPrezzo() {
		return this.prezzo;
	}

	@Override
	public String toString() {
		return nome + ", prezzo: " + prezzo + " $, calorie: " + calorie;
	}
	
	

}
