package com.tn.isamm.developpement.VenteAuxEnchere.dao;

import com.tn.isamm.developpement.VenteAuxEnchere.model.Membre;


public interface MembreDao {
	public void ajouterMembre(Membre membre);

	public void modifierMembre(Membre membre);

	public void supprimerMembre(Membre membre);

	public Membre findById(long id);
}
