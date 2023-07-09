package com.epicode.main;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
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
		aggiungiElemento(new Libro("00-11-77-G", "Mille splendidi soli", Year.of(2013), 321, "Khaled Hosseini", Genere.ROMANZO), listaCatalogo);
		
		eliminaElemento("00-11-33-B", listaCatalogo);
	
		cercaElementoPerISBN("00-11-66-E", listaCatalogo);
		cercaElementoPerAnno(2017, listaCatalogo);
		cercaElementoPerAutore("pippo", listaCatalogo);
		
		try {
			salvaSuDisco();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		
		try {
			caricaDaDisco();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
	

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
		if(elementoCercato.size() != 0) {
			log.info("Trovato: " + elementoCercato);			
		}
		else {
			log.error("Nessun elemento trovato");
		}
	
		return elementoCercato;
	}
	
	public static List<Catalogo> cercaElementoPerAnno(int anno, Set<Catalogo> set){
		
		List<Catalogo> elementoCercato = set.stream()
				.filter(s -> s.getAnnoPubblicazione().equals(Year.of(anno)))
				.collect(Collectors.toList());
		if(elementoCercato.size() != 0) {
			for(Catalogo c : elementoCercato) {
				log.info("Trovato: " + c);
			}
		}
		else {
			log.error("Nessun elemento trovato");
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
		if(elementoCercato.size() != 0) {
			for(Libro l : elementoCercato) {
				log.info("Trovato: " + l);
			}
		}
		else {
			log.error("Nessun elemento trovato");
		}
		
		return elementoCercato;
	}
	
	public static void salvaSuDisco() throws IOException {
		
		String elemento = "";
		for(Catalogo c : listaCatalogo) {
			if(c instanceof Libro) {
				Libro l = (Libro) c;
				elemento +=  "Libro: @" + l.getISBN() + "@" + l.getTitolo() + "@" +l.getAnnoPubblicazione() + "@" + l.getAutore() + "@" + l.getNumeroPagine() + "@" + l.getGenere() + "#";
			}
			else if(c instanceof Rivista) {
				Rivista r = (Rivista) c;
				elemento += "Rivista: @" + r.getISBN() + "@" + r.getTitolo() + "@" + r.getAnnoPubblicazione() + "@" + r.getNumeroPagine() + "@" + r.getPeriodicita() + "#";				
			}
		}
		FileUtils.writeStringToFile(file, elemento, "UTF-8");
		log.info("Archivio aggiornato su file " + file.getPath());
	}
	
	public static Set<Catalogo> caricaDaDisco() throws IOException {
		Set<Catalogo> listaCatalogoAggiornata = new HashSet<>();
		String archivio = FileUtils.readFileToString(file, "UTF-8");
		List<String> splittedCatalogo = Arrays.asList(archivio.split("#"));
		
		for(String e : splittedCatalogo) {
			String[] partial = e.split("@");
			
			if(partial[0].equals("Libro: ")) {
				listaCatalogoAggiornata.add(new Libro(partial[1], partial[2], Year.of(Integer.parseInt(partial[3])), Integer.parseInt(partial[5]), partial[4], Genere.valueOf(partial[6]))) ;	
			}
			else if(partial[0].equals("Rivista: ")) {
				Rivista elemento = new Rivista(partial[1], partial[2], Year.of(Integer.parseInt(partial[3])), Integer.parseInt(partial[4]), Periodicita.valueOf(partial[5]));
				listaCatalogoAggiornata.add(elemento);
			}
		}
		System.out.println("********** ARCHIVIO LETTO DA DISCO *********");
		System.out.println(listaCatalogoAggiornata);
		return listaCatalogoAggiornata;
	}
	
}
