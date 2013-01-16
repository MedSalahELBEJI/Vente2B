package com.tn.isamm.developpement.VenteAuxEnchere.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.tn.isamm.developpement.VenteAuxEnchere.dao.VEnchereDao;
import com.tn.isamm.developpement.VenteAuxEnchere.dao.VendeurDao;
import com.tn.isamm.developpement.VenteAuxEnchere.daoImp.VEnchereDaoImp;
import com.tn.isamm.developpement.VenteAuxEnchere.daoImp.VendeurDaoImp;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Produit;
import com.tn.isamm.developpement.VenteAuxEnchere.model.VEnchere;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Vendeur;

@ManagedBean(name = "VEnchereMB")
@SessionScoped
public class VEnchereManagedBean {

	private VEnchereDao venchereDao = new VEnchereDaoImp();
	private VEnchere enchere = new VEnchere();
	
	private VendeurDao vendeurDao = new VendeurDaoImp();
	
	
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

	public String flag(){
		System.out.println("flaaaaaaaaaaaag");
		
		String redirect = null;
		if(loginMBean.isFlag() == true)
		{
			
			System.out.println("aaaaaaaaaayyyyyyy" + this.enchere.getPrixInitial());
			
			redirect = "enchereurDetailEnchere?faces-redirect=true";
			System.out.println("aaaaaaxxxxxxx");
			return redirect;
		}
		else {
			
			System.out.println("redirect");
			 
			FacesContext context = FacesContext.getCurrentInstance();  
	          
	        context.addMessage(null, new FacesMessage("Authentification", "vous n'etes pas connecté, subscribe??"));  
			
			//redirect = "inscriptionEnchereur?faces-redirect=true";
			
		}
		return redirect;
	}
	
	
	
	public String viewDetail()
	{
		
	//	System.out.println("eeeeeeeeeeeeee= "+enchere.getProduit().get(0));
		String redirect = "vendeurDetailsEncheres?faces-redirect=true";
		//System.out.println("aaaaaaxxxxxxx");
		
		 
//		 List<ActEnchere> aa = vendeurDao.getAllActEnchere(enchere);
//		 System.out.println("pppppppppppp"+aa.get(0).getPrixPropose());;
		return redirect;
		
		
	}
	
	
	
	
	public void checkStatusEnchere()
	{
		System.out.println("checking");
		
		List<VEnchere> listEnche = vendeurDao.getAllEncheres(loginMBean.getUsername());
		
		Iterator itr = listEnche.iterator(); 
		while(itr.hasNext()) {

		    VEnchere element = (VEnchere) itr.next(); 
		   
		    if(element.getDateFin().compareTo(new Date()) < 0)
		    {
		    	element.setEtat("terminée");
		    	System.out.println("etat modifie");
		    	venchereDao.lancerProduit(element);
		    	
		    	
		    	
		    	
		    	
		    	
		    	 FacesContext context = FacesContext.getCurrentInstance();  
		          
		         context.addMessage(null, new FacesMessage("Terminé", "Enchère "+element.getIdEnchere()+" est terminée avec maximum prix : "+element.getPrixInitial()));  
		       
		    		    		    	
		    }
		    
		    
		    	

		} 
		
	}
	
	
	public void lancerProduit(ActionEvent actionEvent) {

		try {
			 
			
			
			
			
			Vendeur vendeur = loginMBean.getVendeur();
		//	System.out.println("bbbbbbbbb=="+selectedProduits[1].getNomProduit());
			


				List<Produit> prod = new ArrayList(Arrays.asList(selectedProduits));
				System.out.println("ccccccc=="+prod.size());
				
				enchere.setProduit(prod);
				

			
			enchere.setVendeur(vendeur);
			enchere.setEtat("En cours");
			// Recuperer la date systeme
			enchere.setDateDebut(new Date());

			venchereDao.lancerProduit(enchere);
			
			vendeurMBean.getAllEnchereList();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
