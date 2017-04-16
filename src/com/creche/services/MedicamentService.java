package com.creche.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.creche.connection.EMF;
import com.creche.model.Contact;
import com.creche.model.Medicament;
import com.creche.userManagedBean.User;

import org.apache.log4j.Logger;

public class MedicamentService {
	
	private static final long serialVersionUID = 1L;
	protected EntityManager em;
	static Logger log = Logger.getLogger(MedicamentService.class);
	
		
	/**
	 * 
	 * @param em (EntityManager)
	 */
	public MedicamentService() {
		 this.em = EMF.getEM();
	}

	/**
	 * Method to create a new contact
	 */
	
	public Medicament createMedicament(Medicament medicament) 
	{
		em.getTransaction().begin();
		em.persist(medicament);
		em.getTransaction().commit();
		return medicament;
	}
	
	/**
	 * Method to update an
	 */
	public Medicament updateMedicament (Medicament medicament){
		Medicament medicamentUpdate = em.find(Medicament.class, medicament.getMedicamentID());
		em.getTransaction().begin();
		em.merge(medicament);
		medicament.setNom(medicament.getNom());
		medicament.setActif(medicament.getActif());
		em.getTransaction().commit();
		return medicamentUpdate;
	}
	
	/**
	 *  Method to find a medicament by Name
	 * @param name
	 */
	
	public List<Medicament> findMedicamentByName(String name){
	    try {
	        return (List <Medicament>) em.createNamedQuery("Medicament.findMedicamentByName").setParameter("name","%"+name+"%").getResultList();
	      } catch (NoResultException e) {
	        return null;
	      }
	    }
	
	public Medicament findMedicamentByID(Integer medicamentID){
	    try {
	        return (Medicament) em.createNamedQuery("Medicament.findMedicamentByID").setParameter("medicamentID", medicamentID)
	            .getSingleResult();
	      } catch (NoResultException e) {
	        return null;
	      }
	    }
	

	
	/**
	 *  Method to list a contact
	 * @return
	 */
	public List<Medicament> findAllMedicament (){
	    try {
	        TypedQuery<Medicament> query = em.createNamedQuery("Medicament.findAll", Medicament.class);
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
