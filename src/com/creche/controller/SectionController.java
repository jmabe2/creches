package com.creche.controller;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.creche.model.Section;
import com.creche.services.SectionService;

@Named
@SessionScoped
public class SectionController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List <Section> listSection;
	private Section section;
	private Section sectionUpdate;
	
	public SectionController (){
		
	}
	
	@PostConstruct
	public void init(){
		section = new Section();

	}
	
	public String fillSection () {
		SectionService sService = new SectionService();
		sService.createSection(section);
		clear();
		return "listingSection";
	}

	public String updateSection(){
		SectionService sService = new SectionService();
		section = sService.updateSection(sectionUpdate);
		//System.out.println(section);
		clear();
		return "listingSection";
	}
	
	public void loadSection(){
		SectionService sService = new SectionService();
		listSection = sService.findAllSection();
	}
	
	public void clear(){
		setSection(null);
	}
	
	public List<Section> getListSection() {
		return listSection;
	}
	public void setListSection(List<Section> listSection) {
		this.listSection = listSection;
	}
	public Section getSection() {
		return section;
	}
	public void setSection(Section section) {
		this.section = section;
	}
	public Section getSectionUpdate() {
		return sectionUpdate;
	}
	public void setSectionUpdate(Section sectionUpdate) {
		this.sectionUpdate = sectionUpdate;
	}

}
