package com.tn.isamm.developpement.VenteAuxEnchere.dao;

import java.util.List;

import com.tn.isamm.developpement.VenteAuxEnchere.model.Vendeur;

public interface VendeurDao {
	
	public void ajouterVendeur(Vendeur vendeur);

	public void modifierVendeur(Vendeur vendeur);

	public void supprimerVendeur(Vendeur vendeur);

	public Vendeur findById(long id);

	public List<Vendeur> getAll();

}
