package com.creche.services;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.creche.connection.EMF;
import com.creche.model.Personnel;
import com.creche.model.Role;

public class PersonnelService implements Serializable {
	private static final long serialVersionUID = 1L;
	protected EntityManager em;
		
	/**
	 * 
	 * @param em (EntityManager)
	 */
	public PersonnelService() {
		 this.em = EMF.getEM();
	}

	/**
	 * Method to create a new personnel
	 */
	
	public Personnel createPersonnel(Personnel personnel){
		
		em.getTransaction().begin();
		em.persist(personnel);
		em.getTransaction().commit();
		return personnel;
	}
	
	/**
	 * Method to update a personnel

	 * @param personnelID
	 * @return
	 */
	public Personnel updatePersonnel (Personnel personnel){
	    
		Personnel personnelUpdate = em.find(Personnel.class, personnel.getPersonnelID());
		em.getTransaction().begin();
		em.merge(personnel);
		personnel.setNom(personnel.getNom());
		personnel.setPrenom(personnel.getPrenom());
		personnel.setDdn(personnel.getDdn());
		personnel.setSexe(personnel.getSexe());
		personnel.setLogin(personnel.getLogin());
		personnel.setMdp(personnel.getMdp());
		personnel.setActif(personnel.getActif());
		personnel.setRole(personnel.getRole());
		em.getTransaction().commit();
		return personnelUpdate;
	}
	
	public Role updateRole (Role role){
		   
		Role roleUpdate = em.find(Role.class, role.getRoleID());
		em.getTransaction().begin();
		em.merge(role);
		role.setNom(role.getNom());
		role.setActif(role.getActif());
		em.getTransaction().commit();
		return roleUpdate;
		
	}
	
	/**
	 *  Method to find a personnel by ID
	 * @param personnelID
	 * @return
	 */
	
	public Personnel findPersonnelByID(int personnelID){
	    try {
	        return (Personnel) em.createNamedQuery("Personnel.findPersonnelByID").setParameter("personnelID", personnelID)
	            .getSingleResult();
	      } catch (NoResultException e) {
	        return null;
	      }
	    }
	
	/**
	 *  Method to remove a personnel
	 * @param personnelID
	 */
	
	public void RemovePersonnel(int personnelID){
		
		Personnel personnel=findPersonnelByID(personnelID);
		if (personnel!=null){
			em.remove(personnel);
		}
	}
	
	/**
	 *  Method to list a personnel
	 * @return
	 */
	public List<Personnel> findAllPersonnel (){
	    try {
	        TypedQuery<Personnel> query = em.createNamedQuery("Personnel.findAllContact", Personnel.class);
	        return query.getResultList();
	      } catch (NoResultException e) {
	        return null;
	      }
	}
	
	/**
	 *  Method to log a personnel
	 * @return
	 */
	public Personnel loginPersonnel (String login, String mdp){
		try {
	        return (Personnel) em.createNamedQuery("Personnel.findContactLogin").setParameter("login", login).setParameter("mdp", mdp)
	            .getSingleResult();
	      } catch (NoResultException e) {
	        return null;
	      }
	}
}


