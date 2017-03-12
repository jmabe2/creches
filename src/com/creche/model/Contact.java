package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.lang.Integer;


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
	private Integer contactID;

	private boolean actif;

	private Integer codePostal;

	private Integer gsm;

	private String localite;

	private Integer niss;

	private String nom;

	private Integer numero;

	private String prenom;

	private String rue;

	private Integer telephone;

	//bi-directional many-to-one association to Contactenfant
	@OneToMany(mappedBy="contact")
	private List<Contactenfant> contactenfants;

	public Contact() {
	}

	public Integer getContactID() {
		return this.contactID;
	}

	public void setContactID(Integer contactID) {
		this.contactID = contactID;
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Integer getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}

	public Integer getGsm() {
		return this.gsm;
	}

	public void setGsm(Integer gsm) {
		this.gsm = gsm;
	}

	public String getLocalite() {
		return this.localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public Integer getNiss() {
		return this.niss;
	}

	public void setNiss(Integer niss) {
		this.niss = niss;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
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

	public Integer getTelephone() {
		return this.telephone;
	}

	public void setTelephone(Integer telephone) {
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