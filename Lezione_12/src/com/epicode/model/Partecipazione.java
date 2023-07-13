package com.epicode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enumeration.Stato;


@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "persona", nullable = false)
	private Persona persona;
	@Column(name = "evento", nullable = false)
	private Evento evento;
	@Column(name = "stato", nullable = false)
	private Stato stato;
}
