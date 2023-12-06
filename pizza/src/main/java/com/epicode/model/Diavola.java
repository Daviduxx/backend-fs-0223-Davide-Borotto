package com.epicode.model;

import java.util.HashMap;

public class Diavola extends Pizza{
	
	private HashMap<String, Integer> toppings = new HashMap<>();

	public Diavola(int calorie, String nome) {
		super(calorie, nome);
		this.toppings.put("Salamino", 3);
	}

	@Override
	protected double getPrezzo() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public String toString() {
		return super.toString() + " toppings: " + toppings;
	}
	
	
}
