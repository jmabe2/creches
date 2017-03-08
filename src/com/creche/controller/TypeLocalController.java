package com.creche.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.creche.model.Typelocal;
import com.creche.services.LocalService;
import com.creche.services.TypeLocalService;


@Named
@SessionScoped
public class TypeLocalController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List <Typelocal> listTypeLocal;
	
	private Typelocal typeLocal;
	
	public TypeLocalController(){
		
	}
	
	@PostConstruct
	public void init(){
		typeLocal = new Typelocal();
	}
	
	public String fillTypeLocal(){
		TypeLocalService tlService = new TypeLocalService();
		tlService.createLocal(typeLocal);
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
	
	public void loadTypeLocal(){
		TypeLocalService tlService = new TypeLocalService();
		listTypeLocal = tlService.findAllTypeLocal();
	}
	
	// Getters ans setters
	public List<Typelocal> getListTypeLocal() {
		return listTypeLocal;
	}

	public void setListTypeLocal(List<Typelocal> listTypeLocal) {
		this.listTypeLocal = listTypeLocal;
	}

	public Typelocal getTypeLocal() {
		return typeLocal;
	}

	public void setTypeLocal(Typelocal typeLocal) {
		this.typeLocal = typeLocal;
	}


}
