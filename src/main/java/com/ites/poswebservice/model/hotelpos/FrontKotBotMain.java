package com.ites.poswebservice.model.hotelpos;

import java.io.Serializable;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "front_kot_bot_main", catalog = "")
public class FrontKotBotMain implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "kot_no")
    private Integer kotNo;
    @Column(name = "Pos_Guest_no")
    private Integer posGuestno;
    @Column(name = "resturent_id")
    private Integer resturentId;
    @Column(name = "tableNo")
    private Integer tableNo;
    @Column(name = "remark")
    private String remark;
    @Column(name = "meal_period")
    private Integer mealPeriod;
    @Column(name = "CurrentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currentDate;
    @Column(name = "UserId")
    private Integer userId;
    @Column(name = "state")
    private Integer state;
    @Column(name = "viewuser")
    private Integer viewuser;
    @Column(name = "loguserID")
    private Integer loguserID;
    @Column(name = "BillNo")
    private String billNo;
    @Column(name = "IntBillNo")
    private Integer intBillNo;
    @Column(name = "isEnter")
    private Integer isEnter;
    @Column(name = "resRoom")
    private Integer resRoom;
    @Column(name = "print_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date printTime;
    @Column(name = "print_user")
    private Integer printUser;
    @Column(name = "hasSplit")
    private Boolean hasSplit;
    @Column(name = "hasMerge_id")
    private Integer hasMergeid;
    @Column(name = "merge_bill_no")
    private String mergeBillNo;
    @Column(name = "int_merge_bill_no")
    private Integer intMergeBillNo;
    @Column(name = "open_in_table")
    private Integer openInTable;
    @Column(name = "nightDate")
    private String nightDate;

    public FrontKotBotMain(){
    	
    }
    
    public Integer getKotNo() {
        return kotNo;
    }

    public void setKotNo(Integer kotNo) {
        this.kotNo = kotNo;
    }

    public Integer getPosGuestno() {
        return posGuestno;
    }

    public void setPosGuestno(Integer posGuestno) {
        this.posGuestno = posGuestno;
    }

    public Integer getResturentId() {
        return resturentId;
    }

    public void setResturentId(Integer resturentId) {
        this.resturentId = resturentId;
    }

    public Integer getTableNo() {
        return tableNo;
    }

    public void setTableNo(Integer tableNo) {
        this.tableNo = tableNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getMealPeriod() {
        return mealPeriod;
    }

    public void setMealPeriod(Integer mealPeriod) {
        this.mealPeriod = mealPeriod;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getViewuser() {
        return viewuser;
    }

    public void setViewuser(Integer viewuser) {
        this.viewuser = viewuser;
    }

    public Integer getLoguserID() {
        return loguserID;
    }

    public void setLoguserID(Integer loguserID) {
        this.loguserID = loguserID;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Integer getIntBillNo() {
        return intBillNo;
    }

    public void setIntBillNo(Integer intBillNo) {
        this.intBillNo = intBillNo;
    }

    public Integer getIsEnter() {
        return isEnter;
    }

    public void setIsEnter(Integer isEnter) {
        this.isEnter = isEnter;
    }

    public Integer getResRoom() {
        return resRoom;
    }

    public void setResRoom(Integer resRoom) {
        this.resRoom = resRoom;
    }

    public Date getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Date printTime) {
        this.printTime = printTime;
    }

    public Integer getPrintUser() {
        return printUser;
    }

    public void setPrintUser(Integer printUser) {
        this.printUser = printUser;
    }

    public Boolean getHasSplit() {
        return hasSplit;
    }

    public void setHasSplit(Boolean hasSplit) {
        this.hasSplit = hasSplit;
    }

    public Integer getHasMergeid() {
        return hasMergeid;
    }

    public void setHasMergeid(Integer hasMergeid) {
        this.hasMergeid = hasMergeid;
    }

    public String getMergeBillNo() {
        return mergeBillNo;
    }

    public void setMergeBillNo(String mergeBillNo) {
        this.mergeBillNo = mergeBillNo;
    }

    public Integer getIntMergeBillNo() {
        return intMergeBillNo;
    }

    public void setIntMergeBillNo(Integer intMergeBillNo) {
        this.intMergeBillNo = intMergeBillNo;
    }

    public Integer getOpenInTable() {
        return openInTable;
    }

    public void setOpenInTable(Integer openInTable) {
        this.openInTable = openInTable;
    }

    public String getNightDate() {
        return nightDate;
    }

    public void setNightDate(String nightDate) {
        this.nightDate = nightDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kotNo != null ? kotNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrontKotBotMain)) {
            return false;
        }
        FrontKotBotMain other = (FrontKotBotMain) object;
        if ((this.kotNo == null && other.kotNo != null) || (this.kotNo != null && !this.kotNo.equals(other.kotNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FrontKotBotMain[ kotNo=" + kotNo + " ]";
    }
    
}
