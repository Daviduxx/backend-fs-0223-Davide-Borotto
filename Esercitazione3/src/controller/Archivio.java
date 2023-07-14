package controller;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enumeration.Genere;
import enumeration.Periodicita;
import model.Elemento;
import model.Libro;
import model.Rivista;
import utils.JpaUtil;

public class Archivio {
	
	private static Logger log = LoggerFactory.getLogger(Archivio.class);
	static EntityManager em = Persistence.createEntityManagerFactory("Esercitazione3").createEntityManager();

	public static void main(String[] args) {
		
		//provare a fare collection di elementi
		//provare a fare una sequence per l'isbn
		
		
		Libro l1 = new Libro();
		l1.setTitolo("The lord of the Rings");
		l1.setAutore("JRR Tolkien");
		l1.setAnnoPubblicazione(1965);
		l1.setGenere(Genere.FANTASY);
		l1.setNumeroPagine(1248);
		//aggiungiElemento(l1);
		
		Rivista r1 = new Rivista();
		r1.setNumeroPagine(154);
		r1.setTitolo("Focus");
		r1.setPeriodicita(Periodicita.MENSILE);
		r1.setAnnoPubblicazione(2007);
		//aggiungiElemento(r1);
		//ricercaPerISBN(13L);
		//eliminaElemento(13L);
		//cercaLibroPerTitolo("The lord of the ");
		cercaRivistaPerTitolo("Foc");
		//cercaRivistaPerAnno(2007);
		//cercaLibroPerAnno(1965);
		//cercaLibroPerAutore("JRR Tolkien");
	}
	
	public static void aggiungiElemento(Elemento elemento) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(elemento);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			log.error("Errore nel salvataggio dell'eloemento " + e.getMessage());
		} finally {
			em.close();
		}
	
	}
	
	public static Elemento ricercaPerISBN(Long isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Elemento e = em.find(Libro.class, isbn);
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
 }
