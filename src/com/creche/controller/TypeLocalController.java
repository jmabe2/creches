package com.creche.controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.creche.model.Typelocal;
import com.creche.services.TypeLocalService;


@Named
@SessionScoped
public class TypeLocalController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List <Typelocal> listTypeLocal;

	private Typelocal typeLocal;

	public TypeLocalController(){

	}

	@PostConstruct
	public void init(){
		
	}

	public String fillTypeLocal(){
		TypeLocalService.createLocal(typeLocal);
		return "listingTypeLocal";
	} 

	public String updateTypeLocal(){
		TypeLocalService.updateTypeLocal(typeLocal);
		return "listingTypeLocal";
	}

	/*public void removeContact() {
		ContactService cService = new ContactService();
		contact = cService.removeContact(contactID);
	}*/

	public void loadTypeLocal(){
		TypeLocalService tlService = new TypeLocalService();
		listTypeLocal = tlService.findAllTypeLocal();
		typeLocal = new Typelocal();
	}
	
	public void loadTypeLocal(boolean actif){
		TypeLocalService tlService = new TypeLocalService();
		listTypeLocal = tlService.findAllTypeLocal(actif);
		typeLocal = new Typelocal();
	}

	// Getters ans setters
	public List<Typelocal> getListTypeLocal() {
		return listTypeLocal;
	}

	public void setListTypeLocal(List<Typelocal> listTypeLocal) {
		this.listTypeLocal = listTypeLocal;
	}

	public Typelocal getTypeLocal() {
		return typeLocal;
	}

	public void setTypeLocal(Typelocal typeLocal) {
		this.typeLocal = typeLocal;
	}

}
