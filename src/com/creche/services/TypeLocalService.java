package com.creche.services;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.creche.model.Typelocal;
import com.creche.connection.EMF;



public class TypeLocalService implements Serializable {
	private static final long serialVersionUID = 1L;
	protected static EntityManager em;
		
	/**
	 * 
	 * @param em (EntityManager)
	 */
	public TypeLocalService() {
		 TypeLocalService.em = EMF.getEM();
	}

	/**
	 * Method to create a new typeLocal
	 * @return
	 */
	
	public static Typelocal createLocal(Typelocal typeLocal ) 
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
	public static Typelocal updateTypeLocal (Typelocal typeLocal ) 
	{
		Typelocal typeLocalToUpdate = em.find(Typelocal.class, typeLocal.getTypeLocalID());
		em.getTransaction().begin();
		typeLocalToUpdate.setNom(typeLocal.getNom());
		typeLocalToUpdate.setActif(typeLocal.getActif());
		em.getTransaction().commit();
		return typeLocalToUpdate;
	}
	
	/**
	 *  Method to find a typeLocal by ID
	 * @param localID
	 * @param section
	 * @param actif	
	 * @param typeLocalID
	 * @return
	 */
	
	public static Typelocal findTypeLocalByID(int typeLocalID){
	    try {
	        return (Typelocal) em.createNamedQuery("Typelocal.findTypeLocalByID").setParameter("typeLocalID", typeLocalID)
	            .getSingleResult();
	      } catch (NoResultException e) {
	    	  System.out.println("erreur");
	        return null;
	      }
	    }
	
	/**
	 *  Method to remove a TypeLocal
	 * @param localID
	 */
	
	public static void removeLocal(int typeLocalID){
		
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

