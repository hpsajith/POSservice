/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.hotelpos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "m_void_reason")
@NamedQueries({
    @NamedQuery(name = "MVoidReason.findAll", query = "SELECT m FROM MVoidReason m")})
public class MVoidReason implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkNo")
    private Integer pkNo;
    @Size(max = 511)
    @Column(name = "Reason")
    private String reason;

    public MVoidReason() {
    }

    public MVoidReason(Integer pkNo) {
        this.pkNo = pkNo;
    }

    public Integer getPkNo() {
        return pkNo;
    }

    public void setPkNo(Integer pkNo) {
        this.pkNo = pkNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkNo != null ? pkNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MVoidReason)) {
            return false;
        }
        MVoidReason other = (MVoidReason) object;
        if ((this.pkNo == null && other.pkNo != null) || (this.pkNo != null && !this.pkNo.equals(other.pkNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.hotelpos.MVoidReason[ pkNo=" + pkNo + " ]";
    }
    
}
