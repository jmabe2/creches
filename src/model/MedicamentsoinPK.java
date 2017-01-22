package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the medicamentsoins database table.
 * 
 */
@Embeddable
public class MedicamentsoinPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int medicamentID;

	@Column(insertable=false, updatable=false)
	private int soinsID;

	public MedicamentsoinPK() {
	}
	public int getMedicamentID() {
		return this.medicamentID;
	}
	public void setMedicamentID(int medicamentID) {
		this.medicamentID = medicamentID;
	}
	public int getSoinsID() {
		return this.soinsID;
	}
	public void setSoinsID(int soinsID) {
		this.soinsID = soinsID;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MedicamentsoinPK)) {
			return false;
		}
		MedicamentsoinPK castOther = (MedicamentsoinPK)other;
		return 
			(this.medicamentID == castOther.medicamentID)
			&& (this.soinsID == castOther.soinsID);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.medicamentID;
		hash = hash * prime + this.soinsID;
		
		return hash;
	}
}