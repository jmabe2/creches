package com.creche.services;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.creche.model.Local;
import com.creche.model.Localmateriel;
import com.creche.connection.EMF;



public class LocalMaterielService implements Serializable {
	private static final long serialVersionUID = 1L;
	protected static EntityManager em;

	/**
	 * 
	 * @param em (EntityManager)
	 */
	public LocalMaterielService() {
		LocalMaterielService.em = EMF.getEM();
	}

	/**
	 * Method to create a new localMateriel
	 * @return
	 */

	public static Localmateriel createLocalMateriel(Localmateriel localMateriel ) 
	{
		em.getTransaction().begin();
		em.persist(localMateriel);
		em.getTransaction().commit();
		return localMateriel;
	}

	/**
	 * Method to update a localMateriel
	 * @return
	 */
	public static Localmateriel updateLocalMateriel (Localmateriel localMateriel ) 
	{
		Localmateriel localMaterielToUpdate = em.find(Localmateriel.class, localMateriel.getLocalMaterielID());
		em.getTransaction().begin();
		localMaterielToUpdate.setLocal(localMateriel.getLocal());
		localMaterielToUpdate.setMateriel(localMateriel.getMateriel());
		em.getTransaction().commit();
		return localMaterielToUpdate;
	}

	/**
	 *  Method to find a localMateriel by id 
	 * @return
	 */

	public static Localmateriel findLocalMaterielByID(int localMaterielID){
		try {
			return (Localmateriel) em.createNamedQuery("Local.findLocalMaterielByID").setParameter("localMaterielID", localMaterielID)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	/**
	 *  Method to remove a local
	 * @param localID
	 */

	public static void removeLocalMateriel(Localmateriel lM){
		if (findLocalMaterielByID(lM.getLocalMaterielID())!=null){
			em.remove(lM);
		}
	}

	/**
	 *  Method to list a contact
	 * @return
	 */
	public  List<Localmateriel> findAllLocalMateriel (){
		try {
			TypedQuery<Localmateriel> query = em.createNamedQuery("Local.findAllLocalMateriel", Localmateriel.class);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}

	public  List<Localmateriel> findAllMaterielForALocal (Local local){
		try {
			TypedQuery<Localmateriel> query = em.createNamedQuery("Local.findLocalMaterielByLocalID", Localmateriel.class)
					.setParameter("local", local);
			return query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
}

