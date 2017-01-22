package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the local database table.
 * 
 */
@Entity
@NamedQuery(name="Local.findAll", query="SELECT l FROM Local l")
public class Local implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LocalPK id;

	private byte actif;

	private String section;

	//bi-directional many-to-one association to Typelocal
	@ManyToOne
	@JoinColumn(name="TypeLocalID")
	private Typelocal typelocal;

	public Local() {
	}

	public LocalPK getId() {
		return this.id;
	}

	public void setId(LocalPK id) {
		this.id = id;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public String getSection() {
		return this.section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Typelocal getTypelocal() {
		return this.typelocal;
	}

	public void setTypelocal(Typelocal typelocal) {
		this.typelocal = typelocal;
	}

}