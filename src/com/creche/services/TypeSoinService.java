package com.creche.services;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.apache.log4j.Logger;

import com.creche.model.Contact;
import com.creche.model.Local;
import com.creche.model.Typesoin;
import com.creche.connection.EMF;
import com.creche.controller.EnfantMedicamentController;

public class TypeSoinService implements Serializable {

	private static final long serialVersionUID = 1L;
	protected static EntityManager em;
	static Logger log = Logger.getLogger(TypeSoinService.class);

	public TypeSoinService (){
		TypeSoinService.em = EMF.getEM();

	}

	public Typesoin createTypeSoin(Typesoin typeSoin){

		em.getTransaction().begin();
		em.persist(typeSoin);
		em.getTransaction().commit();
		return typeSoin;
	}

	public Typesoin updateTypeSoin (Typesoin typeSoin){

		Typesoin enfantMedicamentUpdate = em.find(Typesoin.class, typeSoin.getTypeSoinsID());
		em.getTransaction().begin();
		em.merge(typeSoin);
		em.getTransaction().commit();
		return enfantMedicamentUpdate;

	}
	

	public Typesoin findTypeSoinByID (Integer TypeSoinID){
		try {
			return (Typesoin) em.createNamedQuery("Typesoin.findTypeSoinByID").setParameter("TypeSoinID", TypeSoinID).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}
	
	public  List<Typesoin> findAllTypeSoin (){
		try {
			TypedQuery<Typesoin> query = em.createNamedQuery("Typesoin.findAll", Typesoin.class);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}



	
}
