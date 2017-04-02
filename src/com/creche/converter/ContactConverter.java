package com.creche.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import com.creche.model.Contact;
import com.creche.services.ContactService;

@Named
public class ContactConverter implements Converter{

		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
	        if(submittedValue == null || submittedValue.isEmpty()) {
	            return null;
	        }
			try {
				ContactService cService = new ContactService();
				return cService.findContactByID(Integer.parseInt(submittedValue));	
		    } catch (NumberFormatException e) {
		        throw new ConverterException(new FacesMessage(String.format("%s is not a valid Contact ID", submittedValue)), e);
		    }
		}	
		

	    @Override
	    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
	        if (modelValue == null) {
	            return "";
	        }

	        if (modelValue instanceof Contact) {
	            return String.valueOf(((Contact) modelValue).getContactID());
	        } else {
	            throw new ConverterException(new FacesMessage(String.format("%s is not a valid contact", modelValue)));
	        }
	    }



	}

	
