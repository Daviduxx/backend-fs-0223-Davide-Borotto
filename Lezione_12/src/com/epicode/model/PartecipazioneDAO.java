package com.epicode.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utils.JpaUtil;

public class PartecipazioneDAO {
	
	public void save(Partecipazione p) {	
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
	
	public void refresh(Partecipazione p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(p);
		} finally {
			em.close();
		}
	}
	
	public Partecipazione getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			return em.find(Partecipazione.class, id);
		} finally {
			em.close();
		}
	}
	
	public void delete(Partecipazione p) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.getMessage();
		} finally {
			em.close();
		}
	}
	
}
