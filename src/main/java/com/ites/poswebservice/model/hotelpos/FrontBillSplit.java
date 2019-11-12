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
@Table(name = "front_bill_split")
@NamedQueries({
    @NamedQuery(name = "FrontBillSplit.findAll", query = "SELECT f FROM FrontBillSplit f")})
public class FrontBillSplit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fbs_id")
    private Integer fbsId;
    @Column(name = "kot_no")
    private Integer kotNo;
    @Size(max = 20)
    @Column(name = "bill_no")
    private String billNo;
    @Column(name = "bill_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date billTime;
    @Column(name = "int_bill_no")
    private Integer intBillNo;
    @Column(name = "isPaid")
    private Boolean isPaid;
    @Column(name = "payment_id")
    private Integer paymentId;
    @Size(max = 20)
    @Column(name = "Room_No")
    private String roomNo;

    public FrontBillSplit() {
    }

    public FrontBillSplit(Integer fbsId) {
        this.fbsId = fbsId;
    }

    public Integer getFbsId() {
        return fbsId;
    }

    public void setFbsId(Integer fbsId) {
        this.fbsId = fbsId;
    }

    public Integer getKotNo() {
        return kotNo;
    }

    public void setKotNo(Integer kotNo) {
        this.kotNo = kotNo;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public Integer getIntBillNo() {
        return intBillNo;
    }

    public void setIntBillNo(Integer intBillNo) {
        this.intBillNo = intBillNo;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fbsId != null ? fbsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrontBillSplit)) {
            return false;
        }
        FrontBillSplit other = (FrontBillSplit) object;
        if ((this.fbsId == null && other.fbsId != null) || (this.fbsId != null && !this.fbsId.equals(other.fbsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.hotelpos.FrontBillSplit[ fbsId=" + fbsId + " ]";
    }
    
}
