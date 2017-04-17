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
	private Role role;
	private Role roleUpdate;


	public RoleController(){

	}

	public String fillRole () {
		RoleService rService = new RoleService();
		rService.createRole(role);
		clear();
		return "listingRole";
	}

	public String updateRole(){
		RoleService rService = new RoleService();
		role= rService.updateRole(roleUpdate);
		clear();
		return "listingRole";
	}

	/*public static boolean checkRole(Role role, List<Role> listRole) {
		return (listRole != null) && (listRole.contains(role.getNom()));
	}*/

	public void loadRole(){
		RoleService rService = new RoleService();
		listRole = rService.findAllRules();
	}
	
	public void loadRole(boolean actif){
		RoleService rService = new RoleService();
		listRole = rService.findAllRules(actif);
	}
	

	public void clear(){
		setRole(null);
	}

	@PostConstruct
	public void init(){
		role = new Role();

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
	public Role getRoleUpdate() {
		return roleUpdate;
	}
	public void setRoleUpdate(Role roleUpate) {
		this.roleUpdate = roleUpate;
	}


}




