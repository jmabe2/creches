package com.creche.controller;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.creche.model.Role;
import com.creche.services.RoleService;

@Named
@SessionScoped

public class RoleController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private boolean actif;
	private String nom;
	private int roleID;
	private Role role;
	
	
	public String fillRole () {
		RoleService rService = new RoleService();
		setRole(rService.createRole(nom, actif));
		return "RoleForm";
	}
	
	public RoleController() {
	}
	
	@PostConstruct
	public void init(){

	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



}
