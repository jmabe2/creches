package com.creche.services;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.creche.model.Typelocal;
import com.creche.connection.EMF;



public class TypeLocalService implements Serializable {
	private static final long serialVersionUID = 1L;
	protected EntityManager em;
		
	/**
	 * 
	 * @param em (EntityManager)
	 */
	public TypeLocalService() {
		 this.em = EMF.getEM();
	}

	/**
	 * Method to create a new typeLocal
	 * @return
	 */
	
	public Typelocal createLocal(Typelocal typeLocal ) 
	{
		em.getTransaction().begin();
		em.persist(typeLocal);
		em.getTransaction().commit();
		return typeLocal;
	}
	
	/**
	 * Method to update a typeLocal

	 * @return
	 */
	/*public Local updateLocal (int localID,String section, boolean actif, Typelocal typeLocal ) 
	{
		Local local = em.find(Local.class, localID);
		local.setSection(section);
		local.setActif(actif);
		local.setTypelocal(typeLocal);
		return local;
	}*/
	
	/**
	 *  Method to find a typeLocal by ID
	 * @param localID
	 * @param section
	 * @param actif	
	 * @param typeLocalID
	 * @return
	 */
	
	public Typelocal findTypeLocalByID(int typeLocalID){
	    try {
	        return (Typelocal) em.createNamedQuery("Typelocal.findTypeLocalByID").setParameter("typelocalID", typeLocalID)
	            .getSingleResult();
	      } catch (NoResultException e) {
	        return null;
	      }
	    }
	
	/**
	 *  Method to remove a TypeLocal
	 * @param localID
	 */
	
	public void removeLocal(int typeLocalID){
		
		Typelocal typeLocal=findTypeLocalByID(typeLocalID);
		if (typeLocal!=null){
			em.remove(typeLocal);
		}
	}
	
	/**
	 *  Method to list a contact
	 * @return
	 */
	public List<Typelocal> findAllTypeLocal (){
	    try {
	        TypedQuery<Typelocal> query = em.createNamedQuery("Typelocal.findAllTypeLocal", Typelocal.class);
	        return query.getResultList();
	      } catch (NoResultException e) {
	        return null;
	      }
	}	
}

