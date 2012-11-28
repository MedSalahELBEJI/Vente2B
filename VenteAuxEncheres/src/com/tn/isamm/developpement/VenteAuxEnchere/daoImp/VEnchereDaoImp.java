package com.tn.isamm.developpement.VenteAuxEnchere.daoImp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tn.isamm.developpement.VenteAuxEnchere.dao.VEnchereDao;
import com.tn.isamm.developpement.VenteAuxEnchere.model.ActEnchere;
import com.tn.isamm.developpement.VenteAuxEnchere.model.VEnchere;

public class VEnchereDaoImp implements VEnchereDao {

	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("myPersistenceUnit");

	private static EntityManager em = emf.createEntityManager();

	public void lancerProduit(VEnchere venchere) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(venchere);
		em.getTransaction().commit();
	}






}
