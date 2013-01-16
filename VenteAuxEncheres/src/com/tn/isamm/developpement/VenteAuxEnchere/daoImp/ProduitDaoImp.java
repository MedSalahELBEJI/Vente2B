package com.tn.isamm.developpement.VenteAuxEnchere.daoImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tn.isamm.developpement.VenteAuxEnchere.dao.produitDao;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Produit;

public class ProduitDaoImp implements produitDao {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("myPersistenceUnit");

	private static EntityManager em = emf.createEntityManager();

	public Produit getById(Long id) {
		// TODO Auto-generated method stub
		Produit result = em.find(Produit.class, id);
		return result;
	}

	@Override
	public void supprimerProduit(Long id) {
		// TODO Auto-generated method stub
		Produit obj = getById(id);
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
	}

}
