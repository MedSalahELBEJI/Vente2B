package com.tn.isamm.developpement.VenteAuxEnchere.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Pays
 *
 */
@Entity
@Table(name = "Pays")
public class Pays implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPays;
	private String nom;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Membre> membres;
	private static final long serialVersionUID = 1L;

	public Pays() {
		super();
	}

	public long getIdPays() {
		return this.idPays;
	}

	public void setIdPays(long idPays) {
		this.idPays = idPays;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Membre> getMembres() {
		return membres;
	}

	public void setMembres(List<Membre> membres) {
		this.membres = membres;
	}

}
