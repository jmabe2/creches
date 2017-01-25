package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sectionlocal database table.
 * 
 */
@Entity
@NamedQuery(name="Sectionlocal.findAll", query="SELECT s FROM Sectionlocal s")
public class Sectionlocal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int sectionLocalID;

	//bi-directional many-to-one association to Local
	@ManyToOne
	@JoinColumn(name="LocalID")
	private Local local;

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="SectionID")
	private Section section;

	public Sectionlocal() {
	}

	public int getSectionLocalID() {
		return this.sectionLocalID;
	}

	public void setSectionLocalID(int sectionLocalID) {
		this.sectionLocalID = sectionLocalID;
	}

	public Local getLocal() {
		return this.local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

}