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
@Table(name = "m_item_rate")
@NamedQueries({
    @NamedQuery(name = "MItemRate.findAll", query = "SELECT m FROM MItemRate m")})
public class MItemRate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Pk_No")
    private Integer pkNo;
    @Column(name = "Item_No")
    private Integer itemNo;
    @Column(name = "Rate_No")
    private Integer rateNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Rate_Value")
    private Double rateValue;
    @Column(name = "roundPrice")
    private Double roundPrice;
    @Column(name = "taxClass")
    private Integer taxClass;
    @Column(name = "currencyId")
    private Integer currencyId;

    public MItemRate() {
    }

    public MItemRate(Integer pkNo) {
        this.pkNo = pkNo;
    }

    public Integer getPkNo() {
        return pkNo;
    }

    public void setPkNo(Integer pkNo) {
        this.pkNo = pkNo;
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getRateNo() {
        return rateNo;
    }

    public void setRateNo(Integer rateNo) {
        this.rateNo = rateNo;
    }

    public Double getRateValue() {
        return rateValue;
    }

    public void setRateValue(Double rateValue) {
        this.rateValue = rateValue;
    }

    public Double getRoundPrice() {
        return roundPrice;
    }

    public void setRoundPrice(Double roundPrice) {
        this.roundPrice = roundPrice;
    }

    public Integer getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(Integer taxClass) {
        this.taxClass = taxClass;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
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
        if (!(object instanceof MItemRate)) {
            return false;
        }
        MItemRate other = (MItemRate) object;
        if ((this.pkNo == null && other.pkNo != null) || (this.pkNo != null && !this.pkNo.equals(other.pkNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.hotelpos.MItemRate[ pkNo=" + pkNo + " ]";
    }
    
}
