package com.creche.services;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.creche.model.Local;
import com.creche.model.Typelocal;
import com.creche.connection.EMF;



public class LocalService implements Serializable {
	private static final long serialVersionUID = 1L;
	protected EntityManager em;
		
	/**
	 * 
	 * @param em (EntityManager)
	 */
	public LocalService() {
		 this.em = EMF.getEM();
	}

	/**
	 * Method to create a new local

	 * @param localID
	 * @param section
	 * @param actif	
	 * @param typeLocalID
	 * @return
	 */
	
	public Local createLocal(Local local ) 
	{
		em.getTransaction().begin();
		em.persist(local);
		em.getTransaction().commit();
		return local;
	}
	
	/**
	 * Method to update a local

	 * @param localID
	 * @param section
	 * @param actif	
	 * @param typeLocalID
	 * @return
	 */
	public Local updateLocal (Local local ) 
	{
		Local localToUpdate = em.find(Local.class, local.getLocalID());
		em.getTransaction().begin();
		localToUpdate.setSection(local.getSection());
		localToUpdate.setActif(local.getActif());
		localToUpdate.setTypelocal(local.getTypelocal());
		em.getTransaction().commit();
		return localToUpdate;
	}
	
	/**
	 *  Method to find a local by ID
	 * @param localID
	 * @param section
	 * @param actif	
	 * @param typeLocalID
	 * @return
	 */
	
	public Local findLocalByID(int localID){
	    try {
	        return (Local) em.createNamedQuery("Local.findLocalByID").setParameter("localID", localID)
	            .getSingleResult();
	      } catch (NoResultException e) {
	        return null;
	      }
	    }
	
	/**
	 *  Method to remove a local
	 * @param localID
	 */
	
	public void removeLocal(int localID){
		
		Local local=findLocalByID(localID);
		if (local!=null){
			em.remove(local);
		}
	}
	
	/**
	 *  Method to list a contact
	 * @return
	 */
	public List<Local> findAllLocal (){
	    try {
	        TypedQuery<Local> query = em.createNamedQuery("Local.findAllLocal", Local.class);
	        return query.getResultList();
	      } catch (NoResultException e) {
	        return null;
	      }
	}	
}

