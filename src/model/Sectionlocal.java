package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sectionlocal database table.
 * 
 */
@Entity
@NamedQuery(name="Sectionlocal.findAll", query="SELECT s FROM Sectionlocal s")
public class Sectionlocal implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SectionlocalPK id;

	public Sectionlocal() {
	}

	public SectionlocalPK getId() {
		return this.id;
	}

	public void setId(SectionlocalPK id) {
		this.id = id;
	}

}