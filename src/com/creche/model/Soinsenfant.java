package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the soinsenfant database table.
 * 
 */
@Entity
@NamedQuery(name="Soinsenfant.findAll", query="SELECT s FROM Soinsenfant s")
public class Soinsenfant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int soinsEnfantID;

	private byte actif;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSoins;

	private String remarque;

	//bi-directional many-to-one association to Personnel
	@OneToMany(mappedBy="soinsenfant")
	private List<Personnel> personnels;

	//bi-directional many-to-one association to Enfant
	@ManyToOne
	@JoinColumn(name="EnfantID")
	private Enfant enfant;

	//bi-directional many-to-one association to Soin
	@ManyToOne
	@JoinColumn(name="SoinsID")
	private Soin soin;

	public Soinsenfant() {
	}

	public int getSoinsEnfantID() {
		return this.soinsEnfantID;
	}

	public void setSoinsEnfantID(int soinsEnfantID) {
		this.soinsEnfantID = soinsEnfantID;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public Date getDateSoins() {
		return this.dateSoins;
	}

	public void setDateSoins(Date dateSoins) {
		this.dateSoins = dateSoins;
	}

	public String getRemarque() {
		return this.remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public List<Personnel> getPersonnels() {
		return this.personnels;
	}

	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}

	public Personnel addPersonnel(Personnel personnel) {
		getPersonnels().add(personnel);
		personnel.setSoinsenfant(this);

		return personnel;
	}

	public Personnel removePersonnel(Personnel personnel) {
		getPersonnels().remove(personnel);
		personnel.setSoinsenfant(null);

		return personnel;
	}

	public Enfant getEnfant() {
		return this.enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public Soin getSoin() {
		return this.soin;
	}

	public void setSoin(Soin soin) {
		this.soin = soin;
	}

}