package com.creche.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import com.creche.model.Personnel;
import com.creche.services.PersonnelService;

@Named
public class PersonnelConverter implements Converter{

		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
	        if(submittedValue == null || submittedValue.isEmpty()) {
	            return null;
	        }
			try {
				PersonnelService sService = new PersonnelService();
				return sService.findPersonnelByID(Integer.parseInt(submittedValue));	
		    } catch (NumberFormatException e) {
		        throw new ConverterException(new FacesMessage(String.format("%s is not a valid Personnel ID", submittedValue)), e);
		    }
		}	
		

	    @Override
	    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
	        if (modelValue == null) {
	            return "";
	        }

	        if (modelValue instanceof Personnel) {
	            return String.valueOf(((Personnel) modelValue).getPersonnelID());
	        } else {
	            throw new ConverterException(new FacesMessage(String.format("%s is not a valid personnel", modelValue)));
	        }
	    }



	}

	
