package com.tn.isamm.developpement.VenteAuxEnchere.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.tn.isamm.developpement.VenteAuxEnchere.dao.EnchereurDao;
import com.tn.isamm.developpement.VenteAuxEnchere.dao.VendeurDao;
import com.tn.isamm.developpement.VenteAuxEnchere.dao.adminstrateurDao;
import com.tn.isamm.developpement.VenteAuxEnchere.daoImp.EnchereurDaoImp;
import com.tn.isamm.developpement.VenteAuxEnchere.daoImp.VendeurDaoImp;
import com.tn.isamm.developpement.VenteAuxEnchere.daoImp.adminstrateurDaoImp;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Administrateur;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Enchereur;
import com.tn.isamm.developpement.VenteAuxEnchere.model.Vendeur;

@ManagedBean(name = "loginBean")
@SessionScoped
public class loginManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Enchereur> enchereurList;
	private List<Vendeur> vendeurList;
	private List<Administrateur> adminList;
	
	private boolean flag = false;
	private EnchereurDao enchereurDao = new EnchereurDaoImp();
	private VendeurDao vendeurDao = new VendeurDaoImp();
	private adminstrateurDao adminDao = new adminstrateurDaoImp();
	
	private String username;
	private String password;
	private Vendeur vendeur = new Vendeur();
	private Enchereur enchereur = new Enchereur();
	private Administrateur admin = new Administrateur();
	// rendred
	private boolean checkV = false;
	private boolean checkE = false;
	private boolean checkA = false;

	
	
	public Administrateur getAdmin() {
		return admin;
	}

	public void setAdmin(Administrateur admin) {
		this.admin = admin;
	}

	public boolean isCheckA() {
		return checkA;
	}

	public void setCheckA(boolean checkA) {
		this.checkA = checkA;
	}

	public List<Administrateur> getAdminList() {
		return adminList;
	}

	public void setAdminList(List<Administrateur> adminList) {
		this.adminList = adminList;
	}

	public adminstrateurDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(adminstrateurDao adminDao) {
		this.adminDao = adminDao;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public List<Enchereur> getEnchereurList() {
		return enchereurList;
	}

	public void setEnchereurList(List<Enchereur> enchereurList) {
		this.enchereurList = enchereurList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Vendeur> getVendeurList() {
		return vendeurList;
	}

	public void setVendeurList(List<Vendeur> vendeurList) {
		this.vendeurList = vendeurList;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	public Vendeur getVendeur() {
		return vendeur;
	}

	public Enchereur getEnchereur() {
		return enchereur;
	}

	public void setEnchereur(Enchereur enchereur) {
		this.enchereur = enchereur;
	}

	public boolean isCheckV() {
		return checkV;
	}

	public void setCheckV(boolean checkV) {
		this.checkV = checkV;
	}

	public boolean isCheckE() {
		return checkE;
	}

	public void setCheckE(boolean checkE) {
		this.checkE = checkE;
	}

	@PostConstruct
	public void initBean() {

		try {
			enchereurList = enchereurDao.getAll();
			vendeurList = vendeurDao.getAll();
			adminList = adminDao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String login() {

		String redirect = null;
		FacesContext context = FacesContext.getCurrentInstance();
		boolean trouve = false;

		if (username != null && !(username.equals("")) && password != null
				&& !(password.equals(""))) {

			for (int i = 0; i < enchereurList.size(); i++) {

				if (enchereurList.get(i).getLogin().equals(username)
						&& enchereurList.get(i).getPassword().equals(password)) {
					trouve = true;
					checkV = false;
					checkE = true;
					enchereur = enchereurList.get(i);
					redirect = "enchereurPage?faces-redirect=true";

				}
			}
			
			for (int i = 0; i < adminList.size(); i++) {

				if (adminList.get(i).getLogin().equals(username)
						&& adminList.get(i).getPassword().equals(password)) {
					trouve = true;
					checkV = false;
					checkE = false;
					checkA = true;
					admin = adminList.get(i);
					redirect = "gestionEnchereur?faces-redirect=true";

				}
			}
			
			
			
			for (int i = 0; i < vendeurList.size(); i++) {

				if (vendeurList.get(i).getLogin().equals(username)
						&& vendeurList.get(i).getPassword().equals(password)) {
					checkV = true;
					checkE = false;
					trouve = true;
					vendeur = vendeurList.get(i);
					System.out.println(vendeur.getLogin());
					redirect = "vendeurPage?faces-redirect=true";

				}
			}
			if (trouve == false) {

				context.addMessage("dialog:username", new FacesMessage(
						FacesMessage.SEVERITY_WARN, "Login Error",
						"Invalid credentials"));
			}
		}
		flag = true;
		return redirect;

	}

	public String logout() {

		((HttpSession) FacesContext.getCurrentInstance().getExternalContext()

		.getSession(true)).invalidate();

		String redirect = "index?faces-redirect=true";

		flag = false;

		return redirect;

	}
}
