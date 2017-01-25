package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int roleID;

	private byte actif;

	private String nom;

	//bi-directional many-to-one association to Personnel
	@OneToMany(mappedBy="role")
	private List<Personnel> personnels;

	public Role() {
	}

	public int getRoleID() {
		return this.roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Personnel> getPersonnels() {
		return this.personnels;
	}

	public void setPersonnels(List<Personnel> personnels) {
		this.personnels = personnels;
	}

	public Personnel addPersonnel(Personnel personnel) {
		getPersonnels().add(personnel);
		personnel.setRole(this);

		return personnel;
	}

	public Personnel removePersonnel(Personnel personnel) {
		getPersonnels().remove(personnel);
		personnel.setRole(null);

		return personnel;
	}

}