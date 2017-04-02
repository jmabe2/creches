package com.creche.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;

import com.creche.model.Role;
import com.creche.services.RoleService;

@Named
public class TypeRoleConverter implements Converter{


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
    	//System.out.print("if");

		if(submittedValue == null || submittedValue.isEmpty()) {
        	//System.out.print("if");
            return null;
        }
		try {
			//System.out.print("if dd");
			RoleService rService = new RoleService();
	        return rService.findRoleByID((Integer.parseInt(submittedValue)));	
	    } catch (NumberFormatException e) {
	        throw new ConverterException(new FacesMessage(String.format("%s is not a valid User ID", submittedValue)), e);
	    }
	}	
	

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof Role) {
            return String.valueOf(((Role) modelValue).getRoleID());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid TypeRole", modelValue)));
        }
    }
    



}
