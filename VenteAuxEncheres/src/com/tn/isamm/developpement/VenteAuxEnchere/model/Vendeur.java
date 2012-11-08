package com.tn.isamm.developpement.VenteAuxEnchere.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vendeur
 *
 */
@Entity

public class Vendeur extends Personne implements Serializable {

	
	private long tvaCode;
	private int note;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<VEnchere> vEnchere;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Produit> produit;
	private static final long serialVersionUID = 1L;

	public Vendeur() {
		super();
	}   
	public long getTvaCode() {
		return this.tvaCode;
	}

	public void setTvaCode(long tvaCode) {
		this.tvaCode = tvaCode;
	}   
	public int getNote() {
		return this.note;
	}

	public void setNote(int note) {
		this.note = note;
	}
	public List<VEnchere> getvEnchere() {
		return vEnchere;
	}
	public void setvEnchere(List<VEnchere> vEnchere) {
		this.vEnchere = vEnchere;
	}
	public List<Produit> getProduit() {
		return produit;
	}
	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
   
}
