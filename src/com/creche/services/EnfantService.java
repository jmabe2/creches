package com.creche.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.creche.connection.EMF;
import com.creche.model.Enfant;

public class EnfantService {
	
	private static final long serialVersionUID = 1L;
	protected EntityManager em;
	
		
	/**
	 * 
	 * @param em (EntityManager)
	 */
	public EnfantService() {
		 this.em = EMF.getEM();
	}

	/**
	 * Method to create a new contact
	 */
	
	public Enfant createEnfant(Enfant enfant) 
	{
		em.getTransaction().begin();
		em.persist(enfant);
		em.getTransaction().commit();
		return enfant;
	}
	
	/**
	 * Method to update an
	 */
	public Enfant updateEnfant (Enfant enfant){
		Enfant enfantUpdate = em.find(Enfant.class, enfant.getEnfantID());
		em.getTransaction().begin();
		em.merge(enfant);
		enfant.setNom(enfant.getNom());
		enfant.setPrenom(enfant.getPrenom());
		enfant.setDdn(enfant.getDdn());
		enfant.setActif(enfant.getActif());
		em.getTransaction().commit();
		return enfantUpdate;
	}
	
	/**
	 *  Method to find a contact by ID
	 * @param contactID
	 */
	
	public Enfant findEnfantByID(Integer enfantID){
	    try {
	        return (Enfant) em.createNamedQuery("Enfant.findEnfantByID").setParameter("enfantID", enfantID)
	            .getSingleResult();
	      } catch (NoResultException e) {
	        return null;
	      }
	    }
	
	/**
	 *  Method to remove a contact
	 * @param contactID
	 */
	
	public void removeEnfant(Integer enfantID){
		
		Enfant enfant=findEnfantByID(enfantID);
		if (enfant!=null){
			em.remove(enfant);
		}
	}
	

	
	/**
	 *  Method to list all enfant
	 * @return
	 */
	public List<Enfant> findAllEnfant (){
	    try {
	        TypedQuery<Enfant> query = em.createNamedQuery("Enfant.findAll", Enfant.class);
	        return query.getResultList();
	        
	      }
	    
	    catch (NoResultException e) 
	    {
	        return null;
	      }
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
