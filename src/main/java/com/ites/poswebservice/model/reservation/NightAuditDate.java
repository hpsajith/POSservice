/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.reservation;

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
@Table(name = "night_audit_date")
@NamedQueries({
    @NamedQuery(name = "NightAuditDate.findAll", query = "SELECT n FROM NightAuditDate n")})
public class NightAuditDate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NAD_No")
    private Integer nADNo;
    @Column(name = "NAD_Date")
    @Temporal(TemporalType.DATE)
    private Date nADDate;
    @Column(name = "NAD_Current_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nADCurrentDate;

    public NightAuditDate() {
    }

    public NightAuditDate(Integer nADNo) {
        this.nADNo = nADNo;
    }

    public Integer getNADNo() {
        return nADNo;
    }

    public void setNADNo(Integer nADNo) {
        this.nADNo = nADNo;
    }

    public Date getNADDate() {
        return nADDate;
    }

    public void setNADDate(Date nADDate) {
        this.nADDate = nADDate;
    }

    public Date getNADCurrentDate() {
        return nADCurrentDate;
    }

    public void setNADCurrentDate(Date nADCurrentDate) {
        this.nADCurrentDate = nADCurrentDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nADNo != null ? nADNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NightAuditDate)) {
            return false;
        }
        NightAuditDate other = (NightAuditDate) object;
        if ((this.nADNo == null && other.nADNo != null) || (this.nADNo != null && !this.nADNo.equals(other.nADNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.reservation.NightAuditDate[ nADNo=" + nADNo + " ]";
    }

}
