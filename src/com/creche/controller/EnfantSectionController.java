package com.creche.controller;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.creche.model.Enfant;
import com.creche.model.Enfantsection;
import com.creche.model.Section;
import com.creche.services.EnfantSectionService;

@Named
@SessionScoped
public class EnfantSectionController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List <Enfantsection> listEnfantSection;

	/**
	 * 
	 */
	private Enfantsection enfantSection;
	private Section section;
	private Enfant enfant;
	private EnfantSectionService enfSectServ;
	private Enfantsection updateEnfantSection;

	
	public EnfantSectionController () {

	}

	@PostConstruct
	public void init(){
		//enfant = new Enfant();
		enfantSection = new Enfantsection();
		updateEnfantSection = new Enfantsection();
		
	}

	
	/**
	 * @return
	 */
	public String fillEnfantSection(){
		enfSectServ = new EnfantSectionService();
		enfSectServ.createEnfantSection(enfantSection);
		enfantSection = new Enfantsection();
		enfantSection.getEnfant();
		enfantSection.getSection();
		return "listingEnfantSection";
	} 
	
	public String updateEnfantsection(){
		enfSectServ = new EnfantSectionService();
		enfantSection=enfSectServ.updateEnfantSection(updateEnfantSection);
		clear();
		return "listingEnfantSection";
	}
	
	public void loadEnfantSection(){
		enfSectServ = new EnfantSectionService();
		listEnfantSection=enfSectServ.findEnfantSectionByEnfant(enfant);	
		enfantSection = new Enfantsection();
	}
	
	public void loadAllEnfantSection(){
		enfSectServ = new EnfantSectionService();
		listEnfantSection=enfSectServ.findAllEnfantSection();	
		enfantSection = new Enfantsection();
		updateEnfantSection = new Enfantsection();
	}
	
	public void clear(){
		setEnfantSection(null);
	}
	
	
	public List<Enfantsection> getListEnfantSection() {
		return listEnfantSection;
	}
	public void setListEnfantSection(List<Enfantsection> listEnfantSection) {
		this.listEnfantSection = listEnfantSection;
	}
	public Enfantsection getEnfantSection() {
		return enfantSection;
	}
	public void setEnfantSection(Enfantsection enfantSection) {
		this.enfantSection = enfantSection;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public Enfant getEnfant() {
		return enfant;
	}
	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}
	public EnfantSectionService getEnfSectServ() {
		return enfSectServ;
	}
	public void setEnfSectServ(EnfantSectionService enfSectServ) {
		this.enfSectServ = enfSectServ;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Enfantsection getUpdateEnfantSection() {
		return updateEnfantSection;
	}

	public void setUpdateEnfantSection(Enfantsection updateEnfantSection) {
		this.updateEnfantSection = updateEnfantSection;
	}

}
