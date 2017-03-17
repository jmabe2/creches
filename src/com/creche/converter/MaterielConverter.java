package com.creche.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import com.creche.model.Materiel;
import com.creche.services.MaterielService;

@Named
public class MaterielConverter implements Converter {


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if(submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
		try {
			return MaterielService.findMaterielByID(Integer.parseInt(submittedValue));	
	    } catch (NumberFormatException e) {
	        throw new ConverterException(new FacesMessage(String.format("%s is not a valid Material ID", submittedValue)), e);
	    }
	}	
	

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Materiel) {
            return String.valueOf(((Materiel) modelValue).getMaterielID());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Materiel", modelValue)));
        }
    }



}

	