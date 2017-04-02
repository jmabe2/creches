package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the enfant database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Enfant.findAll", query="SELECT e FROM Enfant e"),
	@NamedQuery(name="Enfant.findEnfantByID",
	query="SELECT e FROM Enfant e WHERE e.enfantID = :enfantID" ) })

public class Enfant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer enfantID;

	private boolean actif;

	@Temporal(TemporalType.DATE)
	private Date ddn;

	private String nom;

	private String prenom;

	private String sexe;

	//bi-directional many-to-one association to Contactenfant
	@OneToMany(mappedBy="enfant")
	private List<Contactenfant> contactenfants;

	//bi-directional many-to-one association to Enfantmedicament
	@OneToMany(mappedBy="enfant")
	private List<Enfantmedicament> enfantmedicaments;

	//bi-directional many-to-one association to Enfantsection
	@OneToMany(mappedBy="enfant")
	private List<Enfantsection> enfantsections;

	//bi-directional many-to-one association to Soinsenfant
	@OneToMany(mappedBy="enfant")
	private List<Soinsenfant> soinsenfants;

	public Enfant() {
	}

	public Integer getEnfantID() {
		return this.enfantID;
	}

	public void setEnfantID(Integer enfantID) {
		this.enfantID = enfantID;
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Date getDdn() {
		return this.ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public List<Contactenfant> getContactenfants() {
		return this.contactenfants;
	}

	public void setContactenfants(List<Contactenfant> contactenfants) {
		this.contactenfants = contactenfants;
	}

	public Contactenfant addContactenfant(Contactenfant contactenfant) {
		getContactenfants().add(contactenfant);
		contactenfant.setEnfant(this);

		return contactenfant;
	}

	public Contactenfant removeContactenfant(Contactenfant contactenfant) {
		getContactenfants().remove(contactenfant);
		contactenfant.setEnfant(null);

		return contactenfant;
	}

	public List<Enfantmedicament> getEnfantmedicaments() {
		return this.enfantmedicaments;
	}

	public void setEnfantmedicaments(List<Enfantmedicament> enfantmedicaments) {
		this.enfantmedicaments = enfantmedicaments;
	}

	public Enfantmedicament addEnfantmedicament(Enfantmedicament enfantmedicament) {
		getEnfantmedicaments().add(enfantmedicament);
		enfantmedicament.setEnfant(this);

		return enfantmedicament;
	}

	public Enfantmedicament removeEnfantmedicament(Enfantmedicament enfantmedicament) {
		getEnfantmedicaments().remove(enfantmedicament);
		enfantmedicament.setEnfant(null);

		return enfantmedicament;
	}

	public List<Enfantsection> getEnfantsections() {
		return this.enfantsections;
	}

	public void setEnfantsections(List<Enfantsection> enfantsections) {
		this.enfantsections = enfantsections;
	}

	public Enfantsection addEnfantsection(Enfantsection enfantsection) {
		getEnfantsections().add(enfantsection);
		enfantsection.setEnfant(this);

		return enfantsection;
	}

	public Enfantsection removeEnfantsection(Enfantsection enfantsection) {
		getEnfantsections().remove(enfantsection);
		enfantsection.setEnfant(null);

		return enfantsection;
	}

	public List<Soinsenfant> getSoinsenfants() {
		return this.soinsenfants;
	}

	public void setSoinsenfants(List<Soinsenfant> soinsenfants) {
		this.soinsenfants = soinsenfants;
	}

	public Soinsenfant addSoinsenfant(Soinsenfant soinsenfant) {
		getSoinsenfants().add(soinsenfant);
		soinsenfant.setEnfant(this);

		return soinsenfant;
	}

	public Soinsenfant removeSoinsenfant(Soinsenfant soinsenfant) {
		getSoinsenfants().remove(soinsenfant);
		soinsenfant.setEnfant(null);

		return soinsenfant;
	}
	
	 @Override
	    public boolean equals(Object other) {
	        return (other != null && getClass() == other.getClass() && enfantID != null)
	            ? enfantID.equals(((Enfant) other).enfantID)
	            : (other == this);
	    }

	    @Override
	    public int hashCode() {
	        return (enfantID != null) 
	            ? (getClass().hashCode() + enfantID.hashCode())
	            : super.hashCode();
	    }


}