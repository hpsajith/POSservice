/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.hotelpos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "config_restaurant_item")
@NamedQueries({
    @NamedQuery(name = "ConfigRestaurantItem.findAll", query = "SELECT c FROM ConfigRestaurantItem c")})
public class ConfigRestaurantItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConfigRestaurantItemPK configRestaurantItemPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "majer_no")
    private int majerNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "family_no")
    private int familyNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "master_no")
    private int masterNo;
    @Column(name = "Printer_Id")
    private Integer printerId;
    @Column(name = "User_ID")
    private Integer userID;
    @Column(name = "Curr_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currDate;

    public ConfigRestaurantItem() {
    }

    public ConfigRestaurantItem(ConfigRestaurantItemPK configRestaurantItemPK) {
        this.configRestaurantItemPK = configRestaurantItemPK;
    }

    public ConfigRestaurantItem(ConfigRestaurantItemPK configRestaurantItemPK, int majerNo, int familyNo, int masterNo) {
        this.configRestaurantItemPK = configRestaurantItemPK;
        this.majerNo = majerNo;
        this.familyNo = familyNo;
        this.masterNo = masterNo;
    }

    public ConfigRestaurantItem(int resNo, int itemNo) {
        this.configRestaurantItemPK = new ConfigRestaurantItemPK(resNo, itemNo);
    }

    public ConfigRestaurantItemPK getConfigRestaurantItemPK() {
        return configRestaurantItemPK;
    }

    public void setConfigRestaurantItemPK(ConfigRestaurantItemPK configRestaurantItemPK) {
        this.configRestaurantItemPK = configRestaurantItemPK;
    }

    public int getMajerNo() {
        return majerNo;
    }

    public void setMajerNo(int majerNo) {
        this.majerNo = majerNo;
    }

    public int getFamilyNo() {
        return familyNo;
    }

    public void setFamilyNo(int familyNo) {
        this.familyNo = familyNo;
    }

    public int getMasterNo() {
        return masterNo;
    }

    public void setMasterNo(int masterNo) {
        this.masterNo = masterNo;
    }

    public Integer getPrinterId() {
        return printerId;
    }

    public void setPrinterId(Integer printerId) {
        this.printerId = printerId;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Date getCurrDate() {
        return currDate;
    }

    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configRestaurantItemPK != null ? configRestaurantItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfigRestaurantItem)) {
            return false;
        }
        ConfigRestaurantItem other = (ConfigRestaurantItem) object;
        if ((this.configRestaurantItemPK == null && other.configRestaurantItemPK != null) || (this.configRestaurantItemPK != null && !this.configRestaurantItemPK.equals(other.configRestaurantItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.hotelpos.ConfigRestaurantItem[ configRestaurantItemPK=" + configRestaurantItemPK + " ]";
    }
    
}
