package com.creche.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.creche.model.Personnel;
import com.creche.model.Role;
import com.creche.services.PersonnelService;

@Named
@SessionScoped
public class PersonnelController implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private List <Personnel> listPersonnel;

	@Temporal(TemporalType.DATE)
	private int personnelID;
	private Date ddn;
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private String sexe;
	private Role roleID;
	private boolean actif;
	private Personnel personnel;
	
	public PersonnelController() {
	}
	
	@PostConstruct
	public void init(){

	}
	
	public String fillPersonnel (){
		PersonnelService pService = new PersonnelService();
		personnel = pService.createPersonnel(nom, prenom, ddn, sexe, login, mdp, actif, roleID);
		return "PersonnelForm";
	}
	
	public String updatePersonnel(){
		PersonnelService pService = new PersonnelService();
		personnel = pService.updatePersonnel(personnelID, nom, prenom, ddn, sexe, login, mdp, actif, roleID);
		return "PersonnelForm";
	}
	
	public void findAllPersonnel(){
		PersonnelService pService = new PersonnelService();
		listPersonnel= pService.findAllPersonnel();
	}
	
	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Date getDdn() {
		return ddn;
	}

	public void setDdn(Date ddn) {
		this.ddn = ddn;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Role getRoleID() {
		return roleID;
	}

	public void setRoleID(Role roleID) {
		this.roleID = roleID;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List <Personnel> getListPersonnel() {
		return listPersonnel;
	}

	public int getPersonnelID() {
		return personnelID;
	}

	public void setPersonnelID(int personnelID) {
		this.personnelID = personnelID;
	}

	public void setListPersonnel(List <Personnel> listPersonnel) {
		this.listPersonnel = listPersonnel;
	}

}
