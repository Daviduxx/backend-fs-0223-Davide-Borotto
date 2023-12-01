package com.epicode.dao;

import javax.persistence.EntityManager;

import com.epicode.model.Persona;

import utils.JpaUtil;

public class PersonaDAOImpl {
	
	public void save(Persona p) {	
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.getMessage();
		} finally {
			em.close();
		}
	}
	
	public void refresh(Persona p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(p);
		} finally {
			em.close();
		}
	}
	
	public Persona getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {			
			Persona p = em.find(Persona.class, id);
			System.out.println(p);
			return p;
		} finally {
			em.close();
		}
	}
	
	public void delete(Persona p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			if (!em.contains(p)) {
	            // Se l'entità non è gestita, caricala nel contesto di persistenza
	            p = em.merge(p);
	        }
			em.remove(p);
			em.getTransaction().commit();
			System.err.println("Persona eliminato");
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.getMessage();
			System.err.println("errore");
		} finally {
			em.close();
			System.err.println("chiuso");
		}
	}

}
