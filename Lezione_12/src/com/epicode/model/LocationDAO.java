package com.epicode.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import utils.JpaUtil;

public class LocationDAO {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lezione_12");
	static EntityManager em = emf.createEntityManager();
	
	public void save(Location l) {	
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		System.out.println("Location Salvata");
	
	
}
    public Location getById(Long id) {
		em.getTransaction().begin();
		Location l = em.find(Location.class, id);
		em.getTransaction().commit();
		System.out.println("Location trovata");
		return l;
}

	public void delete(Location l) {
		em.getTransaction().begin();
		em.remove(l);
		em.getTransaction().commit();
		System.out.println("Location eliminata");
}

	public void refresh(Location l) {
		em.refresh(l);
	}
}
