package model;

import java.time.LocalDate;
import java.time.Year;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;

import enumeration.Periodicita;


@Entity
@Table(name = "riviste")
@NamedQuery(name = "Rivista.findTitolo", query = "SELECT e FROM Rivista e WHERE e.titolo LIKE :titolo")
@NamedQuery(name = "Rivista.findAnno", query = "SELECT e FROM Rivista e WHERE e.annoPubblicazione = :anno_pubblicazione")
public class Rivista extends Elemento{
	
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

	
	public Rivista(String titolo, Integer annoPubblicazione, Integer numeroPagine,
			Periodicita periodicita) {
		super(titolo, annoPubblicazione, numeroPagine);
		this.periodicita = periodicita;
	}

	public Rivista(String titolo, Integer annoPubblicazione, Integer numeroPagine) {
		super(titolo, annoPubblicazione, numeroPagine);
	}
	
	public Rivista() {
		super();
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + ", getTitolo()="
				+ getTitolo() + ", getAnnoPubblicazione()=" + getAnnoPubblicazione() + ", getNumeroPagine()="
				+ getNumeroPagine() + "]";
	}
	
	
}
