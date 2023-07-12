package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enumeration.Type;

@Entity
@Table(name = "eventi")
public class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titolo", nullable = false)
	private String titolo;
	@Column(name = "data_evento", nullable = false)
	private LocalDate dataEvento;
	@Column(name = "descrizione", nullable = false)
	private String descrizione;
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_evento")
	private Type tipoEvento;
	@Column(name = "max_partecipanti")
	private Integer numeroMassimoPartecipanti;
	
	
	
	public Evento() {
		super();
	}


	public Evento(String titolo, LocalDate dataEvento, String descrizione, Type tipoEvento,
			Integer numeroMassimoPartecipanti) {
		super();
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public LocalDate getDataEvento() {
		return dataEvento;
	}


	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}


	public Type getTipoEvento() {
		return tipoEvento;
	}


	public void setTipoEvento(Type tipoEvento) {
		this.tipoEvento = tipoEvento;
	}


	public Integer getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}


	public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}
	
	

	
	
}
