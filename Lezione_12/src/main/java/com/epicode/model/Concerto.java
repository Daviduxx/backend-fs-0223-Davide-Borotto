package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Concerto extends Evento{
	
	private Genere genere;
	private boolean inStreaming;
	
	public Concerto() {
		super();
	}

	public Concerto(String titolo, LocalDate dataEvento, String descrizione, Type tipoEvento,
			Integer numeroMassimoPartecipanti, Genere genere, boolean inStreaming) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
		this.genere = genere;
		this.inStreaming = inStreaming;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public boolean isInStreaming() {
		return inStreaming;
	}

	public void setInStreaming(boolean inStreaming) {
		this.inStreaming = inStreaming;
	}
	
	

}
