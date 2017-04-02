package com.creche.services;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import com.creche.model.Contactenfant;
import com.creche.model.Enfant;
import com.creche.connection.EMF;

public class ContactEnfantService implements Serializable {

	private static final long serialVersionUID = 1L;
	protected static EntityManager em;

	public ContactEnfantService (){
		ContactEnfantService.em = EMF.getEM();

	}

	public Contactenfant createContactEnfant(Contactenfant contactEnfant){

		em.getTransaction().begin();
		em.persist(contactEnfant);
		em.getTransaction().commit();
		return contactEnfant;
	}

	public Contactenfant updateContactEnfant (Contactenfant contactEnfant){

		Contactenfant contactEnfantUpdate = em.find(Contactenfant.class, contactEnfant.getContactEnfantID());
		em.getTransaction().begin();
		em.merge(contactEnfant);
		contactEnfant.getTuteur();
		contactEnfant.getNatureRelation();
		contactEnfant.getLienParente();
		em.getTransaction().commit();
		return contactEnfantUpdate;

	}


	public Contactenfant findContactEnfantByID (int ContactEnfantID){
		try {
			return (Contactenfant) em.createNamedQuery("Contact.findContactEnfantByID").setParameter("ContactEnfantID", ContactEnfantID).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}


	public List <Contactenfant> findAllContactEnfant (){
		try {
			TypedQuery<Contactenfant> query = em.createNamedQuery("Contactenfant.findAll", Contactenfant.class);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public  List<Contactenfant> findContactEnfantByEnfant (Enfant enfant){
		try {
			TypedQuery<Contactenfant> query = em.createNamedQuery("Contact.findContactEnfantBycontactID", Contactenfant.class)
					.setParameter("enfant", enfant);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}


	}
}
