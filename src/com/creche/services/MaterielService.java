package com.creche.services;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.creche.model.Materiel;
import com.creche.connection.EMF;



public class MaterielService implements Serializable {
	private static final long serialVersionUID = 1L;
	protected EntityManager em;
		
	/**
	 * 
	 * @param em (EntityManager)
	 */
	public MaterielService() {
		 this.em = EMF.getEM();
	}

	/**
	 * Method to create a new materiel
	 * @return
	 */
	
	public Materiel createMateriel(Materiel materiel ) 
	{
		em.getTransaction().begin();
		em.persist(materiel);
		em.getTransaction().commit();
		return materiel;
	}
	
	/**
	 * Method to update a materiel

	 * @return
	 */
	public Materiel updateMateriel (Materiel materiel ) 
	{
		Materiel materielToUpdate = em.find(Materiel.class, materiel.getMaterielID());
		em.getTransaction().begin();
		materielToUpdate.setNom(materiel.getNom());
		materielToUpdate.setPropriete(materiel.getPropriete());
		materielToUpdate.setActif(materiel.getActif());
		em.getTransaction().commit();
		return materielToUpdate;
	}
	
	/**
	 *  Method to find materiel by ID
	 * @return
	 */
	
	public Materiel findMaterielByID(int materielID){
	    try {
	        return (Materiel) em.createNamedQuery("Materiel.findMaterielByID").setParameter("materielID", materielID)
	            .getSingleResult();
	      } catch (NoResultException e) {
	    	  System.out.println("erreur");
	        return null;
	      }
	    }
	
	/**
	 *  Method to remove a materiel
	 * @param localID
	 */
	
	/*public void removeLocal(int typeLocalID){
		
		Typelocal typeLocal=findTypeLocalByID(typeLocalID);
		if (typeLocal!=null){
			em.remove(typeLocal);
		}
	}*/
	
	/**
	 *  Method to list a materiel
	 * @return
	 */
	public List<Materiel> findAllMateriel (){
	    try {
	        TypedQuery<Materiel> query = em.createNamedQuery("Materiel.findAll", Materiel.class);
	        return query.getResultList();
	      } catch (NoResultException e) {
	        return null;
	      }
	}	
}


