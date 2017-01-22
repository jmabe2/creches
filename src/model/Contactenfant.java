package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contactenfant database table.
 * 
 */
@Entity
@NamedQuery(name="Contactenfant.findAll", query="SELECT c FROM Contactenfant c")
public class Contactenfant implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ContactenfantPK id;

	private String lienParente;

	private String natureRelation;

	private byte tuteur;

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

	public ContactenfantPK getId() {
		return this.id;
	}

	public void setId(ContactenfantPK id) {
		this.id = id;
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

	public byte getTuteur() {
		return this.tuteur;
	}

	public void setTuteur(byte tuteur) {
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