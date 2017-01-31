package com.creche.services;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.creche.model.Contact;


public class ContactService implements Serializable {
	private static final long serialVersionUID = 1L;
	protected EntityManager em;
	
	/*public Map<String, String> validate(HttpServletRequest request) {
		Map<String, String> erreurs = new HashMap<String, String>();

		if (Utils.fieldEmpty(request.getParameter("nom"))) {
			erreurs.put( "nom", "Veuillez entrer un nom" );
		}
		
		if (Utils.fieldEmpty(request.getParameter("prenom"))) {
			erreurs.put( "prenom", "Veuillez entrer un prénom" );
		}
		return erreurs;
	}*/
	
	/**
	 * 
	 * @param em (EntityManager)
	 */
	public ContactService(EntityManager em) {
		this.em=em;
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
	
	public Contact createContact(String nom, String prenom, int niss, String rue, int numero, int codePostal, String localite, int telephone, int gsm, boolean actif ) 
	{
		Contact contact = new Contact();
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
		em.persist(contact);
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
	 *  Method to remove a chambre
	 * @param idchambre
	 */
	
	public void RemoveContact(int contactID){
		
		Contact contact=findContactByID(contactID);
		if (contact!=null){
			em.remove(contact);
		}
	}
	
	/**
	 *  Method to list a chambre
	 * @return
	 */
	public List<Contact> findAllContact (){
	    try {
	        TypedQuery<Contact> query = em.createNamedQuery("Contact.findAllContact", Contact.class);
	        List<Contact> results = query.getResultList();	
	        return results;
	      } catch (NoResultException e) {
	        return null;
	      }
	}
	
}

