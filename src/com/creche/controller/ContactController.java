package com.creche.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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
	private String test;
	
	public ContactController(){
		
	}
	
	@PostConstruct
	public void init(){
		System.out.println("test");
		//test ="Jordan";
		test = "";
	}
	
	public String loadContact(){
		System.out.println("test");
		ContactService cService = new ContactService(null);
		listContact = cService.findAllContact();
		return "";
	}

	public List<Contact> getListContact() {
		return listContact;
	}

	public void setListContact(List<Contact> listContact) {
		this.listContact = listContact;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}
