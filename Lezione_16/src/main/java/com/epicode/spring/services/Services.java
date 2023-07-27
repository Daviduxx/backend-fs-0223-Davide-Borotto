package com.epicode.spring.services;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.spring.model.Elemento;
import com.epicode.spring.model.Margherita;
import com.epicode.spring.model.Ordine;
import com.epicode.spring.model.Pizza;
import com.epicode.spring.model.Salami;
import com.epicode.spring.model.Stato;
import com.epicode.spring.model.Tavolo;
import com.epicode.spring.repository.PizzaDAORepository;

@Service
public class Services {
	
	@Autowired PizzaDAORepository repo;
	
	
	@Autowired @Qualifier("creaTavolo") private ObjectProvider<Tavolo> tavoloProvider;
	@Autowired @Qualifier("pippo") private ObjectProvider<Ordine> ordineProvider;
	@Autowired @Qualifier("creaMargherita") private ObjectProvider<Margherita> margheritaProvider;
	@Autowired @Qualifier("creaSalami") private ObjectProvider<Salami> salamiProvider;
	
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
	
	public Margherita creaMaegherita() {
		Margherita m = margheritaProvider.getObject();
		return m;
	}
	
	public Salami creaSalami() {
		Salami s = salamiProvider.getObject();
		return s;
	}
	
	public void salvaElemento(Elemento p) {
		repo.save(p);
		System.out.println("Pizza " + " salvata nel database delle pizze!");
	}
}
