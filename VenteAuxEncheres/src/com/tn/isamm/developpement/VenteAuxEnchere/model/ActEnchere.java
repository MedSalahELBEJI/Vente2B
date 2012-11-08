package com.tn.isamm.developpement.VenteAuxEnchere.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ActEnchere
 *
 */
@Entity

public class ActEnchere implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idActEnchere;
	private float prixPropose;
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToOne(cascade = CascadeType.MERGE)
	private Enchereur enchereur;
	@OneToOne(cascade = CascadeType.MERGE)
	private Produit produit;
	private static final long serialVersionUID = 1L;

	public ActEnchere() {
		super();
	}   
	public long getIdActEnchere() {
		return this.idActEnchere;
	}

	public void setIdActEnchere(long idActEnchere) {
		this.idActEnchere = idActEnchere;
	}   
	public float getPrixPropose() {
		return this.prixPropose;
	}

	public void setPrixPropose(float prixPropose) {
		this.prixPropose = prixPropose;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Enchereur getEnchereur() {
		return enchereur;
	}
	public void setEnchereur(Enchereur enchereur) {
		this.enchereur = enchereur;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	
   
}
