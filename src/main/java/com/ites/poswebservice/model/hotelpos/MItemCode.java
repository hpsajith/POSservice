package com.ites.poswebservice.model.hotelpos;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the m_item database table.
 * 
 */
@Embeddable
public class MItemCode implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="item_code")
	private int itemCode;

	@Column(name="majer_gno")
	private int majerGno;

	@Column(name="family_gno")
	private int familyGno;

	@Column(name="master_gno")
	private int masterGno;

	public MItemCode() {
	}
	public int getItemCode() {
		return this.itemCode;
	}
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}
	public int getMajerGno() {
		return this.majerGno;
	}
	public void setMajerGno(int majerGno) {
		this.majerGno = majerGno;
	}
	public int getFamilyGno() {
		return this.familyGno;
	}
	public void setFamilyGno(int familyGno) {
		this.familyGno = familyGno;
	}
	public int getMasterGno() {
		return this.masterGno;
	}
	public void setMasterGno(int masterGno) {
		this.masterGno = masterGno;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MItemCode)) {
			return false;
		}
		MItemCode castOther = (MItemCode)other;
		return 
			(this.itemCode == castOther.itemCode)
			&& (this.majerGno == castOther.majerGno)
			&& (this.familyGno == castOther.familyGno)
			&& (this.masterGno == castOther.masterGno);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.itemCode;
		hash = hash * prime + this.majerGno;
		hash = hash * prime + this.familyGno;
		hash = hash * prime + this.masterGno;
		
		return hash;
	}
}