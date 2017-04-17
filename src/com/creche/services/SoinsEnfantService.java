package com.creche.services;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import com.creche.model.Soinsenfant;
import com.creche.model.Enfant;
import com.creche.connection.EMF;

public class SoinsEnfantService implements Serializable {

	private static final long serialVersionUID = 1L;
	protected static EntityManager em;

	public SoinsEnfantService (){
		SoinsEnfantService.em = EMF.getEM();

	}

	public Soinsenfant createSoinsEnfant(Soinsenfant soinEnfant){

		em.getTransaction().begin();
		em.persist(soinEnfant);
		em.getTransaction().commit();
		return soinEnfant;
	}

	public Soinsenfant findSoinEnfantByID (int SoinEnfantID){
		try {
			return (Soinsenfant) em.createNamedQuery("SoinsEnfant.findSoinEnfantByID").setParameter("SoinEnfantID", SoinEnfantID).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public  List<Soinsenfant> findSoinsEnfantByEnfant (Enfant enfant){
		try {
			TypedQuery<Soinsenfant> query = em.createNamedQuery("Soinsenfant.findSoinEnfantByEnfantID", Soinsenfant.class)
					.setParameter("enfant", enfant);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}


	}
}
