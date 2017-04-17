package com.creche.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.creche.model.Contact;
import com.creche.services.ContactService;
import com.creche.model.Role;

@Named
@SessionScoped
public class ContactController implements Serializable{

	private static final long serialVersionUID = 1L;
	private List <Contact> listContact;
	private Contact contact;
	private Contact contactUpdate;
	private Role typeRole;

	public ContactController(){

	}

	@PostConstruct
	public void init(){
		contact= new Contact();
	}

	public String fillContact(){
		ContactService cService = new ContactService();
		contact = cService.createContact(contact);
		clear();
		return "listingContact";
	} 

	public String updateContact(){
		ContactService cService = new ContactService();
		contact = cService.updateContact(contactUpdate);
		clear();
		return "listingContact";
	}

	public void clear(){
		setContact(null);
	}

	/*
	 public void removeContact() {
		ContactService cService = new ContactService();
		contact = cService.removeContact(contactID);
	 }*/

	public void loadContact(){
		ContactService cService = new ContactService();
		listContact = cService.findAllContact();
	}

	public void loadActiveContact(){
		ContactService cService = new ContactService();
		listContact = cService.findActiveContact();
	}
	
	public void loadContact(boolean actif){
		ContactService cService = new ContactService();
		listContact = cService.findAllContact(actif);
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


	public Contact getContactUpdate() {
		return contactUpdate;
	}

	public void setContactUpdate(Contact contactUpdate) {
		this.contactUpdate = contactUpdate;
	}

	public Role getTypeRole() {
		return typeRole;
	}

	public void setTypeRole(Role typeRole) {
		this.typeRole = typeRole;
	}

	
	
	

}


