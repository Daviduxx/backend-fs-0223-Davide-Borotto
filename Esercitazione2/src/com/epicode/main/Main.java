package com.epicode.main;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
	static Set<Catalogo> listaCatalogo = new HashSet<Catalogo>();
	static Logger log = LoggerFactory.getLogger(Main.class);
	public static File file = new File("doc.archivio.txt");

	public static void main(String[] args) {
		
		aggiungiElemento(new Libro("00-11-22-A", "The Hobbit", Year.of(1960), 1200, "JRR Tolkien", Genere.FANTASY), listaCatalogo);
		aggiungiElemento(new Rivista("00-11-44-C", "National Geographic", Year.of(2017), 129, Periodicita.MENSILE), listaCatalogo);
		aggiungiElemento(new Libro("00-11-33-B", "Harry Potter", Year.of(2000), 321, "JK Rowling", Genere.FANTASY), listaCatalogo);
		aggiungiElemento(new Libro("00-11-77-F", "the Lord of the Rings", Year.of(1970), 1100, "JRR Tolkien", Genere.FANTASY), listaCatalogo);
		aggiungiElemento(new Rivista("00-11-55-D", "Focus", Year.of(2014), 145, Periodicita.SETTIMANALE), listaCatalogo);
		aggiungiElemento(new Rivista("00-11-66-E", "Rolling Stone", Year.of(2017), 115, Periodicita.SETTIMANALE), listaCatalogo);
		//		for(Catalogo c : listaCatalogo) {
//			System.out.println(c);
//		}
		
		eliminaElemento("00-11-33-B", listaCatalogo);
//		for(Catalogo c : listaCatalogo) {
//			System.out.println(c);
//		}
		
		cercaElementoPerISBN("00-11-55-D", listaCatalogo);
		cercaElementoPerAnno(Year.of(2017), listaCatalogo);
		cercaElementoPerAutore("JRR Tolkien", listaCatalogo);
		
		try {
			salvaSuDisco();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	//AGGIUNTA DI UN ELEMENTO (CON CONTROLLI E GESTIONE ERRORI)
	public static void aggiungiElemento(Catalogo elemento, Set<Catalogo> set) {
		try {
			Set<Catalogo> controllo = set.stream()
					.filter(s -> s.getISBN().equals(elemento.getISBN()))
					.collect(Collectors.toSet());
			int annoCorrente = Year.now().getValue();
			if(elemento.getAnnoPubblicazione().getValue() > annoCorrente) {
				throw new MyException("La data di pubblicazione non è valida!");
			}
			else if(controllo.size() != 0){
				throw new MyException("E' stato rilevato un altro elemento con lo stesso codice ISBN");
			}	
			else if(elemento.getNumeroPagine() < 1) {
				throw new MyException("Numero di pagine non valido!");
			}
			else if(elemento.getTitolo() == "") {
				throw new MyException("Titolo non valido!");
			}
			else {
				set.add(elemento);
				log.info(elemento.getTitolo() + " aggiunto correttamente");
			}
		}
		catch(MyException e){
			log.error(e.getMessage());
		}					
	}
	
	
	public static void eliminaElemento(String isbn, Set<Catalogo> set) {
		try {
			boolean found = false;
			for (Iterator<Catalogo> iterator = set.iterator(); iterator.hasNext();) {
			    Catalogo c =  iterator.next();
			    if (c.getISBN() == isbn) {
			        iterator.remove();
			        log.info(isbn + " rimosso");
			        found = true;
			        break;
			    }	   
			}
			if(!found) {	    	
		    	throw new MyException("ISBN " + isbn + " non trovato");	    	
		    }	
		}		
		catch(MyException e) {
			log.error(e.getMessage());			
		}		
}
	
	public static List<Catalogo> cercaElementoPerISBN(String isbn, Set<Catalogo> set)  {
		List<Catalogo> elementoCercato = set.stream()
				.filter(s -> s.getISBN().equals(isbn))
				.collect(Collectors.toList());
		log.info("Trovato: " + elementoCercato);
		return elementoCercato;
	}
	
	public static List<Catalogo> cercaElementoPerAnno(Year anno, Set<Catalogo> set){
		List<Catalogo> elementoCercato = set.stream()
				.filter(s -> s.getAnnoPubblicazione().equals(anno))
				.collect(Collectors.toList());
		for(Catalogo c : elementoCercato) {
			log.info("Trovato: " + c);
		}
		return elementoCercato;
	}
	
	public static List<Libro> cercaElementoPerAutore(String autore, Set<Catalogo> set){
		List<Libro> elementoCercato = set.stream()
				.filter(s -> s instanceof Libro)
				.map(s -> (Libro) s)
				.filter(s -> s.getAutore().equals(autore))
				.distinct()
				.collect(Collectors.toList());
		for(Libro l : elementoCercato) {
			log.info("Trovato: " + l);
		}
		return elementoCercato;
	}
	
	public static void salvaSuDisco() throws IOException {
		
		String elemento = "";
		for(Catalogo c : listaCatalogo) {
			if(c instanceof Libro) {
				elemento += "Libro: " + c.getISBN() + "%" + c.getTitolo() + "%" + c.getNumeroPagine() + "%" + c.getAnnoPubblicazione() + "#" + "\n";
			}
			else if(c instanceof Rivista) {
				elemento += "Rivista: " + c.getISBN() + "%" + c.getTitolo() + "%" + c.getNumeroPagine() + "%" + c.getAnnoPubblicazione() + "#" + "\n";				
			}
		}
		FileUtils.writeStringToFile(file, elemento, "UTF-8");
	}
	
}
