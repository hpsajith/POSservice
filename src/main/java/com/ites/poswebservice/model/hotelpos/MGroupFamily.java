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
@Table(name = "m_group_family", catalog = "")
@NamedQueries({
    @NamedQuery(name = "MGroupFamily.findAll", query = "SELECT m FROM MGroupFamily m")})
public class MGroupFamily implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "F_no")
    private Integer fno;
    @Column(name = "F_M_no")
    private Integer fMno;
    @Size(max = 255)
    @Column(name = "F_name")
    private String fname;
    @Size(max = 255)
    @Column(name = "F_report_cord")
    private String freportcord;
    @Size(max = 300)
    @Column(name = "F_image")
    private String fimage;
    @Column(name = "User_ID")
    private Integer userID;
    @Column(name = "Curr_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currDate;
    @Column(name = "Department")
    private Integer department;
    @Column(name = "isSpa")
    private Boolean isSpa;

    public MGroupFamily() {
    }

    public MGroupFamily(Integer fno) {
        this.fno = fno;
    }

    public Integer getFno() {
        return fno;
    }

    public void setFno(Integer fno) {
        this.fno = fno;
    }

    public Integer getFMno() {
        return fMno;
    }

    public void setFMno(Integer fMno) {
        this.fMno = fMno;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFreportcord() {
        return freportcord;
    }

    public void setFreportcord(String freportcord) {
        this.freportcord = freportcord;
    }

    public String getFimage() {
        return fimage;
    }

    public void setFimage(String fimage) {
        this.fimage = fimage;
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

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
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
        hash += (fno != null ? fno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MGroupFamily)) {
            return false;
        }
        MGroupFamily other = (MGroupFamily) object;
        if ((this.fno == null && other.fno != null) || (this.fno != null && !this.fno.equals(other.fno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.hotelpos.MGroupFamily[ fno=" + fno + " ]";
    }
    
}
