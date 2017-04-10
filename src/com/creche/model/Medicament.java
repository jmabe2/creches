package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the medicament database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Medicament.findAll", query="SELECT m FROM Medicament m"),
@NamedQuery(name="Medicament.findMedicamentByName",
query="SELECT m FROM Medicament m WHERE m.nom LIKE :name" ) })
public class Medicament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int medicamentID;

	private byte actif;

	private String indication;

	private String nom;

	private String remarque;

	private String type;

	//bi-directional many-to-one association to Enfantmedicament
	@OneToMany(mappedBy="medicament")
	private List<Enfantmedicament> enfantmedicaments;

	//bi-directional many-to-one association to Medicamentsoin
	@OneToMany(mappedBy="medicament")
	private List<Medicamentsoin> medicamentsoins;

	public Medicament() {
	}

	public int getMedicamentID() {
		return this.medicamentID;
	}

	public void setMedicamentID(int medicamentID) {
		this.medicamentID = medicamentID;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public String getIndication() {
		return this.indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRemarque() {
		return this.remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Enfantmedicament> getEnfantmedicaments() {
		return this.enfantmedicaments;
	}

	public void setEnfantmedicaments(List<Enfantmedicament> enfantmedicaments) {
		this.enfantmedicaments = enfantmedicaments;
	}

	public Enfantmedicament addEnfantmedicament(Enfantmedicament enfantmedicament) {
		getEnfantmedicaments().add(enfantmedicament);
		enfantmedicament.setMedicament(this);

		return enfantmedicament;
	}

	public Enfantmedicament removeEnfantmedicament(Enfantmedicament enfantmedicament) {
		getEnfantmedicaments().remove(enfantmedicament);
		enfantmedicament.setMedicament(null);

		return enfantmedicament;
	}

	public List<Medicamentsoin> getMedicamentsoins() {
		return this.medicamentsoins;
	}

	public void setMedicamentsoins(List<Medicamentsoin> medicamentsoins) {
		this.medicamentsoins = medicamentsoins;
	}

	public Medicamentsoin addMedicamentsoin(Medicamentsoin medicamentsoin) {
		getMedicamentsoins().add(medicamentsoin);
		medicamentsoin.setMedicament(this);

		return medicamentsoin;
	}

	public Medicamentsoin removeMedicamentsoin(Medicamentsoin medicamentsoin) {
		getMedicamentsoins().remove(medicamentsoin);
		medicamentsoin.setMedicament(null);

		return medicamentsoin;
	}

}