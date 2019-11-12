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

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "front_kot_bot_tax", catalog = "")
@NamedQueries({
    @NamedQuery(name = "FrontKotBotTax.findAll", query = "SELECT f FROM FrontKotBotTax f")})
public class FrontKotBotTax implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KB_TaxNo")
    private Integer kBTaxNo;
    @Column(name = "KB_ItemNo")
    private Integer kBItemNo;
    @Column(name = "TaxNo")
    private Integer taxNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TaxAmount")
    private Double taxAmount;

    public FrontKotBotTax() {
    }

    public FrontKotBotTax(Integer kBTaxNo) {
        this.kBTaxNo = kBTaxNo;
    }

    public Integer getKBTaxNo() {
        return kBTaxNo;
    }

    public void setKBTaxNo(Integer kBTaxNo) {
        this.kBTaxNo = kBTaxNo;
    }

    public Integer getKBItemNo() {
        return kBItemNo;
    }

    public void setKBItemNo(Integer kBItemNo) {
        this.kBItemNo = kBItemNo;
    }

    public Integer getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(Integer taxNo) {
        this.taxNo = taxNo;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kBTaxNo != null ? kBTaxNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrontKotBotTax)) {
            return false;
        }
        FrontKotBotTax other = (FrontKotBotTax) object;
        if ((this.kBTaxNo == null && other.kBTaxNo != null) || (this.kBTaxNo != null && !this.kBTaxNo.equals(other.kBTaxNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.hotelPos.FrontKotBotTax[ kBTaxNo=" + kBTaxNo + " ]";
    }
    
}
