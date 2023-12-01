package com.epicode.tests;

import java.time.LocalDate;

import com.epicode.dao.Archivio;
import com.epicode.model.Elemento;
import com.epicode.model.Genere;
import com.epicode.model.Libro;

import com.epicode.model.Periodicita;
import com.epicode.model.Rivista;

import com.epicode.model.Utente;

import com.epicode.model.Prestito;

public class Main {

	public static void main(String[] args) {
		
		Elemento l2 = new Libro("The Hobbit", 1972, 458, "JRR Tolkien", Genere.FANTASY);
		Elemento l7 = new Libro("The Lord of the Rings", 1972, 458, "JRR Tolkien", Genere.FANTASY);
		Elemento l3 = new Libro("Lo scudo di Talos", 2010, 327, "Valerio Massimo Manfredi", Genere.STORICO);
		Elemento l4 = new Libro("Crypto", 2015, 514, "Dan Brown", Genere.ROMANZO);
		Elemento l5 = new Libro("It", 1997, 745, "Stephen King", Genere.HORROR);
		Elemento l6 = new Libro("Harry Potter", 2010, 745, "JK Rowling", Genere.FANTASY);
		Elemento l8 = new Libro("Il principe mezzo sangue", 2010, 745, "JK Rowling", Genere.FANTASY);
		
		Elemento r2 = new Rivista("National Geographic", 1998, 147, Periodicita.MENSILE);
		Elemento r3 = new Rivista("Rolling Stone", 1984, 189, Periodicita.SETTIMANALE);
		Elemento r4 = new Rivista("Vogue", 2002, 58, Periodicita.SEMESTRALE);
		Elemento r5 = new Rivista("New York Times", 1914, 78, Periodicita.SETTIMANALE);
		Elemento r6 = new Rivista("LA Times", 2010, 78, Periodicita.SETTIMANALE);
		Elemento r7 = new Rivista("Chicago Times", 2010, 78, Periodicita.SETTIMANALE);
		
		Prestito p1 = new Prestito(l2, LocalDate.of(2023, 7, 12), LocalDate.of(2023, 9, 12));
		Prestito p4 = new Prestito(r4, LocalDate.of(2023, 7, 12), LocalDate.of(2023, 7, 24));
		Prestito p5 = new Prestito(r4, LocalDate.of(2023, 7, 12), null);
		
		Utente u1 = new Utente("Mario", "Rossi", LocalDate.of(1998, 4, 15));
		Utente u2 = new Utente("Luigi", "Bianchi", LocalDate.of(1992, 2, 20));
		Utente u3 = new Utente("Maria", "Verdi", LocalDate.of(1999, 10, 2));
		
		u1.getPrestiti().add(p5);
		u1.getPrestiti().add(p4);
		u1.getPrestiti().add(p1);
		
		p1.setUtente(u1);
		p5.setUtente(u1);
		p4.setUtente(u1);
		
		Archivio aDAO = new Archivio();
		
//		aDAO.aggiungiElemento(l7);
//		aDAO.aggiungiElemento(l8);
//		aDAO.aggiungiElemento(l4);
//		aDAO.aggiungiElemento(l5);
		
//		aDAO.aggiungiElemento(r6);
//		aDAO.aggiungiElemento(r7);
//		aDAO.aggiungiElemento(r4);
//		aDAO.aggiungiElemento(r5);
		
//		aDAO.eliminaElemento(4L);
		
//		aDAO.cercaISBN(9l);
		
//		aDAO.cercaPerAnno(2010);
		
//		aDAO.cercaPerAutore("JK Rowling");
//		aDAO.cercaPerAutore("JRR Tolkien");
		
//		aDAO.cercaPerNome("Times");
		
//		aDAO.aggiungiUtente(u1);
//		aDAO.aggiungiUtente(u2);
//		aDAO.aggiungiUtente(u3);
		
//		aDAO.aggiungiUtente(u1);
		
//		aDAO.cercaPrestitoUtente(21l);
		
		aDAO.cercaPrestitoScaduto();
		

	}

}
