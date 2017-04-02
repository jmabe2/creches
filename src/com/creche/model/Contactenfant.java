package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contactenfant database table.
 * 
 */
@Entity
@NamedQueries ({
	@NamedQuery (name="Contactenfant.findAll", query="SELECT c FROM Contactenfant c"),
			@NamedQuery(name="Contact.findContactEnfantByID",
			query="SELECT c FROM Contactenfant c WHERE c.contactEnfantID = :contactEnfantID"),
			@NamedQuery(name="Contact.findContactEnfantBycontactID",
			query="SELECT c FROM Contactenfant c WHERE c.enfant = :enfant"),
})

	public class Contactenfant implements Serializable {
		private static final long serialVersionUID = 1L;

		@Id
		private int contactEnfantID;

		private String lienParente;

		private String natureRelation;

		private boolean tuteur;

		//bi-directional many-to-one association to Contact
		@ManyToOne
		@JoinColumn(name="ContactID")
		private Contact contact;

		//bi-directional many-to-one association to Enfant
		@ManyToOne
		@JoinColumn(name="EnfantID")
		private Enfant enfant;

		public Contactenfant() {
		}

		public int getContactEnfantID() {
			return this.contactEnfantID;
		}

		public void setContactEnfantID(int contactEnfantID) {
			this.contactEnfantID = contactEnfantID;
		}

		public String getLienParente() {
			return this.lienParente;
		}

		public void setLienParente(String lienParente) {
			this.lienParente = lienParente;
		}

		public String getNatureRelation() {
			return this.natureRelation;
		}

		public void setNatureRelation(String natureRelation) {
			this.natureRelation = natureRelation;
		}

		public boolean getTuteur() {
			return this.tuteur;
		}

		public void setTuteur(boolean tuteur) {
			this.tuteur = tuteur;
		}

		public Contact getContact() {
			return this.contact;
		}

		public void setContact(Contact contact) {
			this.contact = contact;
		}

		public Enfant getEnfant() {
			return this.enfant;
		}

		public void setEnfant(Enfant enfant) {
			this.enfant = enfant;
		}

	}