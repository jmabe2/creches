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
	

	private int contactID;
	private boolean actif;
	private int codePostal;
	private int gsm;
	private String localite;
	private int niss;
	private String nom;
	private int numero;
	private String prenom;
	private String rue;
	private int telephone;
	private Contact contact;
	
	public ContactController(){
		
	}
	
	@PostConstruct
	public void init(){

	}
	
	public String fillContact(){
		ContactService cService = new ContactService();
		contact = cService.createContact(nom, prenom, niss, rue, numero, codePostal, localite, telephone, gsm, actif);
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

	public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public int getGsm() {
		return gsm;
	}

	public void setGsm(int gsm) {
		this.gsm = gsm;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public int getNiss() {
		return niss;
	}

	public void setNiss(int niss) {
		this.niss = niss;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
