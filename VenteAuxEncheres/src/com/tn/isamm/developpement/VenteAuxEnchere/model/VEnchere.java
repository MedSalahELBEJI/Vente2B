package com.tn.isamm.developpement.VenteAuxEnchere.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: VEnchere
 *
 */
@Entity

public class VEnchere implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long idEnchere;
	private float prixInitial;
	private String etat;
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	private String prixAchatImmediat;
	@OneToOne(cascade = CascadeType.MERGE)
	private Vendeur vendeur;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Produit> produit;
	private static final long serialVersionUID = 1L;

	public VEnchere() {
		super();
	}   
	public long getIdEnchere() {
		return this.idEnchere;
	}

	public void setIdEnchere(long idEnchere) {
		this.idEnchere = idEnchere;
	}   
	public float getPrixInitial() {
		return this.prixInitial;
	}

	public void setPrixInitial(float prixInitial) {
		this.prixInitial = prixInitial;
	}   
	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getPrixAchatImmediat() {
		return prixAchatImmediat;
	}
	public void setPrixAchatImmediat(String prixAchatImmediat) {
		this.prixAchatImmediat = prixAchatImmediat;
	}
	public Vendeur getVendeur() {
		return vendeur;
	}
	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}
	public List<Produit> getProduit() {
		return produit;
	}
	public void setProduit(List<Produit> produit) {
		this.produit = produit;
	}
	
	
	
   
}
