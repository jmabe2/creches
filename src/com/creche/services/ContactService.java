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
		Contact contactUpdate = em.find(Contact.class, contact.getContactID());
		em.getTransaction().begin();
		em.merge(contact);
		contact.setNom(contact.getNom());
		contact.setPrenom(contact.getPrenom());
		contact.setNiss(contact.getNiss());
		contact.setRue(contact.getRue());
		contact.setNumero(contact.getNumero());
		contact.setCodePostal(contact.getCodePostal());
		contact.setLocalite(contact.getLocalite());
		contact.setTelephone(contact.getTelephone());
		contact.setGsm(contact.getGsm());
		contact.setActif(contact.getActif());
		em.getTransaction().commit();
		return contactUpdate;
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
	
	public List<Contact> findAllContact (boolean actif){
	    try {
	        TypedQuery<Contact> query = em.createNamedQuery("Contact.findAllActive", Contact.class).setParameter("actif", actif);
	        return query.getResultList();
	        
	      }
	    
	    catch (NoResultException e) 
	    {
	        return null;
	      }
	}

	
}

