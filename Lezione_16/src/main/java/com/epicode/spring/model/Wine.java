package com.epicode.spring.model;

import jakarta.persistence.Entity;

@Entity
public class Wine extends Drink{

	public Wine() {
		super(7, "0.4l", "Wine", 520);
	}

}
