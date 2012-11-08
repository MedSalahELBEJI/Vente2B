package com.tn.isamm.developpement.VenteAuxEnchere.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.tn.isamm.developpement.VenteAuxEnchere.dao.EnchereurDao;
import com.tn.isamm.developpement.VenteAuxEnchere.dao.VendeurDao;
import com.tn.isamm.developpement.VenteAuxEnchere.daoImp.EnchereurDaoImp;
import com.tn.isamm.developpement.VenteAuxEnchere.daoImp.VendeurDaoImp;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Enchereur;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Vendeur;

@ManagedBean(name = "inscriptionMB")
@SessionScoped
public class InscriptionManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vendeur vendeur = new Vendeur();
	private Enchereur enchereur = new Enchereur();
	private EnchereurDao enchereurDao = new EnchereurDaoImp();
	private VendeurDao vendeurDao = new VendeurDaoImp();
	private List<Vendeur> vendeurList;
	private List<Enchereur> enchereurList;

	@PostConstruct
	public void initBean() {

		try {
			vendeurList = vendeurDao.getAll();
			enchereurList = enchereurDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Add Vendeur
	public void addVendeur() {
		try {

			vendeurDao.ajouterVendeur(vendeur);
			vendeurList = vendeurDao.getAll();
			vendeur = new Vendeur();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}

	public void addEnchereur() {
		try {

			enchereurDao.ajouterEnchereur(enchereur);
			enchereurList = enchereurDao.getAll();
			enchereur = new Enchereur();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}

	public Vendeur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	public List<Vendeur> getVendeurList() {

		if (vendeurList == null)
			vendeurList = vendeurDao.getAll();
		return vendeurList;
	}

	public void setVendeurList(List<Vendeur> vendeurList) {
		this.vendeurList = vendeurList;
	}

	public Enchereur getEnchereur() {
		return enchereur;
	}

	public void setEnchereur(Enchereur enchereur) {
		this.enchereur = enchereur;
	}

	public List<Enchereur> getEnchereurList() {
		if (enchereurList == null)
			enchereurList = enchereurDao.getAll();
		return enchereurList;
	}

	public void setEnchereurList(List<Enchereur> enchereurList) {
		this.enchereurList = enchereurList;
	}

}
