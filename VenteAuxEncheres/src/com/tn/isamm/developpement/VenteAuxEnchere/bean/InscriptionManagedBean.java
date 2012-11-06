package com.tn.isamm.developpement.VenteAuxEnchere.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.tn.isamm.developpement.VenteAuxEnchere.dao.MembreDao;
import com.tn.isamm.developpement.VenteAuxEnchere.daoImp.MembreDaoImp;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Membre;

@ManagedBean(name = "inscriptionMB")
@SessionScoped
public class InscriptionManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Membre mbr = new Membre();
	private MembreDao membreDao = new MembreDaoImp();

	// Add Membre
	public void addMembre() {
		try {

			membreDao.ajouterMembre(mbr);

			mbr = new Membre();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}

	}

	public Membre getMbr() {
		return mbr;
	}

	public void setMbr(Membre mbr) {
		this.mbr = mbr;
	}

}
