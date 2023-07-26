package com.epicode.spring.model;

public abstract class Elemento {
	
	private double price;
	private String nota;

	public Elemento(double price, String nota) {
		super();
		this.price = price;
		this.nota = nota;
	}

	

	@Override
	public String toString() {
		return "Elemento [price=" + price + ", nota=" + nota + "]";
	}



	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	public String getNota() {
		return nota;
	}



	public void setNota(String nota) {
		this.nota = nota;
	}
	
	
	
}
