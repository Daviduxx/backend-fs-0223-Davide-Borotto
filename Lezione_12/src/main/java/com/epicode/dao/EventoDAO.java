package com.epicode.dao;

import com.epicode.model.Evento;

public interface EventoDAO {
	
	public void save(Evento e);
	
	public void refresh(Evento e);
	
	public Evento getById(Long id);
	
	public void delete(Evento e);

}
