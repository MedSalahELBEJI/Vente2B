package com.tn.isamm.developpement.VenteAuxEnchere.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DualListModel;

import com.tn.isamm.developpement.VenteAuxEnchere.dao.VEnchereDao;
import com.tn.isamm.developpement.VenteAuxEnchere.daoImp.VEnchereDaoImp;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Produit;
import com.tn.isamm.developpement.VenteAuxEnchere.model.VEnchere;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Vendeur;

@ManagedBean(name = "VEnchereMB")
@SessionScoped
public class VEnchereManagedBean {

	private VEnchereDao venchereDao = new VEnchereDaoImp();
	private VEnchere enchere = new VEnchere();
	
	
	@ManagedProperty(value = "#{loginBean}")
	private loginManagedBean loginMBean;

	@ManagedProperty(value = "#{vendeurMB}")
	private vendeurManagedBean vendeurMBean;

	private Produit[] selectedProduits;
	
	public Produit[] getSelectedProduits() {
		return selectedProduits;
	}

	public void setSelectedProduits(Produit[] selectedProduits) {
		this.selectedProduits = selectedProduits;
	}

	public VEnchere getEnchere() {
		return enchere;
	}

	public void setEnchere(VEnchere enchere) {
		this.enchere = enchere;
	}

	public VEnchereDao getVenchereDao() {
		return venchereDao;
	}

	public void setVenchereDao(VEnchereDao venchereDao) {
		this.venchereDao = venchereDao;
	}

	public loginManagedBean getLoginMBean() {
		return loginMBean;
	}

	public void setLoginMBean(loginManagedBean loginMBean) {
		this.loginMBean = loginMBean;
	}

	public vendeurManagedBean getVendeurMBean() {
		return vendeurMBean;
	}

	public void setVendeurMBean(vendeurManagedBean vendeurMBean) {
		this.vendeurMBean = vendeurMBean;
	}

	public String info() {
		String redirect = null;
		System.out.println("aaaaaaaaaaaaaaa" + this.enchere.getPrixInitial());

		redirect = "encherir?faces-redirect=true";
		return redirect;
	}
	public void lancerProduit(ActionEvent actionEvent) {

		try {
			 
			
			Vendeur vendeur = loginMBean.getVendeur();
			System.out.println("bbbbbbbbb=="+selectedProduits[1].getNomProduit());
			List<Produit> prod = new ArrayList(Arrays.asList(selectedProduits));
			System.out.println("ccccccc=="+prod.get(1).getNomProduit());
			
			enchere.setProduit(prod);
			enchere.setVendeur(vendeur);
			enchere.setEtat("En cours");
			// Recuperer la date systeme
			enchere.setDateDebut(new Date());

			venchereDao.lancerProduit(enchere);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
