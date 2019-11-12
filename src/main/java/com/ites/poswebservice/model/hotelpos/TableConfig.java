package com.ites.poswebservice.model.hotelpos;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the config_restaurant_room_table database table.
 * 
 */
@Entity
@Table(name="config_restaurant_room_table")
@NamedQuery(name="TableConfig.findAll", query="SELECT t FROM TableConfig t")
public class TableConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int configid;

	private int back_Color_B;

	private int back_Color_G;

	private int back_Color_R;

	private String caption_Position;

	private Timestamp curr_Date;

	private int fore_Color_B;

	private int fore_Color_G;

	private int fore_Color_R;

	private int height;

	private int image_Id;

	private int restrauntId;

	private int room_Id;

	private int show_Caption;

	private int table_Id;

	private int text_Size;

	private int user_ID;

	private int width;

	private int xposition;

	private int yposition;

	public TableConfig() {
	}

	public int getConfigid() {
		return this.configid;
	}

	public void setConfigid(int configid) {
		this.configid = configid;
	}

	public int getBack_Color_B() {
		return this.back_Color_B;
	}

	public void setBack_Color_B(int back_Color_B) {
		this.back_Color_B = back_Color_B;
	}

	public int getBack_Color_G() {
		return this.back_Color_G;
	}

	public void setBack_Color_G(int back_Color_G) {
		this.back_Color_G = back_Color_G;
	}

	public int getBack_Color_R() {
		return this.back_Color_R;
	}

	public void setBack_Color_R(int back_Color_R) {
		this.back_Color_R = back_Color_R;
	}

	public String getCaption_Position() {
		return this.caption_Position;
	}

	public void setCaption_Position(String caption_Position) {
		this.caption_Position = caption_Position;
	}

	public Timestamp getCurr_Date() {
		return this.curr_Date;
	}

	public void setCurr_Date(Timestamp curr_Date) {
		this.curr_Date = curr_Date;
	}

	public int getFore_Color_B() {
		return this.fore_Color_B;
	}

	public void setFore_Color_B(int fore_Color_B) {
		this.fore_Color_B = fore_Color_B;
	}

	public int getFore_Color_G() {
		return this.fore_Color_G;
	}

	public void setFore_Color_G(int fore_Color_G) {
		this.fore_Color_G = fore_Color_G;
	}

	public int getFore_Color_R() {
		return this.fore_Color_R;
	}

	public void setFore_Color_R(int fore_Color_R) {
		this.fore_Color_R = fore_Color_R;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getImage_Id() {
		return this.image_Id;
	}

	public void setImage_Id(int image_Id) {
		this.image_Id = image_Id;
	}

	public int getRestrauntId() {
		return this.restrauntId;
	}

	public void setRestrauntId(int restrauntId) {
		this.restrauntId = restrauntId;
	}

	public int getRoom_Id() {
		return this.room_Id;
	}

	public void setRoom_Id(int room_Id) {
		this.room_Id = room_Id;
	}

	public int getShow_Caption() {
		return this.show_Caption;
	}

	public void setShow_Caption(int show_Caption) {
		this.show_Caption = show_Caption;
	}

	public int getTable_Id() {
		return this.table_Id;
	}

	public void setTable_Id(int table_Id) {
		this.table_Id = table_Id;
	}

	public int getText_Size() {
		return this.text_Size;
	}

	public void setText_Size(int text_Size) {
		this.text_Size = text_Size;
	}

	public int getUser_ID() {
		return this.user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getXposition() {
		return this.xposition;
	}

	public void setXposition(int xposition) {
		this.xposition = xposition;
	}

	public int getYposition() {
		return this.yposition;
	}

	public void setYposition(int yposition) {
		this.yposition = yposition;
	}

//	public static void main(String[] args) throws Exception {
//		SpringApplication.run(TableConfig.class, args);
//	}
	
	public String toString(){
		return back_Color_B+" "+back_Color_G+" "+back_Color_R+" "+caption_Position+" "+configid+" "+
				fore_Color_B+" "+fore_Color_G+" "+fore_Color_R+" "+height+" "+image_Id+" "+restrauntId+" "+room_Id+" "+
				show_Caption+" "+table_Id+" "+text_Size+" "+user_ID+" "+width+" "+xposition+" "+yposition;
	}

}