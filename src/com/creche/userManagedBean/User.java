package com.creche.userManagedBean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

import org.apache.log4j.Logger;

@Named
@SessionScoped

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	static Logger log = Logger.getLogger(User.class);

	private String name;
	private String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}