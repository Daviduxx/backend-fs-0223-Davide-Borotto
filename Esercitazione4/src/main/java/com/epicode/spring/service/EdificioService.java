package com.epicode.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.spring.model.Edificio;
import com.epicode.spring.repository.GestioneDAO;

@Service
public class EdificioService {
	
	@Autowired GestioneDAO edirepo;
	
	@Autowired @Qualifier("edificio") private ObjectProvider<Edificio> edificioProvider;
	
	public Edificio creaEdificio() {
		Edificio e = edificioProvider.getObject();
		System.out.println("Ho creato il seguente edificio: "  + e.getName() + " , si trova a " + e.getCitta() + " al seguente indirizzo: " + e.getIndirizzo());
		return e;
	}
	
	public void salvaEdificio(Edificio e) {
		edirepo.save(e);
		System.out.println("Edificio " + e.getName() + " salvato nel database!");
	}
	
	public List<Edificio> trovaEdifici(){
		return (List<Edificio>) edirepo.findAll();
	}

}
