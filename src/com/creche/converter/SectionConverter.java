package com.creche.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import com.creche.model.Section;
import com.creche.services.SectionService;

@Named
public class SectionConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {

		if(submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
		try {
			SectionService sService = new SectionService();
	        return sService.findSectionByID((Integer.parseInt(submittedValue)));	
	    } catch (NumberFormatException e) {
	        throw new ConverterException(new FacesMessage(String.format("%s is not a valid User ID", submittedValue)), e);
	    }
	}	
	

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Section) {
            return String.valueOf(((Section) modelValue).getSectionID());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid section", modelValue)));
        }
    }
    
}
