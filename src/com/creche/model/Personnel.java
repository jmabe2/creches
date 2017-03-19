package com.creche.model;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the personnel database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Personnel.findAllContact",
			query="SELECT personnel FROM Personnel personnel"),
	@NamedQuery(name="Personnel.findContactLogin",
			query="SELECT personnel FROM Personnel personnel WHERE personnel.login = :login AND personnel.mdp = :mdp"),
	@NamedQuery(name="Personnel.findPersonnelByID",
	query="SELECT personnel FROM Personnel personnel WHERE personnel.personnelID = :personnelID"),
})
public class Personnel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int personnelID;
	
	private boolean actif;

	@Temporal(TemporalType.DATE)
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
	@OneToMany(mappedBy="personnel")
	private List<Soinsenfant> soinsenfants;

	public Personnel() {
	}

	public int getPersonnelID() {
		return this.personnelID;
	}

	public void setPersonnelID(int personnelID) {
		this.personnelID = personnelID;
	}

	public boolean getActif() {
		return this.actif;
	}

	public void setActif(boolean actif) {
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

	public List<Soinsenfant> getSoinsenfants() {
		return this.soinsenfants;
	}

	public void setSoinsenfants(List<Soinsenfant> soinsenfants) {
		this.soinsenfants = soinsenfants;
	}

	public Soinsenfant addSoinsenfant(Soinsenfant soinsenfant) {
		getSoinsenfants().add(soinsenfant);
		soinsenfant.setPersonnel(this);

		return soinsenfant;
	}

	public Soinsenfant removeSoinsenfant(Soinsenfant soinsenfant) {
		getSoinsenfants().remove(soinsenfant);
		soinsenfant.setPersonnel(null);

		return soinsenfant;
	}
	
	

}