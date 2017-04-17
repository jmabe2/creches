package com.creche.controller;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.log4j.Logger;
import com.creche.model.Soin;
import com.creche.model.Soinsenfant;
import com.creche.model.Enfant;
import com.creche.services.SoinsEnfantService;

@Named
@SessionScoped
public class SoinsEnfantController implements Serializable{

	private static final long serialVersionUID = 1L;
	private List <Soinsenfant> listSoinsenfant;
	static Logger log = Logger.getLogger(SoinsEnfantController.class);
	private Soinsenfant soinEnfant;
	

	private Enfant enfant;
	private Soin soin;
	private SoinsEnfantService soinEnfServ;

	public SoinsEnfantController (){

	}
	
	@PostConstruct
	public void init(){

		soinEnfant = new Soinsenfant();
	}


	public String fillSoinsEnfant(){
		log.debug("---------------------");
		log.debug("ok");
		soinEnfant.setEnfant(enfant);
		soinEnfServ = new SoinsEnfantService();
		soinEnfServ.createSoinsEnfant(soinEnfant);
			
		return "viewEnfant";
	} 




	public void loadSoinsEnfant(){
		soinEnfServ = new SoinsEnfantService();
		listSoinsenfant=soinEnfServ.findSoinsEnfantByEnfant(enfant);		
	}


	public Soinsenfant getSoinsEnfant() {
		return soinEnfant;
	}
	public void setSoinsEnfant(Soinsenfant soinMedicament) {
		this.soinEnfant = soinMedicament;
	}
	
	public Soin getSoin() {
		return soin;
	}
	public void setSoin(Soin soin) {
		this.soin = soin;
	}


	public void setContactEnfServ(SoinsEnfantService soinEnfServ) {
		this.soinEnfServ = soinEnfServ;
	}

	public List <Soinsenfant> getListSoinsenfant() {
		return listSoinsenfant;
	}

	public void setListSoinsenfant(List <Soinsenfant> listSoinsenfant) {
		this.listSoinsenfant = listSoinsenfant;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public Soinsenfant getSoinEnfant() {
		return soinEnfant;
	}

	public void setSoinEnfant(Soinsenfant soinEnfant) {
		this.soinEnfant = soinEnfant;
	}
}
