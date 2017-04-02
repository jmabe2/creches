package com.creche.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.creche.model.Enfant;
import com.creche.services.EnfantService;


@Named
@SessionScoped
public class EnfantController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List <Enfant> listEnfant;
	private Enfant enfant;
	private Enfant enfantUpdate;
	
	public EnfantController (){
		
	}
	
	@PostConstruct
	public void init(){
		enfant = new Enfant();
	}
	
	public String fillEnfant(){
		EnfantService eService = new EnfantService();
		enfant = eService.createEnfant(enfant);
		clear();
		return "listingEnfant";
	} 

	public String updateEnfant(){
		EnfantService eService = new EnfantService();
		enfant = eService.updateEnfant(enfantUpdate);
		clear();
		return "listingEnfant";
	}
	
	public void loadEnfant(){
		EnfantService eService = new EnfantService();
		listEnfant = eService.findAllEnfant();
		clear();
	}
	
	public void clear(){
	    setEnfant(null);
	}
	
	public List<Enfant> getListEnfant() {
		return listEnfant;
	}
	public void setListEnfant(List<Enfant> listEnfant) {
		this.listEnfant = listEnfant;
	}
	public Enfant getEnfant() {
		return enfant;
	}
	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}
	public Enfant getEnfanttUpdate() {
		return enfanttUpdate;
	}
	public void setEnfanttUpdate(Enfant enfanttUpdate) {
		this.enfanttUpdate = enfanttUpdate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Enfant getEnfantUpdate() {
		return enfantUpdate;
	}

	public void setEnfantUpdate(Enfant enfantUpdate) {
		this.enfantUpdate = enfantUpdate;
	}
	private Enfant enfanttUpdate;


}
