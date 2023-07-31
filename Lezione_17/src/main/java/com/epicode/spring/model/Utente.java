package com.epicode.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Utente {
	
	@Id
	private Long id;
	private String nome;
	private String cognome;
	private Integer eta;

}
