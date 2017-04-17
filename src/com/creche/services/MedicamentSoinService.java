package com.creche.services;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import com.creche.model.Medicamentsoin;
import com.creche.model.Soin;
import com.creche.connection.EMF;

public class MedicamentSoinService implements Serializable {

	private static final long serialVersionUID = 1L;
	protected static EntityManager em;

	public MedicamentSoinService (){
		MedicamentSoinService.em = EMF.getEM();

	}

	public Medicamentsoin createMedicamentSoin(Medicamentsoin medicamentSoin){

		em.getTransaction().begin();
		em.persist(medicamentSoin);
		em.getTransaction().commit();
		return medicamentSoin;
	}

	public Medicamentsoin updateMedicamentSoin (Medicamentsoin medicamentSoin){

		Medicamentsoin medicamentSoinUpdate = em.find(Medicamentsoin.class, medicamentSoin.getMedicamentSoinsID());
		em.getTransaction().begin();
		em.merge(medicamentSoin);
		medicamentSoin.getPosologie();
		em.getTransaction().commit();
		return medicamentSoinUpdate;

	}


	public Medicamentsoin findMedicamentSoinByID (int MedicamentSoinID){
		try {
			return (Medicamentsoin) em.createNamedQuery("MedicamentSoin.findMedicamentSoinByID").setParameter("MedicamentSoinID", MedicamentSoinID).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}



	public  List<Medicamentsoin> findMedicamentSoinBySoin (Soin soin){
		try {
			TypedQuery<Medicamentsoin> query = em.createNamedQuery("Medicamentsoin.findMedicamentSoinBySoinID", Medicamentsoin.class)
					.setParameter("soin", soin);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}


	}
}
