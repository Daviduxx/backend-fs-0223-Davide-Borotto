package com.epicode.spring.service;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.epicode.spring.enumerations.Tipo;
import com.epicode.spring.model.Edificio;
import com.epicode.spring.model.Postazione;
import com.epicode.spring.repository.PostazioneDAO;

@Service
public class PostazioneService {
	
	
	@Autowired PostazioneDAO postRepo;
	
	@Autowired @Qualifier("postazione") private ObjectProvider<Postazione> postazioneProvider;
	
	public Postazione creaPostazione(Tipo tipo, Integer maxOccupanti, Edificio e) {
		Postazione p = postazioneProvider.getObject();
		p.setTipo(tipo);
		p.setMaxOccuopanti(maxOccupanti);
		p.setEdificio(e);
		System.out.println("Ho creato la seguente postazione: " + p.getDescrizione() + " " + p.getTipo() + ". Si trova nell'edificio " + p.getEdificio());
		return p;
	}
	
	public void salvaPostazione(Postazione p) {
		postRepo.save(p);
		System.out.println("Postazione salvata nel db!");
	}
}
