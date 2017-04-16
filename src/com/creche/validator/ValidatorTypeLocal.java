package com.creche.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.creche.services.TypeLocalService;


@ManagedBean
@SessionScoped
public class ValidatorTypeLocal implements Validator  {


	private String name;
	private Pattern pattern;
	private Matcher matcher;

	private static final String ROLE_PATTERN ="[A-Za-z]";

	public ValidatorTypeLocal(){
		setPattern(Pattern.compile(ROLE_PATTERN));

	}

	public void validate(FacesContext context, UIComponent component, Object submittedValue) throws ValidatorException {

		matcher = pattern.matcher(submittedValue.toString());

		String name = (String)submittedValue;

		if (TypeLocalService.findTypeLocalByName(name) == null) 
		{
			return;
		}

		else {
			throw new ValidatorException(new FacesMessage("TypeLocal already in use, choose another"));

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

