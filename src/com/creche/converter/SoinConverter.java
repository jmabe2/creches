package com.creche.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import com.creche.model.Soin;
import com.creche.services.SoinService;

@Named
public class SoinConverter implements Converter{

		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
	        if(submittedValue == null || submittedValue.isEmpty()) {
	            return null;
	        }
			try {
				SoinService sService = new SoinService();
				return sService.findSoinByID(Integer.parseInt(submittedValue));	
		    } catch (NumberFormatException e) {
		        throw new ConverterException(new FacesMessage(String.format("%s is not a valid Soin ID", submittedValue)), e);
		    }
		}	
		

	    @Override
	    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
	        if (modelValue == null) {
	            return "";
	        }

	        if (modelValue instanceof Soin) {
	            return String.valueOf(((Soin) modelValue).getSoinsID());
	        } else {
	            throw new ConverterException(new FacesMessage(String.format("%s is not a valid soin", modelValue)));
	        }
	    }



	}

	
