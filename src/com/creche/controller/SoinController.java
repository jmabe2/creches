package com.creche.controller;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.log4j.Logger;
import com.creche.model.Soin;
import com.creche.services.EnfantMedicamentService;
import com.creche.services.SoinService;
import com.creche.services.TypeSoinService;

@Named
@SessionScoped
public class SoinController implements Serializable{

	private static final long serialVersionUID = 1L;
	private List <Soin> listSoin;
	static Logger log = Logger.getLogger(SoinController.class);
	private Soin soin;
	private SoinService soinServ;

	public SoinController (){

	}
	
	@PostConstruct
	public void init(){
		SoinService sService = new SoinService();
		listSoin = sService.findAllSoin();
		soin = new Soin();
	}

	public void test(){
		log.debug("---------------");
		log.debug(soin.getMedicamentsoins());
	}

	public String fillSoin(){
		soinServ = new SoinService();
		soinServ.createSoin(soin);
			
		return "listingSoin";
	} 

	public String updateSoin(){
		soinServ = new SoinService();
		soinServ.updateSoin(soin);
		return "listingSoin";
	}

	public Soin getSoin() {
		return soin;
	}
	public void setSoin(Soin soin) {
		this.soin = soin;
	}
	
	public List <Soin> getListSoin() {
		return listSoin;
	}

	public void setListSoin(List <Soin> listSoin) {
		this.listSoin = listSoin;
	}



}
