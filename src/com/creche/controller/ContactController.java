package com.creche.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.creche.model.Contact;
import com.creche.services.ContactService;

import java.lang.Integer;

@Named
@SessionScoped
public class ContactController implements Serializable{

	private static final long serialVersionUID = 1L;
	private List <Contact> listContact;
	private Integer contactID;
	private Contact contact;
	private Contact contactUpdate;
   
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
	
	public Integer getContactID() {
		return contactID;
	}

	public void setContactID(Integer contactID) {
		this.contactID = contactID;
	}
	
	public Contact getContactUpdate() {
		return contactUpdate;
	}

	public void setContactUpdate(Contact contactUpdate) {
		this.contactUpdate = contactUpdate;
	}
	
	
	

}


