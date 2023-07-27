package com.epicode.spring.model;

import jakarta.persistence.Entity;

@Entity
public class Salami extends Pizza{

	public Salami() {
		super(7, "piccante", "Salami", 1500);
	}
	
}
