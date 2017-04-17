package com.creche.services;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import com.creche.model.Enfantsection;
import com.creche.model.Enfant;
import com.creche.connection.EMF;

public class EnfantSectionService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected static EntityManager em;
	
	public EnfantSectionService (){
		EnfantSectionService.em = EMF.getEM();

	}
	
	public Enfantsection createEnfantSection(Enfantsection enfantSection){

		em.getTransaction().begin();
		em.persist(enfantSection);
		em.getTransaction().commit();
		return enfantSection;
	}
	
	public Enfantsection updateEnfantSection (Enfantsection enfantSection){

		Enfantsection enfantSectionUpdate = em.find(Enfantsection.class, enfantSection.getEnfantSectionID());
		em.getTransaction().begin();
		enfantSectionUpdate.setDate_arrivee(enfantSection.getDate_arrivee());
		enfantSectionUpdate.setDate_depart(enfantSection.getDate_depart());
		enfantSectionUpdate.setRemarque(enfantSection.getRemarque());
		enfantSectionUpdate.setActif(enfantSection.getActif());
		em.getTransaction().commit();
		return enfantSectionUpdate;

	}
	
	public Enfantsection findEnfantSectionByID (int enfantSectionID){
		try {
			return (Enfantsection) em.createNamedQuery("EnfantSection.findEnfantSectionByID").setParameter("EnfantSectionID", enfantSectionID).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

		
	public List<Enfantsection> findAllEnfantSection (){
		try {
			TypedQuery<Enfantsection> query = em.createNamedQuery("EnfantSection.findAll", Enfantsection.class);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

		public  List<Enfantsection> findEnfantSectionByEnfant (Enfant enfant){
			try {
				TypedQuery<Enfantsection> query = em.createNamedQuery("EnfantSection.findEnfantSectionByEnfantID", Enfantsection.class)
						.setParameter("enfant", enfant);
				return query.getResultList();
			} catch (NoResultException e) {
				return null;
			}


	}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

}
