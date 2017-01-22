package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the soinsenfant database table.
 * 
 */
@Embeddable
public class SoinsenfantPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int soinsID;

	@Column(insertable=false, updatable=false)
	private int enfantID;

	public SoinsenfantPK() {
	}
	public int getSoinsID() {
		return this.soinsID;
	}
	public void setSoinsID(int soinsID) {
		this.soinsID = soinsID;
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
		if (!(other instanceof SoinsenfantPK)) {
			return false;
		}
		SoinsenfantPK castOther = (SoinsenfantPK)other;
		return 
			(this.soinsID == castOther.soinsID)
			&& (this.enfantID == castOther.enfantID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.soinsID;
		hash = hash * prime + this.enfantID;
		
		return hash;
	}
}