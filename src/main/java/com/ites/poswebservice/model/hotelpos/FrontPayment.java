/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ites.poswebservice.model.hotelpos;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wannix
 */
@Entity
@Table(name = "front_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FrontPayment.findAll", query = "SELECT f FROM FrontPayment f")
    , @NamedQuery(name = "FrontPayment.findByPaymentId", query = "SELECT f FROM FrontPayment f WHERE f.paymentId = :paymentId")
    , @NamedQuery(name = "FrontPayment.findByPaymentType", query = "SELECT f FROM FrontPayment f WHERE f.paymentType = :paymentType")
    , @NamedQuery(name = "FrontPayment.findByPaymentDate", query = "SELECT f FROM FrontPayment f WHERE f.paymentDate = :paymentDate")
    , @NamedQuery(name = "FrontPayment.findByPaymentAmount", query = "SELECT f FROM FrontPayment f WHERE f.paymentAmount = :paymentAmount")
    , @NamedQuery(name = "FrontPayment.findByKotNo", query = "SELECT f FROM FrontPayment f WHERE f.kotNo = :kotNo")
    , @NamedQuery(name = "FrontPayment.findByStat", query = "SELECT f FROM FrontPayment f WHERE f.stat = :stat")
    , @NamedQuery(name = "FrontPayment.findByVoid1", query = "SELECT f FROM FrontPayment f WHERE f.void1 = :void1")
    , @NamedQuery(name = "FrontPayment.findByUserId", query = "SELECT f FROM FrontPayment f WHERE f.userId = :userId")
    , @NamedQuery(name = "FrontPayment.findByAccountNo", query = "SELECT f FROM FrontPayment f WHERE f.accountNo = :accountNo")
    , @NamedQuery(name = "FrontPayment.findByDiscountNo", query = "SELECT f FROM FrontPayment f WHERE f.discountNo = :discountNo")
    , @NamedQuery(name = "FrontPayment.findByResturentId", query = "SELECT f FROM FrontPayment f WHERE f.resturentId = :resturentId")
    , @NamedQuery(name = "FrontPayment.findByRevenueType", query = "SELECT f FROM FrontPayment f WHERE f.revenueType = :revenueType")
    , @NamedQuery(name = "FrontPayment.findByItemNo", query = "SELECT f FROM FrontPayment f WHERE f.itemNo = :itemNo")
    , @NamedQuery(name = "FrontPayment.findByFromPms", query = "SELECT f FROM FrontPayment f WHERE f.fromPms = :fromPms")
    , @NamedQuery(name = "FrontPayment.findBySubbillNo", query = "SELECT f FROM FrontPayment f WHERE f.subbillNo = :subbillNo")
    , @NamedQuery(name = "FrontPayment.findByDiscountType", query = "SELECT f FROM FrontPayment f WHERE f.discountType = :discountType")
    , @NamedQuery(name = "FrontPayment.findByFbsId", query = "SELECT f FROM FrontPayment f WHERE f.fbsId = :fbsId")})
public class FrontPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Payment_Id")
    private Integer paymentId;
    @Column(name = "Payment_Type")
    private Integer paymentType;
    @Column(name = "PaymentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Payment_Amount")
    private BigDecimal paymentAmount;
    @Column(name = "Kot_No")
    private Integer kotNo;
    @Column(name = "stat")
    private Integer stat;
    @Column(name = "Void")
    private Integer void1;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "AccountNo")
    private String accountNo;
    @Column(name = "DiscountNo")
    private Integer discountNo;
    @Column(name = "ResturentId")
    private Integer resturentId;
    @Column(name = "revenueType")
    private Integer revenueType;
    @Column(name = "ItemNo")
    private Integer itemNo;
    @Column(name = "from_pms")
    private Integer fromPms;
    @Column(name = "sub_billNo")
    private String subbillNo;
    @Column(name = "discount_type")
    private Integer discountType;
    @Column(name = "fbs_id")
    private Integer fbsId;

    public FrontPayment() {
    }

    public FrontPayment(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Integer getKotNo() {
        return kotNo;
    }

    public void setKotNo(Integer kotNo) {
        this.kotNo = kotNo;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Integer getVoid1() {
        return void1;
    }

    public void setVoid1(Integer void1) {
        this.void1 = void1;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getDiscountNo() {
        return discountNo;
    }

    public void setDiscountNo(Integer discountNo) {
        this.discountNo = discountNo;
    }

    public Integer getResturentId() {
        return resturentId;
    }

    public void setResturentId(Integer resturentId) {
        this.resturentId = resturentId;
    }

    public Integer getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(Integer revenueType) {
        this.revenueType = revenueType;
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getFromPms() {
        return fromPms;
    }

    public void setFromPms(Integer fromPms) {
        this.fromPms = fromPms;
    }

    public String getSubbillNo() {
        return subbillNo;
    }

    public void setSubbillNo(String subbillNo) {
        this.subbillNo = subbillNo;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public Integer getFbsId() {
        return fbsId;
    }

    public void setFbsId(Integer fbsId) {
        this.fbsId = fbsId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrontPayment)) {
            return false;
        }
        FrontPayment other = (FrontPayment) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.hotelpos.FrontPayment[ paymentId=" + paymentId + " ]";
    }
    
}
