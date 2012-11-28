package com.tn.isamm.developpement.VenteAuxEnchere.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.tn.isamm.developpement.VenteAuxEnchere.dao.VendeurDao;
import com.tn.isamm.developpement.VenteAuxEnchere.daoImp.VendeurDaoImp;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Categorie;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Produit;
import com.tn.isamm.developpement.VenteAuxEnchere.model.VEnchere;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Vendeur;

@ManagedBean(name = "vendeurMB")
@SessionScoped
public class vendeurManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VendeurDao vendeurDao = new VendeurDaoImp();
	private Produit produit = new Produit();
	private List<Vendeur> vendeurList;
	private List<Produit> produitList;
	private List<VEnchere> allEnchereList;
	private List<SelectItem> categList;
	private long idCateg;
	@ManagedProperty(value = "#{loginBean}")
	private loginManagedBean loginMBean;

	public VendeurDao getVendeurDao() {
		return vendeurDao;
	}

	public void setVendeurDao(VendeurDao vendeurDao) {
		this.vendeurDao = vendeurDao;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<Vendeur> getVendeurList() {
		return vendeurList;
	}

	public void setVendeurList(List<Vendeur> vendeurList) {
		this.vendeurList = vendeurList;
	}

	public List<Produit> getProduitList() {
		if (produitList == null)
			produitList = vendeurDao.getAllProduit(loginMBean.getVendeur()
					.getLogin());
		return this.produitList;
	}

	public void setProduitList(List<Produit> produitList) {
		this.produitList = produitList;
	}

	@PostConstruct
	public void initBean() {

		try {
			produitList = vendeurDao.getAllProduit("medsalah");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<VEnchere> getAllEnchereList() {
		if (allEnchereList == null)

			allEnchereList = vendeurDao.getAllProduit();
		return this.allEnchereList;
	}

	public void setAllEnchereList(List<VEnchere> allEnchereList) {
		this.allEnchereList = allEnchereList;
	}

	public long getIdCateg() {
		return idCateg;
	}

	public void setIdCateg(long idCateg) {
		this.idCateg = idCateg;
	}

	public List<SelectItem> getCategList() {
		List<SelectItem> SI = new ArrayList<SelectItem>();
		List<Categorie> listCategorie = vendeurDao.listCategorie();
		for (int i = 0; i < listCategorie.size(); i++) {
			SI.add(new SelectItem(listCategorie.get(i).getIdCategorie(),
					listCategorie.get(i).getNomCat()));
		}
		return SI;
	}

	public void setCategList(List<SelectItem> categList) {
		this.categList = categList;
	}

	// Add Produit
	public void addProduit(ActionEvent actionEvent) {

		try {

			Vendeur vendeur = loginMBean.getVendeur();
			produit.setVendeur(vendeur);
			produit.setCategorie(vendeurDao.findByID(getIdCateg()));
			vendeurDao.ajouterProduit(produit);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Successful",
					"Produit Ajouté"));
			produit = new Produit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public String lancerEnchere() {
		String redirect = null;
		System.out.println("aaaaaaaaaaaaaaa" + this.produit.getIdProduit());
		redirect = "VEnchere?faces-redirect=true";
		return redirect;
	}

	public loginManagedBean getLoginMBean() {
		return loginMBean;
	}

	public void setLoginMBean(loginManagedBean loginMBean) {
		this.loginMBean = loginMBean;
	}

	public boolean isAllowed() {
		return true;
	}
}
