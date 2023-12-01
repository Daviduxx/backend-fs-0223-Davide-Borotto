package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class PartitaDiCalcio extends Evento{

	private String squadraDiCasa;
	private String squadraOspite;
	private String squadraVincente;
	private int golSquadraCasa;
	private int golSquadraOspite;
	
	public PartitaDiCalcio() {
		super();
	}

	public PartitaDiCalcio(
			String titolo, 
			LocalDate dataEvento, 
			String descrizione, 
			Type tipoEvento,
			Integer numeroMassimoPartecipanti,
			String squadraDiCasa,
			String squadraOspite,
			String squadraVincente,
			int golSquadraCasa,
			int golSquadraOspite
			) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
		this.squadraDiCasa = squadraDiCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.golSquadraCasa = golSquadraCasa;
		this.golSquadraOspite = golSquadraOspite;
	}

	public String getSquadraDiCasa() {
		return squadraDiCasa;
	}

	public void setSquadraDiCasa(String squadraDiCasa) {
		this.squadraDiCasa = squadraDiCasa;
	}

	public String getSquadraOspite() {
		return squadraOspite;
	}

	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public String getSquadraVincente() {
		return squadraVincente;
	}

	public void setSquadraVincente(String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}

	public int getGolSquadraCasa() {
		return golSquadraCasa;
	}

	public void setGolSquadraCasa(int golSquadraCasa) {
		this.golSquadraCasa = golSquadraCasa;
	}

	public int getGolSquadraOspite() {
		return golSquadraOspite;
	}

	public void setGolSquadraOspite(int golSquadraOspite) {
		this.golSquadraOspite = golSquadraOspite;
	}
	
}
