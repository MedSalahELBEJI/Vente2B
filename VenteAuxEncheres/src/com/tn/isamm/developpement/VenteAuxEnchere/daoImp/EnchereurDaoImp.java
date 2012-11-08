package com.tn.isamm.developpement.VenteAuxEnchere.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tn.isamm.developpement.VenteAuxEnchere.dao.EnchereurDao;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Enchereur;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Vendeur;

public class EnchereurDaoImp implements EnchereurDao{


	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("myPersistenceUnit");

	private static EntityManager em = emf.createEntityManager();

	public void ajouterEnchereur(Enchereur enchereur) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(enchereur);
		em.getTransaction().commit();
	}

	public void modifierEnchereur(Enchereur enchereur) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.merge(enchereur);
		em.getTransaction().commit();
	}

	public void supprimerEnchereur(Enchereur enchereur) {
		// TODO Auto-generated method stub
		enchereur = findById(enchereur.getIdPersonne());
		em.getTransaction().begin();
		em.remove(enchereur);
		em.getTransaction().commit();
	}

	public Enchereur findById(long id) {
		// TODO Auto-generated method stub
		Enchereur enchereur = em.find(Enchereur.class, id);
		return enchereur;
	}

	public List<Enchereur> getAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT e FROM Enchereur e ";
		Query query = em.createQuery(sql, Enchereur.class);
		List<Enchereur> list = query.getResultList();
		if (list.size() != 0) {
			return list;
		} else {
			return null;
		}
	}
}
