package com.tn.isamm.developpement.VenteAuxEnchere.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Enchereur
 * 
 */
@Entity
public class Enchereur extends Personne {

	private static final long serialVersionUID = 1L;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<ActEnchere> actEncheres;

	public Enchereur() {
		super();
	}

	public List<ActEnchere> getActEncheres() {
		return actEncheres;
	}

	public void setActEncheres(List<ActEnchere> actEncheres) {
		this.actEncheres = actEncheres;
	}

}
