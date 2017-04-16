package com.creche.services;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import com.creche.model.Typesoin;
import com.creche.connection.EMF;

public class TypeSoinService implements Serializable {

	private static final long serialVersionUID = 1L;
	protected static EntityManager em;

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


	public Typesoin findTypeSoinByID (int TypeSoinID){
		try {
			return (Typesoin) em.createNamedQuery("Typesoin.findTypeSoinByID").setParameter("TypeSoinID", TypeSoinID).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}



	
}
