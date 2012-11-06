package com.tn.isamm.developpement.VenteAuxEnchere.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Historique
 * 
 */
@Entity
public class Historique implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idHist;

	private int montant;
	@Temporal(TemporalType.DATE)
	private Date date;

	@OneToOne(cascade = CascadeType.MERGE)
	private Membre membre;

	@OneToOne(cascade = CascadeType.MERGE)
	private Objet objet;

	private static final long serialVersionUID = 1L;

	public Historique() {
		super();
	}

	public long getIdHist() {
		return idHist;
	}

	public void setIdHist(long idHist) {
		this.idHist = idHist;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	public Objet getObjet() {
		return objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}

}