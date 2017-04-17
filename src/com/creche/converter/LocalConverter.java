package com.creche.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import com.creche.model.Local;
import com.creche.services.LocalService;

@Named
public class LocalConverter implements Converter {


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if(submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
		try {
			return LocalService.findLocalByID(Integer.parseInt(submittedValue));	
	    } catch (NumberFormatException e) {
	        throw new ConverterException(new FacesMessage(String.format("%s is not a valid User ID", submittedValue)), e);
	    }
	}	
	

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Local) {
            return String.valueOf(((Local) modelValue).getLocalID());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid TypeLocal", modelValue)));
        }
    }



}

	