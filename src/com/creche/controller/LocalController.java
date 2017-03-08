package com.creche.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.creche.model.Local;
import com.creche.services.LocalService;


@Named
@SessionScoped
public class LocalController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List <Local> listLocal;
	
	private Local local;
	
	public LocalController(){
		
	}
	
	@PostConstruct
	public void init(){
		local = new Local();
	}
	
	public String fillLocal(){
		System.out.println(local.getSection());
		System.out.println(local.getTypelocal());
		LocalService lService = new LocalService();
		lService.createLocal(local);
		return "listingContact";
	} 
	
	/*public String updateContact(){
		ContactService cService = new ContactService();
		contact = cService.updateContact(contactID, nom, prenom, niss, rue, numero, codePostal, localite, telephone, gsm, actif);
		return "ContactForm";
	}*/
	
	/*public void removeContact() {
		ContactService cService = new ContactService();
		contact = cService.removeContact(contactID);
	}*/
	
	public void loadLocal(){
		LocalService lService = new LocalService();
		listLocal = lService.findAllLocal();
	}


	
	//Getter & Setters
	public List<Local> getListLocal() {
		return listLocal;
	}

	public void setListLocal(List<Local> listLocal) {
		this.listLocal = listLocal;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}


}
