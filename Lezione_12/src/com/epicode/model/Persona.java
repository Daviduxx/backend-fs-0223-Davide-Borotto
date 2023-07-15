package com.epicode.model;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import enumeration.Sesso;


@Entity
@Table(name = "persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "cognome", nullable = false)
	private String cognome;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "data_di_nascita", nullable = false)
	private LocalDate dataDiNascita;
	@Enumerated(EnumType.STRING)
	@Column(name = "sesso", nullable = true)
	private Sesso sesso;
	@Column(name = "lista_partecipazioni", nullable = true)
	@OrderBy(value = "eventi.data_evento")
	@OneToMany (mappedBy = "persona", cascade = CascadeType.REMOVE)
	//aggiungere @order by e la relazione  one to many e mapped in quanto di tratta questa di classe secondatia
	private List<Partecipazione> listaPartecipazioni;
	
	
	public Persona() {
		super();
	}


	public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso,
			List<Partecipazione> listaPartecipazioni) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
		this.listaPartecipazioni = listaPartecipazioni;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}


	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}


	public Sesso getSesso() {
		return sesso;
	}


	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}


	public List<Partecipazione> getListaPartecipazioni() {
		return listaPartecipazioni;
	}


	public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
		this.listaPartecipazioni = listaPartecipazioni;
	}

		
}