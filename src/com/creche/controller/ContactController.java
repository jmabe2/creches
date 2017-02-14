package com.creche.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

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
	
	public ContactController(){
		
	}
	
	@PostConstruct
	public void init(){

	}
	
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


}
