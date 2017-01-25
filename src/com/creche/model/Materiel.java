package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the materiel database table.
 * 
 */
@Entity
@NamedQuery(name="Materiel.findAll", query="SELECT m FROM Materiel m")
public class Materiel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int materielID;

	private byte actif;

	private String nom;

	private String propriete;

	//bi-directional many-to-one association to Localmateriel
	@OneToMany(mappedBy="materiel")
	private List<Localmateriel> localmateriels;

	public Materiel() {
	}

	public int getMaterielID() {
		return this.materielID;
	}

	public void setMaterielID(int materielID) {
		this.materielID = materielID;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPropriete() {
		return this.propriete;
	}

	public void setPropriete(String propriete) {
		this.propriete = propriete;
	}

	public List<Localmateriel> getLocalmateriels() {
		return this.localmateriels;
	}

	public void setLocalmateriels(List<Localmateriel> localmateriels) {
		this.localmateriels = localmateriels;
	}

	public Localmateriel addLocalmateriel(Localmateriel localmateriel) {
		getLocalmateriels().add(localmateriel);
		localmateriel.setMateriel(this);

		return localmateriel;
	}

	public Localmateriel removeLocalmateriel(Localmateriel localmateriel) {
		getLocalmateriels().remove(localmateriel);
		localmateriel.setMateriel(null);

		return localmateriel;
	}

}