package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the section database table.
 * 
 */
@Entity
@NamedQuery(name="Section.findAll", query="SELECT s FROM Section s")
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int sectionID;

	private byte actif;

	private String nom;

	private String typeSection;

	//bi-directional many-to-one association to Enfantsection
	@OneToMany(mappedBy="section")
	private List<Enfantsection> enfantsections;

	public Section() {
	}

	public int getSectionID() {
		return this.sectionID;
	}

	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
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

	public String getTypeSection() {
		return this.typeSection;
	}

	public void setTypeSection(String typeSection) {
		this.typeSection = typeSection;
	}

	public List<Enfantsection> getEnfantsections() {
		return this.enfantsections;
	}

	public void setEnfantsections(List<Enfantsection> enfantsections) {
		this.enfantsections = enfantsections;
	}

	public Enfantsection addEnfantsection(Enfantsection enfantsection) {
		getEnfantsections().add(enfantsection);
		enfantsection.setSection(this);

		return enfantsection;
	}

	public Enfantsection removeEnfantsection(Enfantsection enfantsection) {
		getEnfantsections().remove(enfantsection);
		enfantsection.setSection(null);

		return enfantsection;
	}

}