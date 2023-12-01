package com.epicode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = "cercaPerAnno", query = "SELECT e FROM Elemento e WHERE e.annoPubblicazione = :anno")
@NamedQuery(name = "cercaPerNomeLike", query = "SELECT e FROM Elemento e WHERE e.titolo LIKE :titolo")
public abstract class Elemento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codiceISBN;
	private String titolo;
	private Integer annoPubblicazione;
	private Integer numeroPagine;
	
	public Elemento() {
		super();
	}

	public Elemento(String titolo, Integer annoPubblicazione, Integer numeroPagine) {
		super();
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
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
	
	

}
