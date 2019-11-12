package com.ites.poswebservice.model.hotelpos;

import javax.persistence.*;

/**
 * Created by sancwk on 1/20/17.
 */
@Entity
@Table(name = "m_item_cost", catalog = "")
public class MItemCost {
    private int itemCostNo;
    private Integer mainItemCode;
    private String subItemCode;
    private String itemName;
    private Double itemCost;
    private Double itemQuantity;
    private Integer itemCatagory;
    private Integer unit;
    private Integer invOutlet;

    @Id
    @Column(name = "ItemCostNo", nullable = false)
    public int getItemCostNo() {
        return itemCostNo;
    }

    public void setItemCostNo(int itemCostNo) {
        this.itemCostNo = itemCostNo;
    }

    @Basic
    @Column(name = "mainItemCode", nullable = true)
    public Integer getMainItemCode() {
        return mainItemCode;
    }

    public void setMainItemCode(Integer mainItemCode) {
        this.mainItemCode = mainItemCode;
    }

    @Basic
    @Column(name = "SubItemCode", nullable = true, length = 50)
    public String getSubItemCode() {
        return subItemCode;
    }

    public void setSubItemCode(String subItemCode) {
        this.subItemCode = subItemCode;
    }

    @Basic
    @Column(name = "ItemName", nullable = true, length = 50)
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Basic
    @Column(name = "ItemCost", nullable = true, precision = 0)
    public Double getItemCost() {
        return itemCost;
    }

    public void setItemCost(Double itemCost) {
        this.itemCost = itemCost;
    }

    @Basic
    @Column(name = "ItemQuantity", nullable = true, precision = 0)
    public Double getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Basic
    @Column(name = "Item_catagory", nullable = true)
    public Integer getItemCatagory() {
        return itemCatagory;
    }

    public void setItemCatagory(Integer itemCatagory) {
        this.itemCatagory = itemCatagory;
    }

    @Basic
    @Column(name = "unit", nullable = true)
    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "invOutlet", nullable = true)
    public Integer getInvOutlet() {
        return invOutlet;
    }

    public void setInvOutlet(Integer invOutlet) {
        this.invOutlet = invOutlet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MItemCost mItemCost = (MItemCost) o;

        if (itemCostNo != mItemCost.itemCostNo) return false;
        if (mainItemCode != null ? !mainItemCode.equals(mItemCost.mainItemCode) : mItemCost.mainItemCode != null)
            return false;
        if (subItemCode != null ? !subItemCode.equals(mItemCost.subItemCode) : mItemCost.subItemCode != null)
            return false;
        if (itemName != null ? !itemName.equals(mItemCost.itemName) : mItemCost.itemName != null) return false;
        if (itemCost != null ? !itemCost.equals(mItemCost.itemCost) : mItemCost.itemCost != null) return false;
        if (itemQuantity != null ? !itemQuantity.equals(mItemCost.itemQuantity) : mItemCost.itemQuantity != null)
            return false;
        if (itemCatagory != null ? !itemCatagory.equals(mItemCost.itemCatagory) : mItemCost.itemCatagory != null)
            return false;
        if (unit != null ? !unit.equals(mItemCost.unit) : mItemCost.unit != null) return false;
        if (invOutlet != null ? !invOutlet.equals(mItemCost.invOutlet) : mItemCost.invOutlet != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemCostNo;
        result = 31 * result + (mainItemCode != null ? mainItemCode.hashCode() : 0);
        result = 31 * result + (subItemCode != null ? subItemCode.hashCode() : 0);
        result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
        result = 31 * result + (itemCost != null ? itemCost.hashCode() : 0);
        result = 31 * result + (itemQuantity != null ? itemQuantity.hashCode() : 0);
        result = 31 * result + (itemCatagory != null ? itemCatagory.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (invOutlet != null ? invOutlet.hashCode() : 0);
        return result;
    }
}
