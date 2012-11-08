package com.tn.isamm.developpement.VenteAuxEnchere.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.tn.isamm.developpement.VenteAuxEnchere.dao.VendeurDao;
import com.tn.isamm.developpement.VenteAuxEnchere.daoImp.VendeurDaoImp;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Vendeur;

@ManagedBean(name = "inscriptionMB")
@SessionScoped
public class InscriptionManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vendeur vendeur = new Vendeur();
	private VendeurDao vendeurDao = new VendeurDaoImp();
	private List<Vendeur> vendeurList;

	@PostConstruct
	public void initBean() {

		try {
			vendeurList = vendeurDao.getAll();

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

}
