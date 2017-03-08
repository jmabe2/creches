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
	private Personnel personnel;
	private Integer personnelID;

	public PersonnelController() {
	}

	@PostConstruct
	public void init(){
		personnel = new Personnel();

	}

	public String fillPersonnel (){
		PersonnelService pService = new PersonnelService();
		personnel = pService.createPersonnel(personnel);
		return "PersonnelForm";
	}

	public String updatePersonnel(){
		PersonnelService pService = new PersonnelService();
		personnel = pService.updatePersonnel(personnelID, personnel);
		return "PersonnelForm";
	}

	public void findAllPersonnel(){
		PersonnelService pService = new PersonnelService();
		listPersonnel= pService.findAllPersonnel();
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
