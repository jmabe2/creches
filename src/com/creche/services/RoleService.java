package com.creche.services;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import com.creche.connection.EMF;
import com.creche.model.Role;

public class RoleService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected EntityManager em;

	/**
	 * 
	 * @param em (EntityManager)
	 */
	
	public RoleService (){
		this.em=EMF.getEM();
	}
	
	/**
	 *  Method to create a role
	 * @param roleID
	 */
	
	public Role createRole (Role role){

		em.getTransaction().begin();
		em.persist(role);
		em.getTransaction().commit();
		return role;
		
	}
	

	/**
	 *  Method to update a role
	 * @param roleID
	 */
	
	public Role updateRole (int roleID, Role role){
	   
		em.find(Role.class, roleID);
		em.getTransaction().begin();
		em.persist(role);
		em.getTransaction().commit();
		return role;
		
	}
	
	/**
	 *  Method to find a role
	 * @param roleID
	 */
	
	public Role findRoleByID (int roleID){
		try {
	        return (Role) em.createNamedQuery("Role.findRoleByID").setParameter("roleID", roleID).getSingleResult();
	      } catch (NoResultException e) {
	        return null;
	      }
		
	}
	
	/**
	 *  Method to remove a role
	 * @param roleID
	 */
	
	public void RemoveRole(int rolelID){
			
			Role role =findRoleByID(rolelID);
			if (role!=null){
				em.remove(role);
			}
		}
	
	/**
	 *  Method to list rules
	 * @return
	 */
	
	public List<Role> findAllRules (){
	    try {
	        TypedQuery<Role> query = em.createNamedQuery("Role.findAll", Role.class);
	        return query.getResultList();
	      } catch (NoResultException e) {
	        return null;
	      }
	}
	
}
