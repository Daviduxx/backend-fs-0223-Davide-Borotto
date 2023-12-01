package com.epicode.dao;

import javax.persistence.EntityManager;

import com.epicode.model.PartitaDiCalcio;

import utils.JpaUtil;

public class PartitaDiCalcioDAOImpl {
	
	public void save(PartitaDiCalcio e) {	
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println(ex.getMessage());
		} finally {
			em.close();
		}
	}
	
	public void refresh(PartitaDiCalcio e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(e);
		} finally {
			em.close();
		}
	}
	
	public PartitaDiCalcio getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {			
			PartitaDiCalcio e = em.find(PartitaDiCalcio.class, id);
			System.out.println(e);
			return e;
		} finally {
			em.close();
		}
	}
	
	public void delete(PartitaDiCalcio e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			if (!em.contains(e)) {
	            // Se l'entità non è gestita, caricala nel contesto di persistenza
	            e = em.merge(e);
	        }
			em.remove(e);
			em.getTransaction().commit();
			System.err.println("PartitaDiCalcio eliminato");
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
