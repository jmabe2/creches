package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the materiel database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Materiel.findAll",
			query="SELECT m FROM Materiel m"),
	@NamedQuery(name="Materiel.findMaterielByID",
			query="SELECT m FROM Materiel m WHERE m.materielID = :materielID"),
})
public class Materiel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer materielID;

	private boolean actif;

	private String nom;

	private String propriete;

	//bi-directional many-to-one association to Localmateriel
	@OneToMany(mappedBy="materiel")
	private List<Localmateriel> localmateriels;

	//bi-directional many-to-many association to Local
	@ManyToMany
	@JoinTable(
		name="localmateriel"
		, joinColumns={
			@JoinColumn(name="MaterielID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="LocalID")
			}
		)
	private List<Local> locals;

	public Materiel() {
	}

	public Integer getMaterielID() {
		return this.materielID;
	}

	public void setMaterielID(Integer materielID) {
		this.materielID = materielID;
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

	public String getPropriete() {
		return this.propriete;
	}

	public void setPropriete(String propriete) {
		this.propriete = propriete;
	}

	public List<Localmateriel> getLocalmateriels() {
		return this.localmateriels;
	}

	public void setLocalmateriels(List<Localmateriel> localmateriels) {
		this.localmateriels = localmateriels;
	}

	public Localmateriel addLocalmateriel(Localmateriel localmateriel) {
		getLocalmateriels().add(localmateriel);
		localmateriel.setMateriel(this);

		return localmateriel;
	}

	public Localmateriel removeLocalmateriel(Localmateriel localmateriel) {
		getLocalmateriels().remove(localmateriel);
		localmateriel.setMateriel(null);

		return localmateriel;
	}

	public List<Local> getLocals() {
		return this.locals;
	}

	public void setLocals(List<Local> locals) {
		this.locals = locals;
	}

    @Override
    public boolean equals(Object other) {
        return (other != null && getClass() == other.getClass() && materielID != null)
            ? materielID.equals(((Materiel) other).materielID)
            : (other == this);
    }

    @Override
    public int hashCode() {
        return (materielID != null) 
            ? (getClass().hashCode() + materielID.hashCode())
            : super.hashCode();
    }
}