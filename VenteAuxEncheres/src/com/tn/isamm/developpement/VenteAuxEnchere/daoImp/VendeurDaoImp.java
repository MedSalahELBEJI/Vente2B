package com.tn.isamm.developpement.VenteAuxEnchere.daoImp;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tn.isamm.developpement.VenteAuxEnchere.dao.VendeurDao;
import com.tn.isamm.developpement.VenteAuxEnchere.model.ActEnchere;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Categorie;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Produit;
import com.tn.isamm.developpement.VenteAuxEnchere.model.VEnchere;
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

	public void ajouterProduit(Produit produit) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(produit);
		em.getTransaction().commit();
	}

	public List<Produit> getAllProduit(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT p FROM Produit p ,Vendeur v WHERE p.vendeur.idPersonne=v.idPersonne AND v.login='"
				+ username + "'";
		Query query = em.createQuery(sql, Produit.class);
		List<Produit> list = query.getResultList();
		if (list.size() != 0) {
			return list;
		} else {
			return null;
		}
	}

	public List<VEnchere> getAllProduit() {
	
		String sql = "SELECT p FROM VEnchere p  WHERE p.dateFin > CURRENT_DATE ";
		Query query = em.createQuery(sql, VEnchere.class);
		List<VEnchere> list = query.getResultList();
		

		if (list.size() != 0) {
			return list;
		} else {
			return null;
		}
	}

	public Categorie findByID(long id) {
		// TODO Auto-generated method stub
		String sql = "SELECT c FROM Categorie c WHERE c.idCategorie=" + id;
		Query query = em.createQuery(sql, Categorie.class);
		Categorie cat = (Categorie) query.getSingleResult();
		return cat;
	}

	public List<Categorie> listCategorie() {
		// TODO Auto-generated method stub
		String sql = "SELECT c FROM Categorie c ";
		Query query = em.createQuery(sql, Categorie.class);
		List<Categorie> list = query.getResultList();
		if (list.size() != 0) {
			return list;
		} else {
			return null;
		}
	}

	@Override
	public List<VEnchere> getAllEncheres(String username) {
		// TODO Auto-generated method stub
		String sql = "SELECT p FROM VEnchere p ,Vendeur v WHERE p.vendeur.idPersonne=v.idPersonne AND v.login='"
				+ username + "'";
		Query query = em.createQuery(sql, VEnchere.class);
		List<VEnchere> list = query.getResultList();
		

		if (list.size() != 0) {
			return list;
		} else {
			return null;
		}
	}

	//return actEnchere de Venchere
	@Override
	public List<ActEnchere> getAllActEnchere(VEnchere enchere) {
		// TODO Auto-generated method stub

		return null;
		
	}

	@Override
	public void supprimerVendeur(Long id) {
		// TODO Auto-generated method stub
		Vendeur obj = findById(id);
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
	}

}
