package com.tn.isamm.developpement.VenteAuxEnchere.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Categorie
 *
 */
@Entity
@Table(name = "Categorie")
public class Categorie implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCat;
	private String nomCat;
	private String description;
	@OneToOne(cascade = CascadeType.MERGE)
	private Objet objet;
	private static final long serialVersionUID = 1L;

	public Categorie() {
		super();
	}   
	public long getIdCat() {
		return this.idCat;
	}

	public void setIdCat(long idCat) {
		this.idCat = idCat;
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
	public Objet getObjet() {
		return objet;
	}
	public void setObjet(Objet objet) {
		this.objet = objet;
	}
   
}
