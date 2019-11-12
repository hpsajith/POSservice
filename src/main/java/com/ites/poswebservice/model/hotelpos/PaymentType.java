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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "payment_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentType.findAll", query = "SELECT p FROM PaymentType p")
    , @NamedQuery(name = "PaymentType.findByPaymentNo", query = "SELECT p FROM PaymentType p WHERE p.paymentNo = :paymentNo")
    , @NamedQuery(name = "PaymentType.findByPaymentName", query = "SELECT p FROM PaymentType p WHERE p.paymentName = :paymentName")
    , @NamedQuery(name = "PaymentType.findByAccountNo", query = "SELECT p FROM PaymentType p WHERE p.accountNo = :accountNo")})
public class PaymentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Payment_No")
    private Integer paymentNo;
    @Size(max = 20)
    @Column(name = "Payment_Name")
    private String paymentName;
    @Size(max = 200)
    @Column(name = "Account_No")
    private String accountNo;

    public PaymentType() {
    }

    public PaymentType(Integer paymentNo) {
        this.paymentNo = paymentNo;
    }

    public Integer getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(Integer paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentNo != null ? paymentNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentType)) {
            return false;
        }
        PaymentType other = (PaymentType) object;
        if ((this.paymentNo == null && other.paymentNo != null) || (this.paymentNo != null && !this.paymentNo.equals(other.paymentNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.hotelpos.PaymentType[ paymentNo=" + paymentNo + " ]";
    }
    
}
