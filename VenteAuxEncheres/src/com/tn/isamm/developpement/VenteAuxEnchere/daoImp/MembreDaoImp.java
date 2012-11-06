package com.tn.isamm.developpement.VenteAuxEnchere.daoImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tn.isamm.developpement.VenteAuxEnchere.dao.MembreDao;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Membre;

public class MembreDaoImp implements MembreDao {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("myPersistenceUnit");

	private static EntityManager em = emf.createEntityManager();

	public void ajouterMembre(Membre membre) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(membre);
		em.getTransaction().commit();
	}

	public void modifierMembre(Membre membre) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.merge(membre);
		em.getTransaction().commit();
	}

	public void supprimerMembre(Membre membre) {
		// TODO Auto-generated method stub
		membre = findById(membre.getIdMbr());
		em.getTransaction().begin();
		em.remove(membre);
		em.getTransaction().commit();
	}

	public Membre findById(long id) {
		// TODO Auto-generated method stub
		Membre membre = em.find(Membre.class, id);
		return membre;
	}

}
