package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the enfantsection database table.
 * 
 */
@Entity
@NamedQuery(name="Enfantsection.findAll", query="SELECT e FROM Enfantsection e")
public class Enfantsection implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EnfantsectionPK id;

	private byte actif;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`Date arrivee`")
	private Date date_arrivee;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="`Date depart`")
	private Date date_depart;

	private String remarque;

	//bi-directional many-to-one association to Enfant
	@ManyToOne
	@JoinColumn(name="EnfantID")
	private Enfant enfant;

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="SectionID")
	private Section section;

	public Enfantsection() {
	}

	public EnfantsectionPK getId() {
		return this.id;
	}

	public void setId(EnfantsectionPK id) {
		this.id = id;
	}

	public byte getActif() {
		return this.actif;
	}

	public void setActif(byte actif) {
		this.actif = actif;
	}

	public Date getDate_arrivee() {
		return this.date_arrivee;
	}

	public void setDate_arrivee(Date date_arrivee) {
		this.date_arrivee = date_arrivee;
	}

	public Date getDate_depart() {
		return this.date_depart;
	}

	public void setDate_depart(Date date_depart) {
		this.date_depart = date_depart;
	}

	public String getRemarque() {
		return this.remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Enfant getEnfant() {
		return this.enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

}