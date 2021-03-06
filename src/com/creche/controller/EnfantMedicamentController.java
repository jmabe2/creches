package com.creche.controller;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.log4j.Logger;
import com.creche.model.Medicament;
import com.creche.model.Enfantmedicament;
import com.creche.model.Enfant;
import com.creche.services.EnfantMedicamentService;

@Named
@SessionScoped
public class EnfantMedicamentController implements Serializable{

	private static final long serialVersionUID = 1L;
	private List <Enfantmedicament> listEnfantmedicament;
	static Logger log = Logger.getLogger(EnfantMedicamentController.class);
	private Enfantmedicament enfantMedicament;
	private Medicament medicament;
	private Enfant enfant;
	private EnfantMedicamentService enfMedServ;

	public EnfantMedicamentController (){

	}
	
	@PostConstruct
	public void init(){

		enfantMedicament = new Enfantmedicament();
	}


	public String fillEnfantMedicament(){
		enfantMedicament.setEnfant(enfant);
		enfMedServ = new EnfantMedicamentService();
		enfMedServ.createEnfantMedicament(enfantMedicament);
		enfant.getEnfantmedicaments().add(enfantMedicament);
		return "viewEnfant";
	} 

	public String updateEnfantMedicament(){
		enfMedServ = new EnfantMedicamentService();
		enfMedServ.updateEnfantMedicament(enfantMedicament);
		return "listingEnfantMedicament";
	}


	public void loadEnfantMedicament(){
		enfMedServ = new EnfantMedicamentService();
		listEnfantmedicament=enfMedServ.findEnfantMedicamentByEnfant(enfant);		
	}


	public Enfantmedicament getEnfantMedicament() {
		return enfantMedicament;
	}
	public void setEnfantMedicament(Enfantmedicament enfantMedicament) {
		this.enfantMedicament = enfantMedicament;
	}
	
	public Medicament getMedicament() {
		return medicament;
	}
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}
	public EnfantMedicamentService getContactEnfServ() {
		return enfMedServ;
	}

	public void setContactEnfServ(EnfantMedicamentService enfMedServ) {
		this.enfMedServ = enfMedServ;
	}

	public List <Enfantmedicament> getListEnfantmedicament() {
		return listEnfantmedicament;
	}

	public void setListEnfantmedicament(List <Enfantmedicament> listEnfantmedicament) {
		this.listEnfantmedicament = listEnfantmedicament;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

}
