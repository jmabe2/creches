package com.creche.controller;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.log4j.Logger;
import com.creche.model.Medicament;
import com.creche.model.Medicamentsoin;
import com.creche.model.Soin;
import com.creche.services.MedicamentSoinService;

@Named
@SessionScoped
public class MedicamentSoinController implements Serializable{

	private static final long serialVersionUID = 1L;
	private List <Medicamentsoin> listMedicamentsoin;
	static Logger log = Logger.getLogger(MedicamentSoinController.class);
	private Medicamentsoin soinMedicament;
	private Medicament medicament;
	private Soin soin;
	private MedicamentSoinService medSoinServ;

	public MedicamentSoinController (){

	}
	
	@PostConstruct
	public void init(){

		soinMedicament = new Medicamentsoin();
	}


	public String fillMedicamentSoin(){
		soinMedicament.setSoin(soin);
		medSoinServ = new MedicamentSoinService();
		medSoinServ.createMedicamentSoin(soinMedicament);
		soin.getMedicamentsoins().add(soinMedicament);
		return "viewSoin";
	} 

	public String updateMedicamentSoin(){
		medSoinServ = new MedicamentSoinService();
		medSoinServ.updateMedicamentSoin(soinMedicament);
		return "listingMedicamentSoin";
	}


	public void loadMedicamentSoin(){
		medSoinServ = new MedicamentSoinService();
		listMedicamentsoin=medSoinServ.findMedicamentSoinBySoin(soin);		
	}


	public Medicamentsoin getMedicamentSoin() {
		return soinMedicament;
	}
	public void setMedicamentSoin(Medicamentsoin soinMedicament) {
		this.soinMedicament = soinMedicament;
	}
	
	public Medicament getMedicament() {
		return medicament;
	}
	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}


	public void setContactEnfServ(MedicamentSoinService medSoinServ) {
		this.medSoinServ = medSoinServ;
	}

	public List <Medicamentsoin> getListMedicamentsoin() {
		return listMedicamentsoin;
	}

	public void setListMedicamentsoin(List <Medicamentsoin> listMedicamentsoin) {
		this.listMedicamentsoin = listMedicamentsoin;
	}

	public Soin getSoin() {
		return soin;
	}

	public void setSoin(Soin soin) {
		this.soin = soin;
	}

}
