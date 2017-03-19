package com.creche.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.creche.model.Personnel;
import com.creche.services.PersonnelService;

@Named
@SessionScoped
public class PersonnelController implements Serializable{


	private static final long serialVersionUID = 1L;
	private List <Personnel> listPersonnel;

	@Temporal(TemporalType.DATE)
	private Personnel personnel;
	private Personnel personnelUpdate;

	public PersonnelController() {
	}


	@PostConstruct
	public void init(){
		personnel = new Personnel();

	}

	public String fillPersonnel (){
		PersonnelService pService = new PersonnelService();
		personnel = pService.createPersonnel(personnel);
		clear();
		return "listingPersonne";
	}

	public String updatePersonnel(){
		PersonnelService pService = new PersonnelService();
		personnel = pService.updatePersonnel(personnelUpdate);
		clear();
		return "listingPersonne";
	}
	
	public void clear(){
	    setPersonnel(null);
	}
	
	public static boolean checkRolePersonnel(Personnel personnel, List<String> roles) {
		return (personnel != null) && (roles.contains(personnel.getRole().getNom()));
	}
	

	public void findAllPersonnel(){
		PersonnelService pService = new PersonnelService();
		listPersonnel= pService.findAllPersonnel();
	}
	
	public void loadPersonnel(){
		PersonnelService pService = new PersonnelService();
		listPersonnel = pService.findAllPersonnel();
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

	public void setListPersonnel(List <Personnel> listPersonnel) {
		this.listPersonnel = listPersonnel;
	}
	

	public Personnel getPersonnelUpdate() {
		return personnelUpdate;
	}


	public void setPersonnelUpdate(Personnel personnelUpdate) {
		this.personnelUpdate = personnelUpdate;
	}





}
