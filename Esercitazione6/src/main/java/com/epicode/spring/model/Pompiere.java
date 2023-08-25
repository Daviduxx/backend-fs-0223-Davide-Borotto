package com.epicode.spring.model;

public class Pompiere implements Operatore{
	
	private String nome;
	private String cognome;
	private Integer eta;

	@Override
	public void creaOperatore(String nome, String cognome, Integer eta) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		System.out.println("Pompiere " + nome + " " + cognome + " pronto!");
	}

}
