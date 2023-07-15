package controller;

import java.time.LocalDate;
import java.time.Year;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enumeration.Genere;
import enumeration.Periodicita;
import model.Elemento;
import model.Libro;
import model.Prestito;
import model.Rivista;
import model.Utente;
import utils.JpaUtil;

public class Archivio {
	
	
	// PER UMBERTO: non sono riuscito a fare il penultimo esercizio :(
	// scusa per il codice un po' disordinato ma stavo diventando pazzo
	
	
	private static Logger log = LoggerFactory.getLogger(Archivio.class);
	static EntityManager em = Persistence.createEntityManagerFactory("Esercitazione3").createEntityManager();

	public static void main(String[] args) {
		
		Libro l2 = new Libro("The Hobbit", 1972, 458, "JRR Tolkien", Genere.FANTASY);
		Libro l3 = new Libro("Lo scudo di Talos", 2010, 327, "Valerio Massimo Manfredi", Genere.STORICO);
		Libro l4 = new Libro("Crypto", 2015, 514, "Dan Brown", Genere.ROMANZO);
		Libro l5 = new Libro("It", 1997, 745, "Stephen King", Genere.HORROR);
		
		Rivista r2 = new Rivista("National Geographic", 1998, 147, Periodicita.MENSILE);
		Rivista r3 = new Rivista("Rolling Stone", 1984, 189, Periodicita.SETTIMANALE);
		Rivista r4 = new Rivista("Vogue", 2002, 58, Periodicita.SEMESTRALE);
		Rivista r5 = new Rivista("New York Times", 1914, 78, Periodicita.SETTIMANALE);
		
		Prestito p1 = new Prestito(l2, LocalDate.of(2023, 7, 12), null);
		Prestito p4 = new Prestito(r4, LocalDate.of(2023, 7, 12), null);
		Set<Prestito> listaPrestiti1 = new HashSet();
		listaPrestiti1.add(p1);
		listaPrestiti1.add(p4);
		Utente u1 = new Utente("Mario", "Rossi", LocalDate.of(1998, 4, 15), listaPrestiti1);
//		Utente u2 = new Utente("Luigi", "Bianchi", LocalDate.of(1992, 2, 20));
//		Utente u3 = new Utente("Maria", "Verdi", LocalDate.of(1999, 10, 2));
		
		
		
		Prestito p2 = new Prestito(r2, LocalDate.of(2023, 6, 28), null);
		Prestito p3 = new Prestito(l3, LocalDate.of(2023, 1, 12), LocalDate.of(2023, 2, 6));
		

//		aggiungiElemento(p1);
//		aggiungiElemento(p2);
//		aggiungiElemento(p3);
//		aggiungiElemento(p4);
		
//		Libro l1 = new Libro();
//		l1.setTitolo("The lord of the Rings");
//		l1.setAutore("JRR Tolkien");
//		l1.setAnnoPubblicazione(1965);
//		l1.setGenere(Genere.FANTASY);
//		l1.setNumeroPagine(1248);
//		aggiungiElemento(l1);
		
//		Rivista r1 = new Rivista();
//		r1.setNumeroPagine(154);
//		r1.setTitolo("Focus");
//		r1.setPeriodicita(Periodicita.MENSILE);
//		r1.setAnnoPubblicazione(2007);
//		aggiungiElemento(r1);
		
		
		//ricercaPerISBN(29L);
		//eliminaElemento(13L);
		//cercaLibroPerTitolo("The lord of the ");
		//cercaRivistaPerTitolo("Foc");
		//cercaRivistaPerAnno(2007);
		//cercaLibroPerAnno(1965);
		//cercaLibroPerAutore("JRR Tolkien");
		cercaPrestitiScaduti();
	}
	
	public static void aggiungiElemento(Object obj) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			log.error("Errore nel salvataggio dell'elemento " + e.getMessage());
		} finally {
			em.close();
		}
	
	}
	
	public static Elemento ricercaPerISBN(Long isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Elemento e = em.find(Elemento.class, isbn);
			log.info("trovato elemento " + e);
			return e;
		} finally {
			em.close();
		}
	}
	
	public static void eliminaElemento(Long isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Elemento elemento = em.find(Libro.class, isbn);
			em.getTransaction().begin();
			em.merge(elemento);
			em.remove(elemento);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			log.error("Errore nell'eliminazione dell'elemento " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	
	public static List<Rivista> cercaRivistaPerAnno(Integer anno){
		Query q = em.createNamedQuery("Rivista.findAnno");
		q.setParameter("anno_pubblicazione", anno);
		List<Rivista> listaRiviste = q.getResultList();
		log.info("trovato: " + listaRiviste.toString());
		return listaRiviste;
	}
	
	public static List<Libro> cercaLibroPerAnno(Integer anno){
		Query q = em.createNamedQuery("Libro.findAnno");
		q.setParameter("anno", anno);
		List<Libro> listaLibro = q.getResultList();
		log.info("trovato: " + listaLibro.toString());
		return listaLibro;
	}
	
	public static List<Libro> cercaLibroPerAutore(String autore){
		Query q = em.createNamedQuery("Libro.findAutore");
		q.setParameter("autore", autore);
		List<Libro> listaLibri = q.getResultList();
		log.info("trovato: " + listaLibri.toString());
		return listaLibri;
	}
	
	public static Libro cercaLibroPerTitolo(String titolo) {
		Query q = em.createNamedQuery("Libro.findTitolo");
		q.setParameter("titolo", "%" + titolo + "%");
		Libro l = (Libro) q.getSingleResult();
		log.info("trovato" + l);
		return l;
	}
	
	public static Rivista cercaRivistaPerTitolo(String titolo) {
		Query q = em.createNamedQuery("Rivista.findTitolo");
		q.setParameter("titolo", "%" + titolo + "%");
		Rivista r = (Rivista) q.getSingleResult();
		log.info("trovato" + r);
		return r;
	}
	
	public static List<Prestito> cercaPrestitiScaduti() {
		Query q = em.createNamedQuery("Prestito.findMissing");
		List<Prestito> p = q.getResultList();
		log.info("Ecco i preastiti scaduti: " + p.toString());
		return p;
	}
 }
