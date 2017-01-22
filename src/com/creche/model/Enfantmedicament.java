package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the enfantmedicament database table.
 * 
 */
@Entity
@NamedQuery(name="Enfantmedicament.findAll", query="SELECT e FROM Enfantmedicament e")
public class Enfantmedicament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int enfantMedicamentID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDebut;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;

	private String posologie;

	//bi-directional many-to-one association to Enfant
	@ManyToOne
	@JoinColumn(name="EnfantID")
	private Enfant enfant;

	//bi-directional many-to-one association to Medicament
	@ManyToOne
	@JoinColumn(name="MedicamentID")
	private Medicament medicament;

	public Enfantmedicament() {
	}

	public int getEnfantMedicamentID() {
		return this.enfantMedicamentID;
	}

	public void setEnfantMedicamentID(int enfantMedicamentID) {
		this.enfantMedicamentID = enfantMedicamentID;
	}

	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getPosologie() {
		return this.posologie;
	}

	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}

	public Enfant getEnfant() {
		return this.enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public Medicament getMedicament() {
		return this.medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

}