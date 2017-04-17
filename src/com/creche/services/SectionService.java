package com.creche.services;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import com.creche.connection.EMF;
import com.creche.model.Section;

public class SectionService implements Serializable{

	private static final long serialVersionUID = 1L;
	protected static EntityManager em;
	
	/**
	 * 
	 * @param em (EntityManager)
	 */
	
	public SectionService (){
		SectionService.em=EMF.getEM();

	}
	
	/**
	 *  Method to create a section
	 * @param roleID
	 */

	public Section createSection (Section section){

		em.getTransaction().begin();
		em.persist(section);
		em.getTransaction().commit();
		return section;

	}
	

	/**
	 *  Method to update a section
	 */

	public Section updateSection (Section section){

		Section sectionUpdate = em.find(Section.class, section.getSectionID());
		//Section sectionUpdate = em.find(Section.class, section.getSectionID());
		em.getTransaction().begin();
		em.merge(section);
		sectionUpdate.setNom(section.getNom());
		sectionUpdate.setTypeSection(section.getTypeSection());
		sectionUpdate.setActif(section.getActif());
		em.getTransaction().commit();
		return sectionUpdate;

	}
	
	public Section findSectionByID (int sectionID){
		try {
			return (Section) em.createNamedQuery("Section.findSectionByID").setParameter("sectionID", sectionID).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}
	
	public static  Section findSectionByByName (String nom){
		try {
			return (Section) em.createNamedQuery("Section.findSectionByName").setParameter("nom", nom).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}
	
	public List<Section> findAllSection (){
		try {
			TypedQuery<Section> query = em.createNamedQuery("Section.findAll", Section.class);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

}
