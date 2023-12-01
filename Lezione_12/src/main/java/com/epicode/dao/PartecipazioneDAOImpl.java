package com.epicode.dao;

import javax.persistence.EntityManager;

import com.epicode.model.Partecipazione;

import utils.JpaUtil;

public class PartecipazioneDAOImpl {
	
	public void save(Partecipazione par) {	
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(par);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.getMessage();
		} finally {
			em.close();
		}
	}
	
	public void refresh(Partecipazione par) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(par);
		} finally {
			em.close();
		}
	}
	
	public Partecipazione getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {			
			Partecipazione par = em.find(Partecipazione.class, id);
			System.out.println(par);
			return par;
		} finally {
			em.close();
		}
	}
	
	public void delete(Partecipazione par) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			if (!em.contains(par)) {
	            // Se l'entità non è gestita, caricala nel contesto di persistenza
	            par = em.merge(par);
	        }
			em.remove(par);
			em.getTransaction().commit();
			System.err.println("Partecipazione eliminato");
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
