package com.tn.isamm.developpement.VenteAuxEnchere.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Membre
 * 
 */
@Entity
@Table(name = "Membre")
public class Membre implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idMbr;
	private boolean isVendeur;
	private boolean isAcheteur;
	private boolean isAdmin;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String zipCode;
	private String ville;
	private String pays;
	private String telephone;
	private String login;
	private String password;
	private String email;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Objet> objets;
	@OneToMany(cascade = CascadeType.MERGE)
	private List<Note> notes;
	@OneToOne(cascade = CascadeType.MERGE)
	 private Historique historique;
	private static final long serialVersionUID = 1L;

	public Membre() {
		super();
	}

	public long getIdMbr() {
		return this.idMbr;
	}

	public void setIdMbr(long idMbr) {
		this.idMbr = idMbr;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		if (dateNaissance != null) {
	        this.dateNaissance = new Date(dateNaissance.getTime());
	    } else {
	        this.dateNaissance = null;
	    }
		
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Objet> getObjets() {
		return objets;
	}

	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}

	public void setVendeur(boolean isVendeur) {
		this.isVendeur = isVendeur;
	}

	public void setAcheteur(boolean isAcheteur) {
		this.isAcheteur = isAcheteur;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public boolean isVendeur() {
		return isVendeur;
	}

	public boolean isAcheteur() {
		return isAcheteur;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public Historique getHistorique() {
		return historique;
	}

	public void setHistorique(Historique historique) {
		this.historique = historique;
	}

}
