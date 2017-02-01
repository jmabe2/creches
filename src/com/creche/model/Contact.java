package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Contact.findAllContact",
			query="SELECT contact FROM Contact contact"),
	@NamedQuery(name="Contact.findContactByID",
			query="SELECT c FROM Contact c WHERE c.contactID = :contactID"),
})
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
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

	//bi-directional many-to-one association to Contactenfant
	@OneToMany(mappedBy="contact")
	private List<Contactenfant> contactenfants;

	public Contact() {
	}

	public int getContactID() {
		return this.contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public int getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public int getGsm() {
		return this.gsm;
	}

	public void setGsm(int gsm) {
		this.gsm = gsm;
	}

	public String getLocalite() {
		return this.localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public int getNiss() {
		return this.niss;
	}

	public void setNiss(int niss) {
		this.niss = niss;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getTelephone() {
		return this.telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public List<Contactenfant> getContactenfants() {
		return this.contactenfants;
	}

	public void setContactenfants(List<Contactenfant> contactenfants) {
		this.contactenfants = contactenfants;
	}

	public Contactenfant addContactenfant(Contactenfant contactenfant) {
		getContactenfants().add(contactenfant);
		contactenfant.setContact(this);

		return contactenfant;
	}

	public Contactenfant removeContactenfant(Contactenfant contactenfant) {
		getContactenfants().remove(contactenfant);
		contactenfant.setContact(null);

		return contactenfant;
	}

}