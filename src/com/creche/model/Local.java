package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the local database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Local.findAllLocal",
			query="SELECT l FROM Local l ORDER BY l.typelocal"),
	@NamedQuery(name="Local.findLocalByID",
			query="SELECT l FROM Local l WHERE l.localID = :localID"),
})
public class Local implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int localID;

	private boolean actif;

	private String section;

	//bi-directional many-to-one association to Typelocal
	@ManyToOne
	@JoinColumn(name="TypeLocalID")
	private Typelocal typelocal;

	//bi-directional many-to-one association to Localmateriel
	@OneToMany(mappedBy="local")
	private List<Localmateriel> localmateriels;

	//bi-directional many-to-many association to Materiel
	@ManyToMany(mappedBy="locals")
	private List<Materiel> materiels;

	//bi-directional many-to-many association to Section
	@ManyToMany(mappedBy="locals")
	private List<Section> sections;

	//bi-directional many-to-one association to Sectionlocal
	@OneToMany(mappedBy="local")
	private List<Sectionlocal> sectionlocals;

	//bi-directional many-to-one association to Soin
	@OneToMany(mappedBy="local")
	private List<Soin> soins;

	public Local() {
	}

	public int getLocalID() {
		return this.localID;
	}

	public void setLocalID(int localID) {
		this.localID = localID;
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getSection() {
		return this.section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Typelocal getTypelocal() {
		return this.typelocal;
	}

	public void setTypelocal(Typelocal typelocal) {
		this.typelocal = typelocal;
	}

	public List<Localmateriel> getLocalmateriels() {
		return this.localmateriels;
	}

	public void setLocalmateriels(List<Localmateriel> localmateriels) {
		this.localmateriels = localmateriels;
	}

	public Localmateriel addLocalmateriel(Localmateriel localmateriel) {
		getLocalmateriels().add(localmateriel);
		localmateriel.setLocal(this);

		return localmateriel;
	}

	public Localmateriel removeLocalmateriel(Localmateriel localmateriel) {
		getLocalmateriels().remove(localmateriel);
		localmateriel.setLocal(null);

		return localmateriel;
	}

	public List<Materiel> getMateriels() {
		return this.materiels;
	}

	public void setMateriels(List<Materiel> materiels) {
		this.materiels = materiels;
	}

	public List<Section> getSections() {
		return this.sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public List<Sectionlocal> getSectionlocals() {
		return this.sectionlocals;
	}

	public void setSectionlocals(List<Sectionlocal> sectionlocals) {
		this.sectionlocals = sectionlocals;
	}

	public Sectionlocal addSectionlocal(Sectionlocal sectionlocal) {
		getSectionlocals().add(sectionlocal);
		sectionlocal.setLocal(this);

		return sectionlocal;
	}

	public Sectionlocal removeSectionlocal(Sectionlocal sectionlocal) {
		getSectionlocals().remove(sectionlocal);
		sectionlocal.setLocal(null);

		return sectionlocal;
	}

	public List<Soin> getSoins() {
		return this.soins;
	}

	public void setSoins(List<Soin> soins) {
		this.soins = soins;
	}

	public Soin addSoin(Soin soin) {
		getSoins().add(soin);
		soin.setLocal(this);

		return soin;
	}

	public Soin removeSoin(Soin soin) {
		getSoins().remove(soin);
		soin.setLocal(null);

		return soin;
	}

}