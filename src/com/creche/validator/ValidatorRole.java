package com.creche.validator;


import java.util.regex.Matcher;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.validation.constraints.Pattern;

import com.creche.controller.RoleController;


@ManagedBean
@SessionScoped

public class ValidatorRole implements Validator  {

	@EJB
	private RoleController rController;
	private String name;
	private Pattern pattern;
	private Matcher matcher;

	
	public void validate(FacesContext context, UIComponent component, Object submittedValue) throws ValidatorException {

		/*if (submittedValue == null) 
		{
			return;
		}*/
		rController.getRole();
	    UIInput Input = (UIInput) component.getAttributes().get("nom");
		String name = (String)Input.getValue();

		if (rController.exist(name)) {

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

	public Matcher getMatcher() {
		return matcher;
	}

	public void setMatcher(Matcher matcher) {
		this.matcher = matcher;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

}













