package com.epicode.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utils.JpaUtil;

public class PersonaDAO {
	
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
			return em.find(Persona.class, id);
		} finally {
			em.close();
		}
	}
	
	public void delete(Persona p) {
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
