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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "m_ac_creditcard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MAcCreditcard.findAll", query = "SELECT m FROM MAcCreditcard m")
    , @NamedQuery(name = "MAcCreditcard.findByCreditcardid", query = "SELECT m FROM MAcCreditcard m WHERE m.creditcardid = :creditcardid")
    , @NamedQuery(name = "MAcCreditcard.findByCreditcardname", query = "SELECT m FROM MAcCreditcard m WHERE m.creditcardname = :creditcardname")
    , @NamedQuery(name = "MAcCreditcard.findByCoaNo", query = "SELECT m FROM MAcCreditcard m WHERE m.coaNo = :coaNo")})
public class MAcCreditcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Credit_card_id")
    private Integer creditcardid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Credit_card_name")
    private String creditcardname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Coa_No")
    private String coaNo;

    public MAcCreditcard() {
    }

    public MAcCreditcard(Integer creditcardid) {
        this.creditcardid = creditcardid;
    }

    public MAcCreditcard(Integer creditcardid, String creditcardname, String coaNo) {
        this.creditcardid = creditcardid;
        this.creditcardname = creditcardname;
        this.coaNo = coaNo;
    }

    public Integer getCreditcardid() {
        return creditcardid;
    }

    public void setCreditcardid(Integer creditcardid) {
        this.creditcardid = creditcardid;
    }

    public String getCreditcardname() {
        return creditcardname;
    }

    public void setCreditcardname(String creditcardname) {
        this.creditcardname = creditcardname;
    }

    public String getCoaNo() {
        return coaNo;
    }

    public void setCoaNo(String coaNo) {
        this.coaNo = coaNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditcardid != null ? creditcardid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MAcCreditcard)) {
            return false;
        }
        MAcCreditcard other = (MAcCreditcard) object;
        if ((this.creditcardid == null && other.creditcardid != null) || (this.creditcardid != null && !this.creditcardid.equals(other.creditcardid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.hotelpos.MAcCreditcard[ creditcardid=" + creditcardid + " ]";
    }
    
}
