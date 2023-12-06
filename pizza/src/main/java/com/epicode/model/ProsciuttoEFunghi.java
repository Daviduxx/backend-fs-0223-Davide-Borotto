package com.epicode.model;

import java.util.HashMap;

public class ProsciuttoEFunghi extends Pizza{
	
	private HashMap<String, Integer> toppings = new HashMap<>();

	public ProsciuttoEFunghi(int calorie, String nome) {
		super(calorie, nome);
		this.toppings.put("Funghi", 1);
		this.toppings.put("Prosciutto", 2);
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
