package com.epicode.dao;

import javax.persistence.EntityManager;

import com.epicode.model.Location;

import utils.JpaUtil;

public class LocationDAOImpl {
	
	public void save(Location l) {	
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.getMessage();
		} finally {
			em.close();
		}
	}
	
	public void refresh(Location l) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(l);
		} finally {
			em.close();
		}
	}
	
	public Location getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {			
			Location l = em.find(Location.class, id);
			System.out.println(l);
			return l;
		} finally {
			em.close();
		}
	}
	
	public void delete(Location l) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			if (!em.contains(l)) {
	            // Se l'entità non è gestita, caricala nel contesto di persistenza
	            l = em.merge(l);
	        }
			em.remove(l);
			em.getTransaction().commit();
			System.err.println("Location eliminato");
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
