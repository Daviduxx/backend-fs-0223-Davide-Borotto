package com.epicode.controller;

import java.time.LocalDate;

import com.epicode.model.Evento;
import com.epicode.model.EventoDAO;

import enumeration.Type;

public class Main {

	public static void main(String[] args) {
		
//		Evento e1 = new Evento("Coachella", LocalDate.of(2024, 4, 4), "lorem ipsum", Type.PUBBLICO, 10000);
//		Evento e2 = new Evento("Campovolo", LocalDate.of(2023, 11, 15), "lorem ipsum campovolo", Type.PRIVATO, 8000);
		
		EventoDAO eventoDAO = new EventoDAO();
		//eventoDAO.save(e1);
		//eventoDAO.save(e2);
		
		//Evento e = eventoDAO.getById(2L);
		Evento e2 = eventoDAO.getById(1L);
		eventoDAO.refresh(e2);
		//eventoDAO.delete(e);
	}

}
