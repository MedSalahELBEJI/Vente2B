package com.tn.isamm.developpement.VenteAuxEnchere.daoImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.tn.isamm.developpement.VenteAuxEnchere.dao.VendeurDao;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Vendeur;

public class VendeurDaoImp implements VendeurDao {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("myPersistenceUnit");

	private static EntityManager em = emf.createEntityManager();

	public void ajouterVendeur(Vendeur vendeur) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(vendeur);
		em.getTransaction().commit();
	}

	public void modifierVendeur(Vendeur vendeur) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.merge(vendeur);
		em.getTransaction().commit();
	}

	public void supprimerVendeur(Vendeur vendeur) {
		// TODO Auto-generated method stub
		vendeur = findById(vendeur.getIdPersonne());
		em.getTransaction().begin();
		em.remove(vendeur);
		em.getTransaction().commit();
	}

	public Vendeur findById(long id) {
		// TODO Auto-generated method stub
		Vendeur vendeur = em.find(Vendeur.class, id);
		return vendeur;
	}

	public List<Vendeur> getAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT v FROM Vendeur v ";
		Query query = em.createQuery(sql, Vendeur.class);
		List<Vendeur> list = query.getResultList();
		if (list.size() != 0) {
			return list;
		} else {
			return null;
		}
	}

}
