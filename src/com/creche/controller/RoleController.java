package com.creche.controller;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.creche.model.Role;
import com.creche.services.RoleService;

@Named
@SessionScoped

public class RoleController implements Serializable{

	private static final long serialVersionUID = 1L;
	private List <Role> listRole;
	private Integer roleID;
	private Role role;


	public String fillRole () {
		RoleService rService = new RoleService();
		rService.createRole(role);
		return "listingRole";
	}

	public String updateRole(){
		RoleService rService = new RoleService();
		role= rService.updateRole(roleID, role);
		return "listingRole";
	}
	
	
	public void loadRole(){
		RoleService rService = new RoleService();
		listRole = rService.findAllRules();
	}
	
	public RoleController() {
	}

	@PostConstruct
	public void init(){
		role = new Role();

	}

	public int getRoleID() {
		return roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List <Role> getListRole() {
		return listRole;
	}

	public void setListRole(List <Role> listRole) {
		this.listRole = listRole;
	}


}
