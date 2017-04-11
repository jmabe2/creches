package com.creche.services;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import com.creche.model.Enfantmedicament;
import com.creche.model.Enfant;
import com.creche.connection.EMF;

public class EnfantMedicamentService implements Serializable {

	private static final long serialVersionUID = 1L;
	protected static EntityManager em;

	public EnfantMedicamentService (){
		EnfantMedicamentService.em = EMF.getEM();

	}

	public Enfantmedicament createEnfantMedicament(Enfantmedicament enfantMedicament){

		em.getTransaction().begin();
		em.persist(enfantMedicament);
		em.getTransaction().commit();
		return enfantMedicament;
	}

	public Enfantmedicament updateEnfantMedicament (Enfantmedicament enfantMedicament){

		Enfantmedicament enfantMedicamentUpdate = em.find(Enfantmedicament.class, enfantMedicament.getEnfantMedicamentID());
		em.getTransaction().begin();
		em.merge(enfantMedicament);
		enfantMedicament.getDateDebut();
		enfantMedicament.getDateFin();
		enfantMedicament.getPosologie();
		em.getTransaction().commit();
		return enfantMedicamentUpdate;

	}


	public Enfantmedicament findEnfantMedicamentByID (int EnfantMedicamentID){
		try {
			return (Enfantmedicament) em.createNamedQuery("EnfantMedicament.findEnfantMedicamentByID").setParameter("EnfantMedicamentID", EnfantMedicamentID).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}



	public  List<Enfantmedicament> findEnfantMedicamentByEnfant (Enfant enfant){
		try {
			TypedQuery<Enfantmedicament> query = em.createNamedQuery("EnfantMedicament.findEnfantMedicamentByEnfantID", Enfantmedicament.class)
					.setParameter("enfant", enfant);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}


	}
}
