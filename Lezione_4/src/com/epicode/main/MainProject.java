package com.epicode.main;

import com.epicode.classes.Dipartimento;
import com.epicode.classes.Dipendente;
import com.epicode.classes.Livello;

public class MainProject {

	public static void main(String[] args) {
		
		//ISTANZIAMENTO E TEST DEI METODI GET E SET
		Dipendente d1 = new Dipendente(1, 1200.00, 12.00, Livello.IMPIEGATO, Dipartimento.PRODUZIONE);
		System.out.println(d1.getMatricola());
		System.out.println(d1.getStipendio());
		System.out.println(d1.getStipendioBase());
		System.out.println(d1.setDipartimento(Dipartimento.AMMINISTRAZIONE));
		
		//ISTANZIAMENTO CON SECONDO COSTRUTTORE
		Dipendente d2 = new Dipendente(2, Dipartimento.AMMINISTRAZIONE);
		System.out.println("matricola secondo dipendente: " + d2.getMatricola());
		
		//PRIMO METODO
		System.out.println(d1.toString());
		System.out.println(d2.toString());
		
		//SECONDO METODO
		System.out.println(d1.promuovi());
		System.out.println(d2.promuovi());
		System.out.println(d2.promuovi());
		System.out.println(d2.promuovi());
		System.out.println(d2.promuovi());
		
		//METODI STATICI
		System.out.println(Dipendente.calcolaPaga(d1));
		System.out.println(Dipendente.calcolaPaga(d2));
		
		System.out.println(Dipendente.calcolaPaga(d1, 30));
		System.out.println(Dipendente.calcolaPaga(d2, 10));
	}

}
