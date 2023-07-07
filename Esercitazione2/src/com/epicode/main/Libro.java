package com.epicode.main;

import java.time.Year;

public class Libro extends Catalogo{
	
	private String autore;
	private Genere genere;
	
	public Libro(String iSBN, String titolo, Year annoPubblicazione, int numeroPagine, String autore, Genere genere) {
		super(iSBN, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", ISBN=" + getISBN() + ", Titolo="
				+ getTitolo() + ", Anno di Pubblicazione=" + getAnnoPubblicazione() + ", Numero di Pagine="
				+ getNumeroPagine() + "]";
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
	
	
}
