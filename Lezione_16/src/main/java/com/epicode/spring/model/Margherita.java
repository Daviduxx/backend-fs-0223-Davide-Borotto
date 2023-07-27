package com.epicode.spring.model;

import jakarta.persistence.Entity;

@Entity
public class Margherita extends Pizza{

	public Margherita() {
		super(5, "vegetariana", "Margherita", 1200);
	}
	
	

}
