package com.epicode.spring.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.spring.model.Ordine;
import com.epicode.spring.model.Stato;
import com.epicode.spring.model.Tavolo;

@Service
public class Services {
	
	
	@Autowired @Qualifier("creaTavolo") private ObjectProvider<Tavolo> tavoloProvider;
	@Autowired @Qualifier("pippo") private ObjectProvider<Ordine> ordineProvider;
	
	public Ordine creaOrdine(int numCoperti, int numeroOrdine, Tavolo tavolo) {
		Ordine o = ordineProvider.getObject();
		o.setNumCoperti(numCoperti);
		o.setNumeroOrdine(numeroOrdine);
		o.setTavolo(tavolo);
		return o;
	}
	
	public Tavolo creaTavolo(int numero, int maxCoperti, Stato stato) {
		Tavolo t = tavoloProvider.getObject();
		t.setMaxCoperti(maxCoperti);
		t.setNumero(numero);
		t.setStato(stato);
		return t;
	}
}
