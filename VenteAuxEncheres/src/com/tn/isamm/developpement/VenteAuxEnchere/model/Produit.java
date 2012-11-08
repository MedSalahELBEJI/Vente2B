package com.tn.isamm.developpement.VenteAuxEnchere.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Produit
 *
 */
@Entity

public class Produit implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProduit;
	private String description;
	private long qteStock;
	private String nomProduit;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<ActEnchere> actEncheres;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<VEnchere> vEncheres;
	@OneToOne(cascade = CascadeType.MERGE)
	private Categorie categorie;
	@OneToOne(cascade = CascadeType.MERGE)
	private Vendeur vendeur;
	private static final long serialVersionUID = 1L;

	public Produit() {
		super();
	}   
	public long getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public long getQteStock() {
		return this.qteStock;
	}

	public void setQteStock(long qteStock) {
		this.qteStock = qteStock;
	}   
	public String getNomProduit() {
		return this.nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public List<ActEnchere> getActEncheres() {
		return actEncheres;
	}
	public void setActEncheres(List<ActEnchere> actEncheres) {
		this.actEncheres = actEncheres;
	}
	public List<VEnchere> getvEncheres() {
		return vEncheres;
	}
	public void setvEncheres(List<VEnchere> vEncheres) {
		this.vEncheres = vEncheres;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Vendeur getVendeur() {
		return vendeur;
	}
	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}
   
}
