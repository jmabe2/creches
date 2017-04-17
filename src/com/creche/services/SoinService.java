package com.creche.services;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import com.creche.model.Soin;
import com.creche.model.Typesoin;
import com.creche.connection.EMF;

public class SoinService implements Serializable {

	private static final long serialVersionUID = 1L;
	protected static EntityManager em;

	public SoinService (){
		SoinService.em = EMF.getEM();

	}

	public Soin createSoin(Soin soin){

		em.getTransaction().begin();
		em.persist(soin);
		em.getTransaction().commit();
		return soin;
	}

	public Soin updateSoin (Soin soin){

		Soin enfantMedicamentUpdate = em.find(Soin.class, soin.getSoinsID());
		em.getTransaction().begin();
		em.merge(soin);
		em.getTransaction().commit();
		return enfantMedicamentUpdate;

	}


	public Soin findSoinByID (int SoinID){
		try {
			return (Soin) em.createNamedQuery("Soin.findSoinByID").setParameter("SoinID", SoinID).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	public  List<Soin> findAllSoin (){
		try {
			TypedQuery<Soin> query = em.createNamedQuery("Soin.findAll", Soin.class);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	
}
