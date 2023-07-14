package model;

import java.time.LocalDate;
import java.time.Year;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import enumeration.Genere;

@Entity
@Table(name = "libri")
@NamedQuery(name = "Libro.findTitolo", query = "SELECT e FROM Libro e WHERE e.titolo LIKE :titolo")
@NamedQuery(name = "Libro.findAnno", query = "SELECT e FROM Libro e WHERE e.annoPubblicazione = :anno")
@NamedQuery(name = "Libro.findAutore", query = "SELECT l FROM Libro l WHERE l.autore LIKE :autore")
public class Libro extends Elemento {
	
	
	private String autore;
	@Enumerated(EnumType.STRING)
	private Genere genere;
	
	
	
	public Libro() {
		super();
	}



	public Libro(String titolo, Integer annoPubblicazione, Integer numeroPagine) {
		super(titolo, annoPubblicazione, numeroPagine);
	}



	public Libro(String titolo, Integer annoPubblicazione, Integer numeroPagine, String autore,
			Genere genere) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}



	public String getAutore() {
		return autore;
	}



	public void setAutore(String autore) {
		this.autore = autore;
	}



	public Genere getGenere() {
		return genere;
	}



	public void setGenere(Genere genere) {
		this.genere = genere;
	}



	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + "]";
	}
	
	
}
