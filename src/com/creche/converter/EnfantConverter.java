package com.creche.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import com.creche.model.Enfant;
import com.creche.services.EnfantService;

@Named
public class EnfantConverter implements Converter{
	
			@Override
			public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {

				if(submittedValue == null || submittedValue.isEmpty()) {

		            return null;
		        }
				try {
					EnfantService eService = new EnfantService();
					return eService.findEnfantByID(Integer.parseInt(submittedValue));	
			    } catch (NumberFormatException e) {
			        throw new ConverterException(new FacesMessage(String.format("%s is not a valid Enfant ID", submittedValue)), e);
			    }
			}	
			

		    @Override
		    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
		        if (modelValue == null) {
		            return "";
		        }

		        if (modelValue instanceof Enfant) {
		            return String.valueOf(((Enfant) modelValue).getEnfantID());
		        } else {
		            throw new ConverterException(new FacesMessage(String.format("%s is not a valid enfant", modelValue)));
		        }
		    }



		}
