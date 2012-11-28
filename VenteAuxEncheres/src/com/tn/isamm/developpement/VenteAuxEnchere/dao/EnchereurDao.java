package com.tn.isamm.developpement.VenteAuxEnchere.dao;

import java.util.List;

import com.tn.isamm.developpement.VenteAuxEnchere.model.ActEnchere;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Enchereur;

public interface EnchereurDao {

	public void ajouterEnchereur(Enchereur enchereur);

	public void modifierEnchereur(Enchereur enchereur);

	public void supprimerEnchereur(Enchereur enchereur);

	public Enchereur findById(long id);

	public List<Enchereur> getAll();

	public List<ActEnchere> getActEnchere(String username);

	public void encherirProduit(ActEnchere actEnchere);

}
