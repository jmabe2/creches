package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the section database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Section.findAll"
			, query="SELECT s FROM Section s"),
	@NamedQuery(name="Section.findSectionByID",
			query="SELECT s FROM Section s WHERE s.sectionID = :sectionID"),
	@NamedQuery(name="Section.findSectionByName",
	query="SELECT s FROM Section s WHERE s.nom = :nom"),
	
})

public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer sectionID;

	private boolean actif;

	private String nom;

	private String typeSection;

	//bi-directional many-to-one association to Enfantsection
	@OneToMany(mappedBy="section")
	private List<Enfantsection> enfantsections;

	//bi-directional many-to-many association to Local
	@ManyToMany
	@JoinTable(
		name="sectionlocal"
		, joinColumns={
			@JoinColumn(name="SectionID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="LocalID")
			}
		)
	private List<Local> locals;

	//bi-directional many-to-one association to Sectionlocal
	@OneToMany(mappedBy="section")
	private List<Sectionlocal> sectionlocals;

	public Section() {
	}

	public Integer getSectionID() {
		return this.sectionID;
	}

	public void setSectionID(Integer sectionID) {
		this.sectionID = sectionID;
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
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

	public List<Local> getLocals() {
		return this.locals;
	}

	public void setLocals(List<Local> locals) {
		this.locals = locals;
	}

	public List<Sectionlocal> getSectionlocals() {
		return this.sectionlocals;
	}

	public void setSectionlocals(List<Sectionlocal> sectionlocals) {
		this.sectionlocals = sectionlocals;
	}

	public Sectionlocal addSectionlocal(Sectionlocal sectionlocal) {
		getSectionlocals().add(sectionlocal);
		sectionlocal.setSection(this);

		return sectionlocal;
	}

	public Sectionlocal removeSectionlocal(Sectionlocal sectionlocal) {
		getSectionlocals().remove(sectionlocal);
		sectionlocal.setSection(null);

		return sectionlocal;
	}
	
	@Override
    public boolean equals(Object other) {
        return (other != null && getClass() == other.getClass() && sectionID != null)
            ? sectionID.equals(((Section) other).sectionID)
            : (other == this);
    }

    @Override
    public int hashCode() {
        return (sectionID != null) 
            ? (getClass().hashCode() + sectionID.hashCode())
            : super.hashCode();
    }

}