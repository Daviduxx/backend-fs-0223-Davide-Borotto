package com.epicode.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonaDAO {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lezione_12");
	static EntityManager em = emf.createEntityManager();
	
	public void save(Persona p) {	
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Persona Salvata");
	
	
}
    public Persona getById(Long id) {
		em.getTransaction().begin();
		Persona p = em.find(Persona.class, id);
		em.getTransaction().commit();
		System.out.println("Persona trovata");
		return p;
}

	public void delete(Persona p) {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Persona eliminata");
}

	public void refresh(Persona p) {
		em.refresh(p);
	}

}
