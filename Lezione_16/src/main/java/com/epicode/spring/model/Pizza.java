package com.epicode.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "pizze")
public class Pizza extends Elemento{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int calories;
	
	public Pizza(double price, String nota, String nome, int calories) {
		super(price, nota);
		this.nome = nome;
		this.calories = calories;
	}

	public String getMenuLine() {
		return this.nome + " - " + this.getPrice() + "$ - " + this.calories + " calories - note: " + this.getNota();
	}
}
