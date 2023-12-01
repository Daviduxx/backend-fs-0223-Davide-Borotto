package com.epicode.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.model.Elemento;
import com.epicode.model.Libro;
import com.epicode.model.Prestito;
import com.epicode.model.Utente;

import utils.JpaUtil;

public class Archivio {
	
	private static Logger log = LoggerFactory.getLogger(Archivio.class);

	// AGGIUNGI ELEMENTO
	
	public void aggiungiElemento(Elemento e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			log.info("Elemento salavato con successo");
		} catch(Exception ex) {
			em.getTransaction().rollback();
			log.error("Errore nel salvataggio dell'elemento " + ex.getMessage());
		} finally {
			em.close();
		}
	
	}
	
	// ELIMINA ELEMENTO PER ISBN
	
	public void eliminaElemento(Long isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Elemento.class, isbn));
			em.getTransaction().commit();
			log.info("Elemento eliminato con successo");
		} catch(Exception ex) {
			em.getTransaction().rollback();
			log.error("Errore nell'eliminazione dell'elemento " + ex.getMessage());
		} finally {
			em.close();
		}
	
	}
	
	// RICERCA PER ISBN
	
	public void cercaISBN(Long isbn) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
		    Elemento e = em.find(Elemento.class, isbn);
			em.getTransaction().commit();
			log.info("Elemento trovato! " + e.getTitolo() + " ISBN: " + e.getCodiceISBN());
		} catch(Exception ex) {
			em.getTransaction().rollback();
			log.error("Errore nell'eliminazione dell'elemento " + ex.getMessage());
		} finally {
			em.close();
		}
	
	}
	
	// RICERCA PER ANNO
	
	public void cercaPerAnno(Integer anno) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			Query q = em.createNamedQuery("cercaPerAnno");
			q.setParameter("anno", anno);
		    List<Elemento> rl = q.getResultList();
		    for(Elemento e : rl) {
			log.info("Elemento trovato! " + e.getTitolo() + " anno: " + e.getAnnoPubblicazione());
		    }
		} catch(Exception ex) {
			em.getTransaction().rollback();
			log.error("Errore nella ricerca degli elementi" + ex.getMessage());
		} finally {
			em.close();
		}
	
	}
	
	// RICERCA PER AUTORE
	
		public void cercaPerAutore(String autore) {
			EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
			try {
				Query q = em.createNamedQuery("cercaPerAutore");
				q.setParameter("autore", autore);
			    List<Libro> rl = q.getResultList();
			    for(Libro e : rl) {
				log.info("Libro trovato! " + e.getTitolo() + " autore: " + e.getAutore());
			    }
			} catch(Exception ex) {
				em.getTransaction().rollback();
				log.error("Errore nella ricerca dei libri!" + ex.getMessage());
			} finally {
				em.close();
			}
		
		}
		
		// RICERCA PER NOMELIKE
		
			public void cercaPerNome(String nome) {
				EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
				try {
					Query q = em.createNamedQuery("cercaPerNomeLike");
					q.setParameter("titolo", "%" + nome + "%");
				    List<Elemento> rl = q.getResultList();
				    for(Elemento e : rl) {
					log.info("Elemento trovato! " + e.getTitolo() + " nome: " + e.getTitolo());
				    }
				} catch(Exception ex) {
					em.getTransaction().rollback();
					log.error("Errore nella ricerca degli elementi!" + ex.getMessage());
				} finally {
					em.close();
				}
			
			}
			
			// AGGIUNGI UTENTE
			
			public void aggiungiUtente(Utente u) {
				EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
				try {
					em.getTransaction().begin();
					em.persist(u);
					em.getTransaction().commit();
					log.info("Utente salavato con successo");
				} catch(Exception ex) {
					em.getTransaction().rollback();
					log.error("Errore nel salvataggio utente " + ex.getMessage());
				} finally {
					em.close();
				}
			
			}
			
			// AGGIUNGI PRESTITO
			
			public void aggiungiPrestito(Prestito p) {
				EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
				try {
					em.getTransaction().begin();
					em.persist(p);
					em.getTransaction().commit();
					log.info("Prestito salavato con successo");
				} catch(Exception ex) {
					em.getTransaction().rollback();
					log.error("Errore nel salvataggio prestito " + ex.getMessage());
				} finally {
					em.close();
				}
			
			}			
			
			// PRESTITO DA TESSERA
			
			public void cercaPrestitoUtente(Long tessera) {
				EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
				try {
					Query q = em.createNamedQuery("findPrestiti");
					q.setParameter("tessera", tessera);
				    List<Prestito> rl = q.getResultList();
				    if(rl.size() == 0) {
				    	log.info("Nessun prestito trovato");
				    }
				    for(Prestito e : rl) {
					log.info("Prestito trovato! " + e.getUtente().getNumeroDiTessera() + " elemento prestato: " + e.getElementoPrestato().getTitolo());
				    }
				} catch(Exception ex) {
					em.getTransaction().rollback();
					log.error("Errore nella ricerca " + ex.getMessage());
				} finally {
					em.close();
				}
			
			}
			
			//  PRESTITI SCADUTI
			
			public void cercaPrestitoScaduto() {
				EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
				try {
					Query q = em.createNamedQuery("findPrestitiScaduti");
					q.setParameter("data", LocalDate.now());
				    List<Prestito> rl = q.getResultList();
				    if(rl.size() == 0) {
				    	log.info("Nessun prestito trovato");
				    }
				    for(Prestito e : rl) {
					log.info("Prestito trovato! ");
				    }
				} catch(Exception ex) {
					em.getTransaction().rollback();
					log.error("Errore nella ricerca " + ex.getMessage());
				} finally {
					em.close();
				}
			
			}
			
			
}
