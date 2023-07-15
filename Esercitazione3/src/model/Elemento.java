package model;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Elemento {
	
	@Id
	@SequenceGenerator(name = "elemento_seq", sequenceName = "elemento_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "elemento_seq")
    
	private Long codiceISBN;
	
	private String titolo;
	@Column(name = "anno_di_pubblicazione")
	private Integer annoPubblicazione;
	@Column(name = "numeoro_di_pagine")
	private Integer numeroPagine;
	
	
	public Elemento(String titolo, Integer annoPubblicazione, Integer numeroPagine) {
		super();
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}
	
	

	public Elemento() {
		super();
	}



	public Long getCodiceISBN() {
		return codiceISBN;
	}


	public void setCodiceISBN(Long codiceISBN) {
		this.codiceISBN = codiceISBN;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	


	public Integer getAnnoPubblicazione() {
		return annoPubblicazione;
	}



	public void setAnnoPubblicazione(Integer annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}



	public Integer getNumeroPagine() {
		return numeroPagine;
	}


	public void setNumeroPagine(Integer numeroPagine) {
		this.numeroPagine = numeroPagine;
	}


	@Override
	public String toString() {
		return "Elemento [codiceISBN=" + codiceISBN + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numeroPagine + "]";
	}
	
	
	
}
