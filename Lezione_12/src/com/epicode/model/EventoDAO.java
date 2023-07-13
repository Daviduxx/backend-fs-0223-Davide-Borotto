package com.epicode.model;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utils.JpaUtil;

public class EventoDAO {
		
	
	
	public void save(Evento e) {	
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.getMessage();
		} finally {
			em.close();
		}
	}
	
	public void refresh(Evento e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.refresh(e);
		} finally {
			em.close();
		}
	}
	
	public Evento getById(Long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			return em.find(Evento.class, id);
		} finally {
			em.close();
		}
	}
	
	public void delete(Evento e) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.getMessage();
		} finally {
			em.close();
		}
	}
	
	
}
