package com.epicode.spring.model;

import java.util.HashSet;
import java.util.Set;

import com.epicode.spring.enumerations.Tipo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "postazioni")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Postazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descrizione;
	private Tipo tipo;
	private Integer maxOccuopanti;
	@ManyToOne
	private Edificio edificio;
	private boolean libera = true;
	@OneToMany
	private Set<Prenotazione> prenotazione = new HashSet<Prenotazione>();

}
