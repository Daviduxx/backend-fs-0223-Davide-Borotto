package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prestiti")
@NamedQuery(name = "findPrestiti", query = "SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND p.utente.numeroDiTessera = :tessera")
@NamedQuery(name = "findPrestitiScaduti", query = "SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND :data > p.dataRestituzionePrevista")
public class Prestito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Utente utente;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Elemento elementoPrestato;
	private LocalDate dataInizioPrestito;
	private LocalDate dataRestituzionePrevista; //(calcolata automaticamente a 30 gg dalla data inizio prestito)
	@Column(name = "data_restituzione_effettiva", nullable = true)
	private LocalDate dataRestituzioneEffettiva;
	
	
	public Prestito(Elemento elementoPrestato, LocalDate dataInizioPrestito,
			LocalDate dataRestituzioneEffettiva) {
		super();
		
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30L);
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}


	public Prestito() {
		super();
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	public Elemento getElementoPrestato() {
		return elementoPrestato;
	}


	public void setElementoPrestato(Elemento elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}


	public LocalDate getDataInizioPrestito() {
		return dataInizioPrestito;
	}


	public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}


	public LocalDate getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}


	public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}


	public LocalDate getDataRestituzioneEffettiva() {
		return dataRestituzioneEffettiva;
	}


	public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}


	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", elementoPrestato=" + elementoPrestato + ", dataInizioPrestito="
				+ dataInizioPrestito + ", dataRestituzionePrevista=" + dataRestituzionePrevista
				+ ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva + "]";
	}

}
