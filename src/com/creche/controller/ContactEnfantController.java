package com.creche.controller;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.creche.model.Contact;
import com.creche.model.Contactenfant;
import com.creche.model.Enfant;
import com.creche.services.ContactEnfantService;

@Named
@SessionScoped
public class ContactEnfantController implements Serializable{

	private static final long serialVersionUID = 1L;
	private List <Contactenfant> listContactenfant;

	private Contactenfant contactEnfant;
	private Contact contact;
	private Enfant enfant;
	private ContactEnfantService contactEnfServ;
	private Contactenfant updateContactEnfant;

	public ContactEnfantController (){

	}
	
	@PostConstruct
	public void init(){
		//enfant = new Enfant();
		contactEnfant = new Contactenfant();
	}


	public String fillContactEnfant(){
		contactEnfServ = new ContactEnfantService();
		contactEnfServ.createContactEnfant(contactEnfant);
		enfant.getContactenfants().add(contactEnfant);
		contactEnfant = new Contactenfant();
		contactEnfant.getContact();
		contactEnfant.getEnfant();
		return "listingContactEnfant";
	} 

	public String updateContactenfant(){
		contactEnfServ = new ContactEnfantService();
		contactEnfant=contactEnfServ.updateContactEnfant(updateContactEnfant);
		return "listingAllContactEnfant";
	}


	public void loadContactEnfant(){
		contactEnfServ = new ContactEnfantService();
		//contactEnfServ.findAllContactEnfant();
		listContactenfant=contactEnfServ.findContactEnfantByEnfant(enfant);
		contactEnfant = new Contactenfant();
	}

	public void loadAllContactEnfant(){
		contactEnfServ = new ContactEnfantService();
		listContactenfant=contactEnfServ.findAllContactEnfant();
		contactEnfant = new Contactenfant();
	}




	public Contactenfant getContactEnfant() {
		return contactEnfant;
	}
	public void setContactEnfant(Contactenfant contactEnfant) {
		this.contactEnfant = contactEnfant;
	}
	
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public ContactEnfantService getContactEnfServ() {
		return contactEnfServ;
	}

	public void setContactEnfServ(ContactEnfantService contactEnfServ) {
		this.contactEnfServ = contactEnfServ;
	}

	public List <Contactenfant> getListContactenfant() {
		return listContactenfant;
	}

	public void setListContactenfant(List <Contactenfant> listContactenfant) {
		this.listContactenfant = listContactenfant;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public Contactenfant getUpdateContactEnfant() {
		return updateContactEnfant;
	}

	public void setUpdateContactEnfant(Contactenfant updateContactEnfant) {
		this.updateContactEnfant = updateContactEnfant;
	}

}
