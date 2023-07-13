package com.epicode.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PartecipazioneDAO {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lezione_12");
	static EntityManager em = emf.createEntityManager();
	
	public void save(Partecipazione p) {	
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		System.out.println("Partecipazione Salvata");
	
	
}
    public Partecipazione getById(Long id) {
		em.getTransaction().begin();
		Partecipazione p = em.find(Partecipazione.class, id);
		em.getTransaction().commit();
		System.out.println("Partecipazione trovata");
		return p;
}

	public void delete(Partecipazione p) {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Partecipazione eliminata");
}

	public void refresh(Partecipazione p) {
		em.refresh(p);
	}


}
