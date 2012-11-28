package com.tn.isamm.developpement.VenteAuxEnchere.dao;

import java.util.List;

import com.tn.isamm.developpement.VenteAuxEnchere.model.Categorie;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Produit;
import com.tn.isamm.developpement.VenteAuxEnchere.model.VEnchere;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Vendeur;

public interface VendeurDao {

	public void ajouterVendeur(Vendeur vendeur);

	public void modifierVendeur(Vendeur vendeur);

	public void supprimerVendeur(Vendeur vendeur);

	public Vendeur findById(long id);

	public List<Vendeur> getAll();

	public void ajouterProduit(Produit produit);

	public List<Produit> getAllProduit(String username);

	// public void lancerEnchere
	public List<VEnchere> getAllProduit();

	public List<Categorie> listCategorie();

	public Categorie findByID(long id);
}
