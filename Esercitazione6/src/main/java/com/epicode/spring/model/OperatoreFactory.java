package com.epicode.spring.model;

public class OperatoreFactory {
	
	public static Operatore creaOperatore(String o, String nome, String cognome, Integer eta) {
		if(o == null) {
			return null;
		}
		else if(o.equalsIgnoreCase("POMPIERE")) {
			Pompiere p = new Pompiere();
			p.creaOperatore(nome, cognome, eta);
			return p;
		}
		else if(o.equalsIgnoreCase("VOLONTARIO")) {
			Volontario v = new Volontario();
			v.creaOperatore(nome, cognome, eta);
			return v;
		}
		return null;
	}

}
