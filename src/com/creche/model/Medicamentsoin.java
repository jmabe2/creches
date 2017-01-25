package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the medicamentsoins database table.
 * 
 */
@Entity
@Table(name="medicamentsoins")
@NamedQuery(name="Medicamentsoin.findAll", query="SELECT m FROM Medicamentsoin m")
public class Medicamentsoin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int medicamentSoinsID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String posologie;

	private String remarque;

	//bi-directional many-to-one association to Medicament
	@ManyToOne
	@JoinColumn(name="MedicamentID")
	private Medicament medicament;

	//bi-directional many-to-one association to Soin
	@ManyToOne
	@JoinColumn(name="SoinsID")
	private Soin soin;

	public Medicamentsoin() {
	}

	public int getMedicamentSoinsID() {
		return this.medicamentSoinsID;
	}

	public void setMedicamentSoinsID(int medicamentSoinsID) {
		this.medicamentSoinsID = medicamentSoinsID;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPosologie() {
		return this.posologie;
	}

	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}

	public String getRemarque() {
		return this.remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Medicament getMedicament() {
		return this.medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public Soin getSoin() {
		return this.soin;
	}

	public void setSoin(Soin soin) {
		this.soin = soin;
	}

}