package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the personnel database table.
 * 
 */
@Entity
@NamedQuery(name="Personnel.findAll", query="SELECT p FROM Personnel p")
public class Personnel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int personnelID;

	private byte actif;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ddn;

	private String login;

	private String mdp;

	private String nom;

	private String prenom;

	private String sexe;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="RoleID")
	private Role role;

	//bi-directional many-to-one association to Soinsenfant
	@ManyToOne
	@JoinColumn(name="SoinsEnfantID")
	private Soinsenfant soinsenfant;

	public Personnel() {
	}

	public int getPersonnelID() {
		return this.personnelID;
	}

	public void setPersonnelID(int personnelID) {
		this.personnelID = personnelID;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public Date getDdn() {
		return this.ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Soinsenfant getSoinsenfant() {
		return this.soinsenfant;
	}

	public void setSoinsenfant(Soinsenfant soinsenfant) {
		this.soinsenfant = soinsenfant;
	}

}