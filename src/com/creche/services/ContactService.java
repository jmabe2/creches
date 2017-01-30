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

	 * @param idChambre
	 * @param numeroChambre
	 * @param type
	 * @return
	 */
	public Chambre updateChambre(int idChambre,int numeroChambre, Typechambre type) 
	{
		Chambre chambre = em.find(Chambre.class, idChambre);
		chambre.setNumeroChambre(numeroChambre);
		chambre.setTypechambre(type);
		return chambre;
	}
	
	/**
	 *  Method to find a contact
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
	
	public Contact findChambre(int idchambre){
		return em.find(Chambre.class, idchambre);
	}
	
	/**
	 *  Method to remove a chambre
	 * @param idchambre
	 */
	
	public void RemoveChambre(int idchambre){
		
		Chambre chambre=findChambre(idchambre);
		if (chambre!=null){
			em.remove(chambre);
		}
	}
	
	/**
	 *  Method to list a chambre
	 * @return
	 */
	public List<Chambre> findAllChambre (){
		
		TypedQuery<Chambre> query = em.createQuery("SELECT chambre from Chambre chambre", Chambre.class);
		return query.getResultList();
	
	}
	
	/**
	 *  Method to find by number a chambre
	 * @param numChambre
	 * @return
	 */
	public Chambre findByNum (int numChambre){
		
		TypedQuery<Chambre> query = em.createQuery("SELECT chambre from Chambre chambre where chambre.numeroChambre=:numchambre", Chambre.class);
		query.setParameter("numchambre", numChambre);
		return query.getSingleResult();
	
	}

}

