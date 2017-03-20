package com.creche.validator;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.creche.controller.RoleController;
import com.creche.services.RoleService;


@ManagedBean
@SessionScoped

public class ValidatorRole implements Validator  {

	@EJB
	private RoleController rController;
	private String name;



	public void validate(FacesContext context, UIComponent component, Object submittedValue) throws ValidatorException {

		//RoleController rController = new RoleController();
		String name = (String)submittedValue;

		if (RoleService.findRoleByName(name) == null) 
		{
			return;
		}else{
			throw new ValidatorException(new FacesMessage("Role already in use, choose another"));
		}
	}

	/*
	public void validateName(FacesContext context,UIComponent component,Object value)throws ValidatorException
	{
		UIInput Input = (UIInput) component.getAttributes().get("nom");
	    String name=(String)Input.getValue();
		if (rController.exist(name))
		{
			throw new ValidatorException(new FacesMessage("Role already in use, choose another"));

		}


	}*/

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


}













