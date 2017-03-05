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

    @Inject
    private TypeLocalService typeLocalService;

    public Object getAsObject(FacesContext context, UIComponent component, int typeLocalID) {
        if(typeLocalID == 0 ) {
            return null;
        }
        Typelocal typeLocal = typeLocalService.findTypeLocalByID(typeLocalID);
        if(typeLocal == null) {
            throw new ConverterException(new FacesMessage("Employee with number: " + typeLocalID + " not found."));
        }
        return typeLocal;
    }

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}




}
