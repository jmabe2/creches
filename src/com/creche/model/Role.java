package com.creche.model;

import java.io.Serializable;
import javax.persistence.*;


import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Role.findAll"
			, query="SELECT r FROM Role r"),
	@NamedQuery(name="Role.findRoleByID",
			query="SELECT r FROM Role r WHERE r.roleID = :roleID"),
})

@Table(name = "Role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer roleID;

	private boolean actif;
    
	//@Pattern(regexp = "([a-zA-Z])", message = "Invalid format")
    @Column(name = "nom")
    private String nom;

	//bi-directional many-to-one association to Personnel
	@OneToMany(mappedBy="role")
	private List<Personnel> personnels;

	public Role() {
	}

	public Integer getRoleID() {
		return this.roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
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
	
	@Override
    public boolean equals(Object other) {
        return (other != null && getClass() == other.getClass() && roleID != null)
            ? roleID.equals(((Role) other).roleID)
            : (other == this);
    }

    @Override
    public int hashCode() {
        return (roleID != null) 
            ? (getClass().hashCode() + roleID.hashCode())
            : super.hashCode();
    }

}