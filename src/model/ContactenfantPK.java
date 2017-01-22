package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the contactenfant database table.
 * 
 */
@Embeddable
public class ContactenfantPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int contactID;

	@Column(insertable=false, updatable=false)
	private int enfantID;

	public ContactenfantPK() {
	}
	public int getContactID() {
		return this.contactID;
	}
	public void setContactID(int contactID) {
		this.contactID = contactID;
	}
	public int getEnfantID() {
		return this.enfantID;
	}
	public void setEnfantID(int enfantID) {
		this.enfantID = enfantID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ContactenfantPK)) {
			return false;
		}
		ContactenfantPK castOther = (ContactenfantPK)other;
		return 
			(this.contactID == castOther.contactID)
			&& (this.enfantID == castOther.enfantID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.contactID;
		hash = hash * prime + this.enfantID;
		
		return hash;
	}
}