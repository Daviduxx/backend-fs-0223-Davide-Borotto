package com.epicode.spring.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
		e.getPostazione().add(p);
		System.out.println("Ho creato la seguente postazione: " + p.getDescrizione() + " " + p.getTipo());
		return p;
	}
	
	public void salvaPostazione(Postazione p) {
		postRepo.save(p);
		System.out.println("Postazione salvata nel db!");
	}
	
	public Postazione trovaPostazione(Long id) {
		return postRepo.findById(id).get();
	}
	
	public void aggiornaPostazione(Postazione p) {
		postRepo.save(p);
		System.out.println("POstazione numero: " + p.getId() + " modificata.");
	}
	
	public List<Postazione> findAll(){
		return (List<Postazione>) postRepo.findAll();
	}
	
	public List<Postazione> trovaPerCittaETipo(String citta, Tipo tipo){
		List<Postazione> postazioniTrovate = postRepo.findPostazion(tipo, citta);
		if(postazioniTrovate.size() != 0) {
			System.out.println("Ho trovato le seguenti postazioni con i parametri da te richiesti");
			postazioniTrovate.forEach(p -> System.out.println("ID postazione: " + p.getId()));
		}
		else {
			System.out.println("Non è stat trovata nessuna postazione con i parametri da te indicati");
		}
		return postazioniTrovate;
	}
	
}
