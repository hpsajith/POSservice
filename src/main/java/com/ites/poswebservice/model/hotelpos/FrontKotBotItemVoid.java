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

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "front_kot_bot_item_void")
@NamedQueries({
    @NamedQuery(name = "FrontKotBotItemVoid.findAll", query = "SELECT f FROM FrontKotBotItemVoid f")})
public class FrontKotBotItemVoid implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Front_VoidId")
    private Integer frontVoidId;
    @Column(name = "KotNo")
    private Integer kotNo;
    @Column(name = "UserId")
    private Integer userId;
    @Column(name = "ResturentId")
    private Integer resturentId;
    @Column(name = "ItemNo")
    private Integer itemNo;
    @Column(name = "Qty")
    private Integer qty;
    @Column(name = "VoidNo")
    private Integer voidNo;
    @Column(name = "SystemDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date systemDate;

    public FrontKotBotItemVoid() {
    }

    public FrontKotBotItemVoid(Integer frontVoidId) {
        this.frontVoidId = frontVoidId;
    }

    public Integer getFrontVoidId() {
        return frontVoidId;
    }

    public void setFrontVoidId(Integer frontVoidId) {
        this.frontVoidId = frontVoidId;
    }

    public Integer getKotNo() {
        return kotNo;
    }

    public void setKotNo(Integer kotNo) {
        this.kotNo = kotNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getResturentId() {
        return resturentId;
    }

    public void setResturentId(Integer resturentId) {
        this.resturentId = resturentId;
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getVoidNo() {
        return voidNo;
    }

    public void setVoidNo(Integer voidNo) {
        this.voidNo = voidNo;
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (frontVoidId != null ? frontVoidId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrontKotBotItemVoid)) {
            return false;
        }
        FrontKotBotItemVoid other = (FrontKotBotItemVoid) object;
        if ((this.frontVoidId == null && other.frontVoidId != null) || (this.frontVoidId != null && !this.frontVoidId.equals(other.frontVoidId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.hotelpos.FrontKotBotItemVoid[ frontVoidId=" + frontVoidId + " ]";
    }
    
}
