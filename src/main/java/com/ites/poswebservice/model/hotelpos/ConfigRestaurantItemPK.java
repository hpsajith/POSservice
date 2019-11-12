/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.hotelpos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ITESS
 */
@Embeddable
public class ConfigRestaurantItemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "res_no")
    private int resNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "item_no")
    private int itemNo;

    public ConfigRestaurantItemPK() {
    }

    public ConfigRestaurantItemPK(int resNo, int itemNo) {
        this.resNo = resNo;
        this.itemNo = itemNo;
    }

    public int getResNo() {
        return resNo;
    }

    public void setResNo(int resNo) {
        this.resNo = resNo;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) resNo;
        hash += (int) itemNo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfigRestaurantItemPK)) {
            return false;
        }
        ConfigRestaurantItemPK other = (ConfigRestaurantItemPK) object;
        if (this.resNo != other.resNo) {
            return false;
        }
        if (this.itemNo != other.itemNo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.hotelpos.ConfigRestaurantItemPK[ resNo=" + resNo + ", itemNo=" + itemNo + " ]";
    }
    
}
