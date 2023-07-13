package com.epicode.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Partecipazione> partecipazione;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Location location;
	
	
	
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


	public Evento(String titolo, LocalDate dataEvento, String descrizione, Type tipoEvento,
			Integer numeroMassimoPartecipanti, Set<Partecipazione> partecipazione, Location location) {
		super();
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.setPartecipazione(partecipazione);
		this.location = location;
	}


	public Set<Partecipazione> getPartecipazione() {
		return partecipazione;
	}


	public void setPartecipazione(Set<Partecipazione> partecipazione) {
		this.partecipazione = partecipazione;
	}

}