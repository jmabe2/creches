package com.creche.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import com.creche.model.Typelocal;
import com.creche.services.TypeLocalService;

@Named
public class TypeLocalConverter implements Converter {


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if(submittedValue == null || submittedValue.isEmpty()) {
        	System.out.print("if");
            return null;
        }
		try {
			return TypeLocalService.findTypeLocalByID(Integer.parseInt(submittedValue));	
	    } catch (NumberFormatException e) {
	        throw new ConverterException(new FacesMessage(String.format("%s is not a valid User ID", submittedValue)), e);
	    }
	}	
	

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Typelocal) {
            return String.valueOf(((Typelocal) modelValue).getTypeLocalID());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid TypeLocal", modelValue)));
        }
    }



}

	