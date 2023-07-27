package com.epicode.spring.model;

import jakarta.persistence.Entity;

@Entity
public class Hawaian extends Pizza{

	public Hawaian() {
		super(9, "non mangiare", "Hawaiana", 1450);
	}
	
	
}
