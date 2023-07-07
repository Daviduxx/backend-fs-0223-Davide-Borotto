package com.epicode.main;

import java.time.Year;

public class Rivista extends Catalogo{

	private Periodicita periodicita;

	public Rivista(String iSBN, String titolo, Year annoPubblicazione, int numeroPagine, Periodicita periodicita) {
		super(iSBN, titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + ", ISBN=" + getISBN() + ", Titolo=" + getTitolo()
				+ ", anno di pubblicazione=" + getAnnoPubblicazione() + ", numero di pagine=" + getNumeroPagine()
				+ "]";
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}
	
	

	
	
	
	
}
