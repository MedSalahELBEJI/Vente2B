package com.tn.isamm.developpement.VenteAuxEnchere.dao;

import com.tn.isamm.developpement.VenteAuxEnchere.model.Objet;

public interface ObjetDao {
	
	public void ajouterObjet(Objet objet);

	public void modifierObjet(Objet objet);

	public void supprimerObjet(Objet objet);

	public Objet findById(long id);
}
