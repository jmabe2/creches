package com.creche.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.creche.model.Personnel;
import com.creche.services.PersonnelService;


@Named
@SessionScoped
public class LoginController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String mdp;
	private Personnel personnel;

	
	public LoginController(){		
	}
	
	@PostConstruct
	public void init(){

	}
	

	//validate login
	public String checkLogin() {
		PersonnelService pService = new PersonnelService();
		personnel = pService.loginPersonnel(login,mdp);
		if (personnel!=null){
			return "welcome";
		}else{
			FacesContext.getCurrentInstance().addMessage("loginForm:password",
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct Password"));
			FacesContext.getCurrentInstance().addMessage("loginForm:username",
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username"));
			return "";
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Personnel getPersonnel() {
		return personnel;
	}

	public void setPersonnel(Personnel personnel) {
		this.personnel = personnel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	

	

}
