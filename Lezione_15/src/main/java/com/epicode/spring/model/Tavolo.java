package com.epicode.spring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Tavolo {
	
	private int numero;
	private int maxCoperti;
	private Stato stato;
	
	
	public void setStato(Stato stato) {
		this.stato = stato;
	}

}
