package com.epicode.spring.model;

import jakarta.persistence.Entity;

@Entity
public class Lemonade extends Drink{

	public Lemonade() {
		super(4, "0,33l", "Lemonade", 600);
	}

	
	
	
}
