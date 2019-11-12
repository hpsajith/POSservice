package com.ites.poswebservice.model.hotelpos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "m_restaurant")
@NamedQueries({
    @NamedQuery(name = "MRestaurant.findAll", query = "SELECT m FROM MRestaurant m")})
public class MRestaurant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "restraunt_id")
    private Integer restrauntId;
    @Column(name = "r_location")
    private String rLocation;
    @Column(name = "r_name")
    private String rName;
    @Column(name = "description")
    private String description;
    @Column(name = "TableC")
    private Integer tableC;
    @Column(name = "User_ID")
    private Integer userID;
    @Column(name = "Curr_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currDate;

    public MRestaurant(String rName) {
        this.rName = rName;
    }
    
    public MRestaurant() {
    }

    public MRestaurant(Integer restrauntId,String rName,String rLocation,String description,Integer tableC,Integer userID) {
        this.restrauntId = restrauntId;
        this.rName = rName;
        this.rLocation = rLocation;
        this.description = description;
        this.tableC = tableC;
        this.userID = userID;
    }

    public Integer getRestrauntId() {
        return restrauntId;
    }

    public void setRestrauntId(Integer restrauntId) {
        this.restrauntId = restrauntId;
    }

    public String getRLocation() {
        return rLocation;
    }

    public void setRLocation(String rLocation) {
        this.rLocation = rLocation;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName = rName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTableC() {
        return tableC;
    }

    public void setTableC(Integer tableC) {
        this.tableC = tableC;
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
        hash += (restrauntId != null ? restrauntId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MRestaurant)) {
            return false;
        }
        MRestaurant other = (MRestaurant) object;
        if ((this.restrauntId == null && other.restrauntId != null) || (this.restrauntId != null && !this.restrauntId.equals(other.restrauntId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MRestaurant[ restrauntId=" + restrauntId + " ]";
    }
    
}
