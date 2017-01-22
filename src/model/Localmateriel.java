package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the localmateriel database table.
 * 
 */
@Entity
@NamedQuery(name="Localmateriel.findAll", query="SELECT l FROM Localmateriel l")
public class Localmateriel implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LocalmaterielPK id;

	public Localmateriel() {
	}

	public LocalmaterielPK getId() {
		return this.id;
	}

	public void setId(LocalmaterielPK id) {
		this.id = id;
	}

}