package com.tn.isamm.developpement.VenteAuxEnchere.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Categorie
 *
 */
@Entity

public class Categorie implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCategorie;
	private String nomCat;
	private String description;
	private static final long serialVersionUID = 1L;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Produit> produit;

	public Categorie() {
		super();
	}

	public long getIdCategorie() {
		return this.idCategorie;
	}

	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}   
	public String getNomCat() {
		return this.nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Produit> getProduit() {
		return produit;
	}

	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
   
}
