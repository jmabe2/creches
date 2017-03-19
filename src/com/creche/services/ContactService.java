package com.creche.services;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.creche.model.Contact;
import com.creche.connection.EMF;



public class ContactService implements Serializable {
	private static final long serialVersionUID = 1L;
	protected EntityManager em;
	


		
	/**
	 * 
	 * @param em (EntityManager)
	 */
	public ContactService() {
		 this.em = EMF.getEM();
	}

	/**
	 * Method to create a new contact
	 */
	
	public Contact createContact(Contact contact) 
	{
		em.getTransaction().begin();
		em.persist(contact);
		em.getTransaction().commit();
		return contact;
	}
	
	/**
	 * Method to update a contact
	 */
	public Contact updateContact (Contact contact){
		em.find(Contact.class, contact);
		em.getTransaction().begin();
		em.merge(contact);
		em.getTransaction().commit();
		return contact;
	}
	
	public boolean updateActif (Integer contactID, boolean actif){
		em.find(Contact.class, contactID);
		em.getTransaction().begin();			
		em.persist(actif);
		em.getTransaction().commit();
		return actif;
	}
	
	/**
	 *  Method to find a contact by ID
	 * @param contactID
	 */
	
	public Contact findContactByID(Integer contactID){
	    try {
	        return (Contact) em.createNamedQuery("Contact.findContactByID").setParameter("contactID", contactID)
	            .getSingleResult();
	      } catch (NoResultException e) {
	        return null;
	      }
	    }
	
	/**
	 *  Method to remove a contact
	 * @param contactID
	 */
	
	public void removeContact(Integer contactID){
		
		Contact contact=findContactByID(contactID);
		if (contact!=null){
			em.remove(contact);
		}
	}
	

	
	/**
	 *  Method to list a contact
	 * @return
	 */
	public List<Contact> findAllContact (){
	    try {
	        TypedQuery<Contact> query = em.createNamedQuery("Contact.findAllContact", Contact.class);
	        return query.getResultList();
	        
	      }
	    
	    catch (NoResultException e) 
	    {
	        return null;
	      }
	}

	
}

