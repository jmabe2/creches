package com.creche.controller;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


import com.creche.model.Contact;
import com.creche.services.ContactService;

@Named
@ViewScoped
public class ContactController {
	
	private List <Contact> listContact;
	
	public String loadContact (){
		System.out.println("test");
		ContactService cService = new ContactService(null);
		listContact = cService.findAllContact();
		return "";
	}

}
