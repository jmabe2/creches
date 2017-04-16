package com.creche.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import com.creche.model.Medicament;
import com.creche.services.MedicamentService;

@Named
public class MedicamentConverter implements Converter{

		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
	        if(submittedValue == null || submittedValue.isEmpty()) {
	            return null;
	        }
			try {
				MedicamentService mService = new MedicamentService();
				return mService.findMedicamentByID(Integer.parseInt(submittedValue));	
		    } catch (NumberFormatException e) {
		        throw new ConverterException(new FacesMessage(String.format("%s is not a valid Medicament ID", submittedValue)), e);
		    }
		}	
		

	    @Override
	    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
	        if (modelValue == null) {
	            return "";
	        }

	        if (modelValue instanceof Medicament) {
	            return String.valueOf(((Medicament) modelValue).getMedicamentID());
	        } else {
	            throw new ConverterException(new FacesMessage(String.format("%s is not a valid medicament", modelValue)));
	        }
	    }



	}

	
