package com.creche.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.creche.services.RoleService;


@ManagedBean
@SessionScoped

public class ValidatorRole implements Validator  {

	@EJB
	private String name;
	private Pattern pattern;
	private Matcher matcher;

	private static final String ROLE_PATTERN ="[A-Za-z]";

	public ValidatorRole(){
		setPattern(Pattern.compile(ROLE_PATTERN));

	}

	public void validate(FacesContext context, UIComponent component, Object submittedValue) throws ValidatorException {

		matcher = pattern.matcher(submittedValue.toString());

		String name = (String)submittedValue;

		if (RoleService.findRoleByName(name) == null) 
		{

			if (!matcher.matches()){

				throw new ValidatorException( new FacesMessage("Fomat not accepted, please use only A-Z-a-z"));

			}
			return;

		}

		else {
			throw new ValidatorException(new FacesMessage("Role already in use, choose another"));

		}

	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public Matcher getMatcher() {
		return matcher;
	}

	public void setMatcher(Matcher matcher) {
		this.matcher = matcher;
	}

	public static String getRolePattern() {
		return ROLE_PATTERN;
	}


}













