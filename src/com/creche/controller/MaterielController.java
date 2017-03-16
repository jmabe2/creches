package com.creche.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.creche.model.Materiel;
import com.creche.services.MaterielService;


@Named
@SessionScoped
public class MaterielController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List <Materiel> listMateriel;

	private Materiel materiel;

	public MaterielController(){

	}

	@PostConstruct
	public void init(){
		materiel = new Materiel();
	}

	public String fillMateriel(){
		MaterielService.createMateriel(materiel);
		materiel = new Materiel();
		return "listingMateriel";
	} 

	public String updateMateriel(){
		MaterielService.updateMateriel(materiel);
		materiel = new Materiel();
		return "listingMateriel";
	}

	/*public void removeContact() {
		ContactService cService = new ContactService();
		contact = cService.removeContact(contactID);
	}*/

	public void loadMateriel(){
		MaterielService mService = new MaterielService();
		listMateriel = mService.findAllMateriel();
	}


	//getters & setters
	public List<Materiel> getListMateriel() {
		return listMateriel;
	}

	public void setListMateriel(List<Materiel> listMateriel) {
		this.listMateriel = listMateriel;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

}
