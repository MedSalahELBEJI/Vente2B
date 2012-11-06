package com.tn.isamm.developpement.VenteAuxEnchere.daoImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.tn.isamm.developpement.VenteAuxEnchere.dao.ObjetDao;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Objet;

public class ObjetDaoImp implements ObjetDao {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("myPersistenceUnit");

	private static EntityManager em = emf.createEntityManager();

	public void ajouterObjet(Objet objet) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
	}

	public void modifierObjet(Objet objet) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.merge(objet);
		em.getTransaction().commit();
	}

	public void supprimerObjet(Objet objet) {
		// TODO Auto-generated method stub
		objet = findById(objet.getIdObjet());
		em.getTransaction().begin();
		em.remove(objet);
		em.getTransaction().commit();
	}

	public Objet findById(long id) {
		// TODO Auto-generated method stub
		Objet objet = em.find(Objet.class, id);
		return objet;
	}

}
