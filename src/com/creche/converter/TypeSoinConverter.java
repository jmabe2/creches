package com.creche.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import com.creche.model.Typesoin;
import com.creche.services.TypeSoinService;

@Named
public class TypeSoinConverter implements Converter{

		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
	        if(submittedValue == null || submittedValue.isEmpty()) {
	            return null;
	        }
			try {
				TypeSoinService tsService = new TypeSoinService();
				return tsService.findTypeSoinByID(Integer.parseInt(submittedValue));	
		    } catch (NumberFormatException e) {
		        throw new ConverterException(new FacesMessage(String.format("%s is not a valid TypeSoin ID", submittedValue)), e);
		    }
		}	
		

	    @Override
	    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
	        if (modelValue == null) {
	            return "";
	        }

	        if (modelValue instanceof Typesoin) {
	            return String.valueOf(((Typesoin) modelValue).getTypeSoinsID());
	        } else {
	            throw new ConverterException(new FacesMessage(String.format("%s is not a valid type soin", modelValue)));
	        }
	    }



	}

	
