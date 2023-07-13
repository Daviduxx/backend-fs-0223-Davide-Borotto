package com.epicode.model;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name = "sesso", nullable = true)
	private Sesso sesso;
	@Column(name = "lista_partecipazioni", nullable = true)
	private List<Partecipazione> listaPartecipazioni;

}
