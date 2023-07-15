package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.epicode.model.Evento;
import com.epicode.model.EventoDAO;
import com.epicode.model.Location;
import com.epicode.model.LocationDAO;
import com.epicode.model.Partecipazione;
import com.epicode.model.PartecipazioneDAO;
import com.epicode.model.Persona;
import com.epicode.model.PersonaDAO;

import enumeration.Sesso;
import enumeration.Stato;
import enumeration.Type;

public class Main {

	public static void main(String[] args) {
		
		Location loc1 = creaLocation();
		Evento e1 = creaEvento(loc1);
		Persona p1 = creaPersona();
		Partecipazione part1 = creaPartecipazione(e1, p1);
		System.err.println("chiuso");
	}
	
	public static Partecipazione creaPartecipazione(Evento evento, Persona persona) {
		Partecipazione part = new Partecipazione();
		part.setEvento(evento);
		part.setPersona(persona);
		part.setStato(Stato.CONFERMATA);
		PartecipazioneDAO partDAO = new PartecipazioneDAO();
		partDAO.save(part);
		return part;
	}
	
	public static Evento creaEvento(Location loc) {
		Evento evento = new Evento();
		evento.setTitolo("Ligabue");
		evento.setDataEvento(LocalDate.of(2023, 4, 20));
		evento.setDescrizione("lorem ipsum");
		evento.setTipoEvento(Type.PUBBLICO);
		evento.setNumeroMassimoPartecipanti(20000);
		evento.setLocation(loc);
		EventoDAO eDAO = new EventoDAO();
		eDAO.save(evento);
		return evento;
	}
	
	public static Persona creaPersona() {
		Persona persona = new Persona();
		persona.setNome("Mario");
		persona.setCognome("Rossi");
		persona.setEmail("mario@rossi-it");
		persona.setSesso(Sesso.MASCHIO);
		persona.setDataDiNascita(LocalDate.of(1997, 4, 14));
		PersonaDAO persDAO = new PersonaDAO();
		persDAO.save(persona);
		return persona;
	}
	
	public static Location creaLocation() {
		Location loc = new Location();
		loc.setNome("Stadio");
		loc.setCitta("Firenze");
		LocationDAO locDAO = new LocationDAO();
		locDAO.save(loc);
		return loc;
	}

}