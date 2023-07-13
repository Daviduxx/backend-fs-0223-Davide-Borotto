package com.epicode.model;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utils.JpaUtil;

public class LocationDAO {
	
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
			return em.find(Location.class, id);
		} finally {
			em.close();
		}
	}
	
	public void delete(Location l) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(l);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.getMessage();
		} finally {
			em.close();
		}
	}
	
	
}
