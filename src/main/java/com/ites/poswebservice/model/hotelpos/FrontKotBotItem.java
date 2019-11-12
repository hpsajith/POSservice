package com.ites.poswebservice.model.hotelpos;

import java.io.Serializable;
import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "front_kot_bot_item", catalog = "")
public class FrontKotBotItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "item_no")
    private Integer itemNo;
    @Column(name = "Item_Code")
    private Integer itemCode;
    @Column(name = "kot_bot_no")
    private Integer kotBotNo;
    @Column(name = "menu_id")
    private Integer menuId;
    @Column(name = "tax_class")
    private Integer taxClass;
    @Column(name = "order_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;
    @Column(name = "delivery_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "unit_prices")
    private Double unitPrices;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "QTY")
    private Double qty;
    @Column(name = "isSetMenu")
    private Integer isSetMenu;
    @Column(name = "unit_cost")
    private Double unitCost;
    @Column(name = "Itemcomment")
    private String itemcomment;
    @Column(name = "unit_prices_withTax")
    private Double unitpriceswithTax;

    public FrontKotBotItem(){
    	
    }
    
    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getKotBotNo() {
        return kotBotNo;
    }

    public void setKotBotNo(Integer kotBotNo) {
        this.kotBotNo = kotBotNo;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(Integer taxClass) {
        this.taxClass = taxClass;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Double getUnitPrices() {
        return unitPrices;
    }

    public void setUnitPrices(Double unitPrices) {
        this.unitPrices = unitPrices;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Integer getIsSetMenu() {
        return isSetMenu;
    }

    public void setIsSetMenu(Integer isSetMenu) {
        this.isSetMenu = isSetMenu;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    public String getItemcomment() {
        return itemcomment;
    }

    public void setItemcomment(String itemcomment) {
        this.itemcomment = itemcomment;
    }

    public Double getUnitpriceswithTax() {
        return unitpriceswithTax;
    }

    public void setUnitpriceswithTax(Double unitpriceswithTax) {
        this.unitpriceswithTax = unitpriceswithTax;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemNo != null ? itemNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrontKotBotItem)) {
            return false;
        }
        FrontKotBotItem other = (FrontKotBotItem) object;
        if ((this.itemNo == null && other.itemNo != null) || (this.itemNo != null && !this.itemNo.equals(other.itemNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FrontKotBotItem[ itemNo=" + itemNo + " ]";
    }
    
}
