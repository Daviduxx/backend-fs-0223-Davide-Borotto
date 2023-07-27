package com.epicode.spring.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Franchise extends Elemento{
	

	public Franchise(double price, String nota) {
		super(price, nota);
		// TODO Auto-generated constructor stub
	}

	private String name;

	public Franchise(double price, String nota, String name) {
		super(price, nota);
		this.name = name;
	}
	
	public String getMenuLine() {
		return this.name + " - " + this.getPrice() + "$ - " + " - note: " + this.getNota();
	}
}
