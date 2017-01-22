package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the enfantsection database table.
 * 
 */
@Embeddable
public class EnfantsectionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int enfantID;

	@Column(insertable=false, updatable=false)
	private int sectionID;

	public EnfantsectionPK() {
	}
	public int getEnfantID() {
		return this.enfantID;
	}
	public void setEnfantID(int enfantID) {
		this.enfantID = enfantID;
	}
	public int getSectionID() {
		return this.sectionID;
	}
	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EnfantsectionPK)) {
			return false;
		}
		EnfantsectionPK castOther = (EnfantsectionPK)other;
		return 
			(this.enfantID == castOther.enfantID)
			&& (this.sectionID == castOther.sectionID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.enfantID;
		hash = hash * prime + this.sectionID;
		
		return hash;
	}
}