package com.epicode.model;

import java.util.HashMap;

public class Pizza extends Prodotto{
	
	private double prezzo;
	private int calorie;
	private String nome;
	private HashMap<String, Integer> base;

	public Pizza(int calorie, String nome) {
		super();
		this.calorie = calorie;
		this.nome = nome;
		this.base = new HashMap<>();
		this.base.put("Pomodoro", 1);
		this.base.put("Mozzarella", 1);
		this.prezzo = 5;
	}

	public int getCalorie() {
		return calorie;
	}

	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	protected double getPrezzo() {
		return 5;
	}

	@Override
	public String toString() {
		return "Pizza " + nome + " base: " + base + " calorie: " + calorie + " prezzo: " + prezzo + "$";
	}
	
	

}
