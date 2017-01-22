package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the local database table.
 * 
 */
@Embeddable
public class LocalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int localID;

	@Column(insertable=false, updatable=false)
	private int typeLocalID;

	public LocalPK() {
	}
	public int getLocalID() {
		return this.localID;
	}
	public void setLocalID(int localID) {
		this.localID = localID;
	}
	public int getTypeLocalID() {
		return this.typeLocalID;
	}
	public void setTypeLocalID(int typeLocalID) {
		this.typeLocalID = typeLocalID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof LocalPK)) {
			return false;
		}
		LocalPK castOther = (LocalPK)other;
		return 
			(this.localID == castOther.localID)
			&& (this.typeLocalID == castOther.typeLocalID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.localID;
		hash = hash * prime + this.typeLocalID;
		
		return hash;
	}
}