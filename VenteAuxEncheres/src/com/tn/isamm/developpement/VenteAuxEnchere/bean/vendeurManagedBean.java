package com.tn.isamm.developpement.VenteAuxEnchere.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javax.naming.NamingException;

import org.primefaces.model.UploadedFile;

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
	private List<VEnchere> allEnchereList = null;
	private List<VEnchere> vendeurEnchereList = null;
	private List<SelectItem> categList;
	private String destination = "E:\\Cours ISAMM 2012-2013\\Atelier J2EE\\VenteAuxEncheres\\VenteAuxEncheres\\WebContent\\images\\";
	private long idCateg;
	private byte[] img;
	private String url;
	private UploadedFile file;

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

		produitList = vendeurDao.getAllProduit(loginMBean.getVendeur()
				.getLogin());
		return this.produitList;
	}

	public void setProduitList(List<Produit> produitList) {
		this.produitList = produitList;
	}

	
	public void initBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Successful",
				"Produit Ajouté"));
		
		
		System.out.println("aloors pronto");
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<VEnchere> getVendeurEnchereList() {

		vendeurEnchereList = vendeurDao.getAllEncheres(loginMBean.getVendeur()
				.getLogin());
		return vendeurEnchereList;
	}

	public void setVendeurEnchereList(List<VEnchere> vendeurEnchereList) {
		this.vendeurEnchereList = vendeurEnchereList;
	}

	public List<VEnchere> getAllEnchereList() {

	if(allEnchereList == null)
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
	public void addProduit(ActionEvent actionEvent) throws IOException,
			NamingException {

		System.out.println("------------------essey-------------");
		System.out.println(file.getFileName());
		System.out.println(file.getContentType());
		img = file.getContents();
		try {
			copyFile(file.getFileName(), file.getInputstream());
			this.url = "/images/" + file.getFileName();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {

			Vendeur vendeur = loginMBean.getVendeur();
			produit.setVendeur(vendeur);
			produit.setCategorie(vendeurDao.findByID(getIdCateg()));
			produit.setImage(img);
			produit.setURL(url);
			vendeurDao.ajouterProduit(produit);
			getProduitList();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Successful",
					"Produit Ajouté"));
			produit = new Produit();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void copyFile(String fileName, InputStream in) {
		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(destination
					+ fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String lancerEnchere() {
		String redirect = null;
		System.out.println("aaaaallllllllllll" + this.produit.getIdProduit());
		// redirect = "VEnchere?faces-redirect=true";
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

	public String mesProduits() {

		String redirect = "vendeurProduit?faces-redirect=true";
		return redirect;

	}

	public String lancerProduit() {
		String redirect = "lancerEnchere?faces-redirect=true";
		return redirect;

	}
}
