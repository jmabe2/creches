package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the typesoins database table.
 * 
 */
@Entity
@Table(name="typesoins")
@NamedQuery(name="Typesoin.findAll", query="SELECT t FROM Typesoin t")
public class Typesoin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int typeSoinsID;

	private byte actif;

	private String description;

	private String nom;

	private String symptome;

	public Typesoin() {
	}

	public int getTypeSoinsID() {
		return this.typeSoinsID;
	}

	public void setTypeSoinsID(int typeSoinsID) {
		this.typeSoinsID = typeSoinsID;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSymptome() {
		return this.symptome;
	}

	public void setSymptome(String symptome) {
		this.symptome = symptome;
	}

}