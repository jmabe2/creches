package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typelocal database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Typelocal.findAllTypeLocal",
			query="SELECT TypeLocal FROM Typelocal TypeLocal"),
	@NamedQuery(name="Typelocal.findTypeLocalByID",
			query="SELECT t FROM Typelocal t WHERE t.typeLocalID = :typeLocalID"),
})
public class Typelocal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int typeLocalID;

	private boolean actif;

	private String nom;

	//bi-directional many-to-one association to Local
	@OneToMany(mappedBy="typelocal")
	private List<Local> locals;

	public Typelocal() {
	}

	public int getTypeLocalID() {
		return this.typeLocalID;
	}

	public void setTypeLocalID(int typeLocalID) {
		this.typeLocalID = typeLocalID;
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

	public List<Local> getLocals() {
		return this.locals;
	}

	public void setLocals(List<Local> locals) {
		this.locals = locals;
	}

	public Local addLocal(Local local) {
		getLocals().add(local);
		local.setTypelocal(this);

		return local;
	}

	public Local removeLocal(Local local) {
		getLocals().remove(local);
		local.setTypelocal(null);

		return local;
	}

}