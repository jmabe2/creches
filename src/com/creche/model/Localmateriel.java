package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the localmateriel database table.
 * 
 */
@Entity
@NamedQuery(name="Localmateriel.findAll", query="SELECT l FROM Localmateriel l")
public class Localmateriel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int localMaterielID;

	//bi-directional many-to-one association to Local
	@ManyToOne
	@JoinColumn(name="LocalID")
	private Local local;

	//bi-directional many-to-one association to Materiel
	@ManyToOne
	@JoinColumn(name="MaterielID")
	private Materiel materiel;

	public Localmateriel() {
	}

	public int getLocalMaterielID() {
		return this.localMaterielID;
	}

	public void setLocalMaterielID(int localMaterielID) {
		this.localMaterielID = localMaterielID;
	}

	public Local getLocal() {
		return this.local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Materiel getMateriel() {
		return this.materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

}