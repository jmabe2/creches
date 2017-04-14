package com.creche.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.creche.model.Local;
import com.creche.model.Localmateriel;
import com.creche.services.LocalMaterielService;


@Named
@SessionScoped
public class LocalMaterielController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List <Localmateriel> listLocalMateriel;
	
	private Localmateriel localMateriel;
	private Local local;
	
	public LocalMaterielController(){
		
	}
	
	@PostConstruct
	public void init(){
		local = new Local();
	}
	
	public String fillLocalMateriel(){	
		localMateriel.setLocal(local);
		LocalMaterielService.createLocalMateriel(localMateriel);
		return "listingLocalMateriel";
	} 
	
	public String updateLocalMateriel(){
		LocalMaterielService.updateLocalMateriel(localMateriel);
		return "listingLocalMateriel";
	}
	
	public void removeLocalMateriel(Localmateriel lmToRemove) {
		LocalMaterielService.removeLocalMateriel(lmToRemove);
	}
	
	public void loadMaterielForALocal(){
		LocalMaterielService lService = new LocalMaterielService();
		listLocalMateriel = lService.findAllMaterielForALocal(local);
		localMateriel = new Localmateriel();
	}

	//Getter & Setters
	public List<Localmateriel> getListLocalMateriel() {
		return listLocalMateriel;
	}

	public void setListLocalMateriel(List<Localmateriel> listLocalMateriel) {
		this.listLocalMateriel = listLocalMateriel;
	}

	public Localmateriel getLocalMateriel() {
		return localMateriel;
	}

	public void setLocalMateriel(Localmateriel localMateriel) {
		this.localMateriel = localMateriel;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

}
