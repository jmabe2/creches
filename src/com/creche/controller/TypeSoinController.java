package com.creche.controller;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.log4j.Logger;
import com.creche.model.Typesoin;
import com.creche.services.TypeSoinService;

@Named
@SessionScoped
public class TypeSoinController implements Serializable{

	private static final long serialVersionUID = 1L;
	private List <Typesoin> listTypeSoin;
	static Logger log = Logger.getLogger(TypeSoinController.class);
	private Typesoin typeSoin;
	private TypeSoinService typeSoinServ;

	public TypeSoinController (){

	}
	
	@PostConstruct
	public void init(){

		typeSoin = new Typesoin();
	}


	public String fillTypeSoin(){
		typeSoinServ = new TypeSoinService();
		typeSoinServ.createTypeSoin(typeSoin);
			
		return "listingTypeSoin";
	} 

	public String updateTypeSoin(){
		typeSoinServ = new TypeSoinService();
		typeSoinServ.updateTypeSoin(typeSoin);
		return "listingTypeSoin";
	}

	public Typesoin getTypeSoin() {
		return typeSoin;
	}
	public void setTypeSoin(Typesoin typeSoin) {
		this.typeSoin = typeSoin;
	}
	
	public List <Typesoin> getListTypeSoin() {
		return listTypeSoin;
	}

	public void setListTypeSoin(List <Typesoin> listTypeSoin) {
		this.listTypeSoin = listTypeSoin;
	}



}
