package model;

import java.io.Serializable;
import javax.persistence.*;


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

}