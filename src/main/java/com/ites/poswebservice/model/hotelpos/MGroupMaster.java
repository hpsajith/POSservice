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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "m_group_master")
@NamedQueries({
    @NamedQuery(name = "MGroupMaster.findAll", query = "SELECT m FROM MGroupMaster m")})
public class MGroupMaster implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Master_no")
    private Integer masterno;
    @Column(name = "Master_m_no")
    private Integer mastermno;
    @Column(name = "Master_F_no")
    private Integer masterFno;
    @Size(max = 255)
    @Column(name = "Master_name")
    private String mastername;
    @Size(max = 255)
    @Column(name = "Master_Report")
    private String masterReport;
    @Size(max = 300)
    @Column(name = "Master_image")
    private String masterimage;
    @Column(name = "User_ID")
    private Integer userID;
    @Column(name = "Curr_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currDate;
    @Column(name = "mgmOrderNo")
    private Integer mgmOrderNo;
    @Column(name = "stores")
    private Integer stores;
    @Column(name = "isSpa")
    private Boolean isSpa;

    public MGroupMaster() {
    }

    public MGroupMaster(Integer masterno) {
        this.masterno = masterno;
    }

    public Integer getMasterno() {
        return masterno;
    }

    public void setMasterno(Integer masterno) {
        this.masterno = masterno;
    }

    public Integer getMastermno() {
        return mastermno;
    }

    public void setMastermno(Integer mastermno) {
        this.mastermno = mastermno;
    }

    public Integer getMasterFno() {
        return masterFno;
    }

    public void setMasterFno(Integer masterFno) {
        this.masterFno = masterFno;
    }

    public String getMastername() {
        return mastername;
    }

    public void setMastername(String mastername) {
        this.mastername = mastername;
    }

    public String getMasterReport() {
        return masterReport;
    }

    public void setMasterReport(String masterReport) {
        this.masterReport = masterReport;
    }

    public String getMasterimage() {
        return masterimage;
    }

    public void setMasterimage(String masterimage) {
        this.masterimage = masterimage;
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

    public Integer getMgmOrderNo() {
        return mgmOrderNo;
    }

    public void setMgmOrderNo(Integer mgmOrderNo) {
        this.mgmOrderNo = mgmOrderNo;
    }

    public Integer getStores() {
        return stores;
    }

    public void setStores(Integer stores) {
        this.stores = stores;
    }

    public Boolean getIsSpa() {
        return isSpa;
    }

    public void setIsSpa(Boolean isSpa) {
        this.isSpa = isSpa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (masterno != null ? masterno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MGroupMaster)) {
            return false;
        }
        MGroupMaster other = (MGroupMaster) object;
        if ((this.masterno == null && other.masterno != null) || (this.masterno != null && !this.masterno.equals(other.masterno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.hotelpos.MGroupMaster[ masterno=" + masterno + " ]";
    }
    
}
