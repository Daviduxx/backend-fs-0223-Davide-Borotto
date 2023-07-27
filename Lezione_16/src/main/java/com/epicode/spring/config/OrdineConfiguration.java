package com.epicode.spring.config;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.epicode.spring.model.Ordine;
import com.epicode.spring.model.Stato;
import com.epicode.spring.model.StatoOrdine;
import com.epicode.spring.model.Tavolo;

// faccio un altro file di configurazione perché la bestpractice è di fare un file di config
// per ogni classe pojo

@Configuration
@PropertySource("classpath:application.properties")
public class OrdineConfiguration {
	
	    //capire perche non funziona
	    // edit: non funzionava perche avevo importato value da una libreria sbagliata
		@Value("${ordine.costocoperto}") private double costoCoperto;
		
		@Bean("pippo")
		@Scope("prototype")
		public Ordine creaOrdine() {
			Ordine o1 = new Ordine();
			
			// costo coperto deve essere preso da application properties
			o1.setCostoCoperto(costoCoperto);
			//o1.setNumCoperti(numCoperti);
			//o1.setNumeroOrdine(numeroOrdine);
			o1.setOra(LocalTime.now());
			o1.setStato(StatoOrdine.IN_CORSO);
			//o1.setTavolo(tavolo);
			return o1;
			// i setter commentati sono quelli che prima avevano il parametro nel metodo.
			// i parametri non si possono definire nel config se si usa il service con autowired,
			// ma devono essere indicati direttamente nel service, perché non usiamo più l'appContext, che ci permetteva di mettere parametri
			// in questo modo il metodo ci restituisce un oggetto parziale, che poi viene completato nel service
		}
		
		@Bean("creaTavolo")
		@Scope("prototype")
		public Tavolo creaTavolo() {
			return new Tavolo(); // stessa cosa di ordine: i parametri si mettono nel service
		}

}
