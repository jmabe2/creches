package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the soins database table.
 * 
 */
@Entity
@Table(name="soins")


@NamedQueries({
@NamedQuery(name="Soin.findSoinByID",
query="SELECT s FROM Soin s WHERE s.soinsID = :SoinID"),
@NamedQuery(name="Soin.findAll", query="SELECT s FROM Soin s")})


public class Soin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer soinsID;

	private String nom;

	//bi-directional many-to-one association to Medicamentsoin
	@OneToMany(mappedBy="soin")
	private List<Medicamentsoin> medicamentsoins;

	//bi-directional many-to-one association to Local
	@ManyToOne
	@JoinColumn(name="LocalID")
	private Local local;

	//bi-directional many-to-one association to Typesoin
	@ManyToOne
	@JoinColumn(name="TypeSoinsID")
	private Typesoin typesoin;

	//bi-directional many-to-one association to Soinsenfant
	@OneToMany(mappedBy="soin")
	private List<Soinsenfant> soinsenfants;

	public Soin() {
	}

	public Integer getSoinsID() {
		return this.soinsID;
	}

	public void setSoinsID(Integer soinsID) {
		this.soinsID = soinsID;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Medicamentsoin> getMedicamentsoins() {
		return this.medicamentsoins;
	}

	public void setMedicamentsoins(List<Medicamentsoin> medicamentsoins) {
		this.medicamentsoins = medicamentsoins;
	}

	public Medicamentsoin addMedicamentsoin(Medicamentsoin medicamentsoin) {
		getMedicamentsoins().add(medicamentsoin);
		medicamentsoin.setSoin(this);

		return medicamentsoin;
	}

	public Medicamentsoin removeMedicamentsoin(Medicamentsoin medicamentsoin) {
		getMedicamentsoins().remove(medicamentsoin);
		medicamentsoin.setSoin(null);

		return medicamentsoin;
	}

	public Local getLocal() {
		return this.local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Typesoin getTypesoin() {
		return this.typesoin;
	}

	public void setTypesoin(Typesoin typesoin) {
		this.typesoin = typesoin;
	}

	public List<Soinsenfant> getSoinsenfants() {
		return this.soinsenfants;
	}

	public void setSoinsenfants(List<Soinsenfant> soinsenfants) {
		this.soinsenfants = soinsenfants;
	}

	public Soinsenfant addSoinsenfant(Soinsenfant soinsenfant) {
		getSoinsenfants().add(soinsenfant);
		soinsenfant.setSoin(this);

		return soinsenfant;
	}

	public Soinsenfant removeSoinsenfant(Soinsenfant soinsenfant) {
		getSoinsenfants().remove(soinsenfant);
		soinsenfant.setSoin(null);

		return soinsenfant;
	}
	
	 @Override
	    public boolean equals(Object other) {
	        return (other != null && getClass() == other.getClass() && soinsID != null)
	            ? soinsID.equals(((Soin) other).soinsID)
	            : (other == this);
	    }

	    @Override
	    public int hashCode() {
	        return (soinsID != null) 
	            ? (getClass().hashCode() + soinsID.hashCode())
	            : super.hashCode();
	    }

}