package model;

import java.time.LocalDate;

public class Prestito {
	
	private Utente utente;
	private Elemento elementoPrestato;
	private LocalDate dataInizioPrestito;
	private LocalDate dataRestituzionePrevista; //(calcolata automaticamente a 30 gg dalla data inizio prestito)
	private LocalDate dataRestituzioneEffettiva;
	
	
	public Prestito(Utente utente, Elemento elementoPrestato, LocalDate dataInizioPrestito,
			LocalDate dataRestituzioneEffettiva) {
		super();
		this.utente = utente;
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
