package com.epicode.spring.model;

import jakarta.persistence.Entity;

@Entity
public class Water extends Drink{

	public Water() {
		super(2, "0.5l", "Water", 0);
	}

}
