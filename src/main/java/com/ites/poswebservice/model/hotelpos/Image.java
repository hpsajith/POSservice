package com.ites.poswebservice.model.hotelpos;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the m_image database table.
 * 
 */
@Entity
@Table(name="m_image")
@NamedQuery(name="Image.findAll", query="SELECT i FROM Image i")
public class Image implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pk_No;

	private Timestamp curr_Date;
	
	@Lob 
	@Column(length=100000)
	private byte[] image;

	private String image_Name;

	private int user_ID;

	public Image() {
	}

	public int getPk_No() {
		return this.pk_No;
	}

	public void setPk_No(int pk_No) {
		this.pk_No = pk_No;
	}

	public Timestamp getCurr_Date() {
		return this.curr_Date;
	}

	public void setCurr_Date(Timestamp curr_Date) {
		this.curr_Date = curr_Date;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImage_Name() {
		return this.image_Name;
	}

	public void setImage_Name(String image_Name) {
		this.image_Name = image_Name;
	}

	public int getUser_ID() {
		return this.user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

}