package com.tn.isamm.developpement.VenteAuxEnchere.bean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.tn.isamm.developpement.VenteAuxEnchere.dao.EnchereurDao;
import com.tn.isamm.developpement.VenteAuxEnchere.dao.VEnchereDao;
import com.tn.isamm.developpement.VenteAuxEnchere.daoImp.EnchereurDaoImp;
import com.tn.isamm.developpement.VenteAuxEnchere.daoImp.VEnchereDaoImp;
import com.tn.isamm.developpement.VenteAuxEnchere.model.ActEnchere;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Enchereur;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Produit;

@ManagedBean(name = "AEnchereMB")
@SessionScoped
public class AEnchereManagedBean {

	private VEnchereDao venchereDao = new VEnchereDaoImp();

	private VEnchereDao enchereDao = new VEnchereDaoImp();
	private EnchereurDao AEnchereDao = new EnchereurDaoImp();
	private ActEnchere aEnchere = new ActEnchere();
	private List<ActEnchere> aEnchereList;
	@ManagedProperty(value = "#{loginBean}")
	private loginManagedBean loginMBean;
	private boolean isExist = new Boolean(false);

	@ManagedProperty(value = "#{VEnchereMB}")
	private VEnchereManagedBean VEnchereMB;

	// public boolean isExist() {
	//
	// if(AEnchereDao.isExist(aEnchere.getProduit().getIdProduit()) !=null)
	// {
	// isExist = true;
	// System.out.println(isExist);
	// }
	// System.out.println(isExist);
	//
	// return isExist;
	// }

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	public List<ActEnchere> getaEnchereList() {
		if (aEnchereList == null)

			aEnchereList = AEnchereDao.getActEnchere(loginMBean.getUsername());
		return this.aEnchereList;
	}

	public void setaEnchereList(List<ActEnchere> aEnchereList) {
		this.aEnchereList = aEnchereList;
	}

	public ActEnchere getaEnchere() {
		return aEnchere;
	}

	public void setaEnchere(ActEnchere aEnchere) {
		this.aEnchere = aEnchere;
	}

	public loginManagedBean getLoginMBean() {
		return loginMBean;
	}

	public void setLoginMBean(loginManagedBean loginMBean) {
		this.loginMBean = loginMBean;
	}

	public VEnchereManagedBean getVEnchereMB() {
		return VEnchereMB;
	}

	public void setVEnchereMB(VEnchereManagedBean vEnchereMB) {
		VEnchereMB = vEnchereMB;
	}

	public void addActEnchere(ActionEvent actionEvent) {

		if (VEnchereMB.getEnchere().getPrixInitial() < aEnchere
				.getPrixPropose()) {
			try {

				Enchereur enchereur = loginMBean.getEnchereur();
				List<Produit> prod = VEnchereMB.getEnchere().getProduit();
				aEnchere.setEnchereur(enchereur);
				aEnchere.setProduit(prod);

				VEnchereMB.getEnchere().setPrixInitial(
						aEnchere.getPrixPropose());
				venchereDao.lancerProduit(VEnchereMB.getEnchere());

				aEnchere.setDate(new Date());
				AEnchereDao.encherirProduit(aEnchere);
				
				FacesContext context = FacesContext.getCurrentInstance();  
		          
		        context.addMessage(null, new FacesMessage("Success", "L'enchère est bien enregistrée")); 
				

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		}

		else {
			FacesContext context = FacesContext.getCurrentInstance();  
	          
	        context.addMessage(null, new FacesMessage("Note", "Le prix proposé est inférieur au prix en cours")); 
		}

	}

}
