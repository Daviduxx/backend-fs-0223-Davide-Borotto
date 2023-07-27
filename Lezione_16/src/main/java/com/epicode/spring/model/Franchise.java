package com.epicode.spring.model;

public class Franchise extends Elemento{
	
	private String name;

	public Franchise(double price, String nota, String name) {
		super(price, nota);
		this.name = name;
	}
	
	public String getMenuLine() {
		return this.name + " - " + this.getPrice() + "$ - " + " - note: " + this.getNota();
	}
}
