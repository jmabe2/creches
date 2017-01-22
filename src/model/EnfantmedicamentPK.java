package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the enfantmedicament database table.
 * 
 */
@Embeddable
public class EnfantmedicamentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int medicamentID;

	@Column(insertable=false, updatable=false)
	private int enfantID;

	public EnfantmedicamentPK() {
	}
	public int getMedicamentID() {
		return this.medicamentID;
	}
	public void setMedicamentID(int medicamentID) {
		this.medicamentID = medicamentID;
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
		if (!(other instanceof EnfantmedicamentPK)) {
			return false;
		}
		EnfantmedicamentPK castOther = (EnfantmedicamentPK)other;
		return 
			(this.medicamentID == castOther.medicamentID)
			&& (this.enfantID == castOther.enfantID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.medicamentID;
		hash = hash * prime + this.enfantID;
		
		return hash;
	}
}