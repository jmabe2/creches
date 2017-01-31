package com.creche.controller;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.creche.model.Contact;
import com.creche.services.ContactService;

@ManagedBean(value = "contactController")
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
