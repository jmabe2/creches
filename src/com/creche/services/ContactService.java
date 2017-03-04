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

	 * @param contactID
	 * @param actif
	 * @param codePostal
	 * @param gsm
	 * @param localite
	 * @param niss
	 * @param nom
	 * @param numero
	 * @param prenom
	 * @param rue
	 * @param telephone
	 * @return
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

	 * @param contactID
	 * @param actif
	 * @param codePostal
	 * @param gsm
	 * @param localite
	 * @param niss
	 * @param nom
	 * @param numero
	 * @param prenom
	 * @param rue
	 * @param telephone
	 * @return
	 */
	public Contact updateContact (int contactID, String nom, String prenom, int niss, String rue, int numero, int codePostal, String localite, int telephone, int gsm, boolean actif ) 
	{
		Contact contact = em.find(Contact.class, contactID);
		contact.setNom(nom);
		contact.setPrenom(prenom);
		contact.setNiss(niss);
		contact.setRue(rue);
		contact.setNumero(numero);
		contact.setCodePostal(codePostal);
		contact.setLocalite(localite);
		contact.setTelephone(telephone);
		contact.setGsm(gsm);
		contact.setActif(actif);
		return contact;
	}
	
	/**
	 *  Method to find a contact by ID
	 * @param contactID
	 * @param actif
	 * @param codePostal
	 * @param gsm
	 * @param localite
	 * @param niss
	 * @param nom
	 * @param numero
	 * @param prenom
	 * @param rue
	 * @param telephone
	 * @return
	 */
	
	public Contact findContactByID(int contactID){
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
	
	public void removeContact(int contactID){
		
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
	      } catch (NoResultException e) {
	        return null;
	      }
	}	
}

