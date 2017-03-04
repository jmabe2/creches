package com.creche.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.creche.model.Contact;
import com.creche.services.ContactService;


@Named
@SessionScoped
public class ContactController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List <Contact> listContact;

	private Contact contact;
	
	public ContactController(){
		
	}
	
	@PostConstruct
	public void init(){
		contact= new Contact();
	}
	
	public String fillContact(){
		ContactService cService = new ContactService();
		contact = cService.createContact(contact);
		return "listingContact";
	} 
	
	public String updateContact(){
		ContactService cService = new ContactService();
		contact = cService.updateContact(contactID, nom, prenom, niss, rue, numero, codePostal, localite, telephone, gsm, actif);
		return "ContactForm";
	}
	
	/*public void removeContact() {
		ContactService cService = new ContactService();
		contact = cService.removeContact(contactID);
	}*/
	
	public void loadContact(){
		ContactService cService = new ContactService();
		listContact = cService.findAllContact();
	}

	public List<Contact> getListContact() {
		return listContact;
	}

	public void setListContact(List<Contact> listContact) {
		this.listContact = listContact;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}


}