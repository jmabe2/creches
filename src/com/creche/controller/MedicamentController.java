package com.creche.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;

import com.creche.model.Medicament;
import com.creche.services.MedicamentService;


@Named
@SessionScoped
public class MedicamentController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List <Medicament> listMedicament;
	private String nameSearch;
	static Logger log = Logger.getLogger(MedicamentController.class);
	
	public String getNameSearch() {
		return nameSearch;
	}

	public void setNameSearch(String nameSearch) {
		this.nameSearch = nameSearch;
	}
	private Medicament medicament;
	
	
	public MedicamentController (){
		
	}
	
	@PostConstruct
	public void init(){
		medicament = new Medicament();
	}
	
	public String fillMedicament(){
		MedicamentService eService = new MedicamentService();
		medicament = eService.createMedicament(medicament);
		clear();
		return "listingMedicament";
	} 

	public String updateMedicament(){
		MedicamentService eService = new MedicamentService();
		medicament = eService.updateMedicament(medicamentUpdate);
		clear();
		return "listingMedicament";
	}
	
	public void loadMedicament(){
		//MedicamentService eService = new MedicamentService();
		//listMedicament = eService.findAllMedicament();
		clear();
	}
	
	public void searchMedicament(){
		MedicamentService eService = new MedicamentService();
		listMedicament = eService.findMedicamentByName(nameSearch);
		log.debug("------------");
		log.debug(listMedicament);
    	log.debug("------------");
	}
	
	public void clear(){
	    setMedicament(null);
	}
	
	public List<Medicament> getListMedicament() {
		return listMedicament;
	}
	public void setListMedicament(List<Medicament> listMedicament) {
		this.listMedicament = listMedicament;
	}
	public Medicament getMedicament() {
		return medicament;
	}
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	public Medicament getMedicamenttUpdate() {
		return medicamentUpdate;
	}
	public void setMedicamenttUpdate(Medicament medicamentUpdate) {
		this.medicamentUpdate = medicamentUpdate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Medicament getMedicamentUpdate() {
		return medicamentUpdate;
	}

	public void setMedicamentUpdate(Medicament medicamentUpdate) {
		this.medicamentUpdate = medicamentUpdate;
	}
	private Medicament medicamentUpdate;


}
