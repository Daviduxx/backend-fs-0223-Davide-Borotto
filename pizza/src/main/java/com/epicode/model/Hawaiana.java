package com.epicode.model;

import java.util.HashMap;

public class Hawaiana extends Pizza{
	
	private HashMap<String, Integer> toppings = new HashMap<>();

	public Hawaiana(int calorie, String nome) {
		super(calorie, nome);
		this.toppings.put("Ananas", 3);
		this.toppings.put("Prosciutto", 2);
	}

	@Override
	protected double getPrezzo() {
		// TODO Auto-generated method stub
		return 10;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " toppings: " + toppings;
	}
	

}
