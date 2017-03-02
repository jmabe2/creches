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
	
	public Local createLocal(String section, boolean actif, Typelocal typeLocal ) 
	{
		Local local = new Local();
		local.setSection(section);
		local.setActif(actif);
		local.setTypelocal(typeLocal);
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
	public Local updateLocal (int localID,String section, boolean actif, Typelocal typeLocal ) 
	{
		Local local = em.find(Local.class, localID);
		local.setSection(section);
		local.setActif(actif);
		local.setTypelocal(typeLocal);
		return local;
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

