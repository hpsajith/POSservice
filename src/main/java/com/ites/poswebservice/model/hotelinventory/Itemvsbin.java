package com.ites.poswebservice.model.hotelinventory;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by sancwk on 1/19/17.
 */
@Entity
public class Itemvsbin {
    private String itemNo;
    private Double binNo;
    private Double maxUnit;
    private Double unitType;
    private Double availableQty;

    @Id
    @Basic
    @Column(name = "ItemNo", nullable = false, length = 15)
    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    @Basic
    @Column(name = "BinNo", nullable = true, precision = 0)
    public Double getBinNo() {
        return binNo;
    }

    public void setBinNo(Double binNo) {
        this.binNo = binNo;
    }

    @Basic
    @Column(name = "MaxUnit", nullable = true, precision = 0)
    public Double getMaxUnit() {
        return maxUnit;
    }

    public void setMaxUnit(Double maxUnit) {
        this.maxUnit = maxUnit;
    }

    @Basic
    @Column(name = "UnitType", nullable = true, precision = 0)
    public Double getUnitType() {
        return unitType;
    }

    public void setUnitType(Double unitType) {
        this.unitType = unitType;
    }

    @Basic
    @Column(name = "AvailableQty", nullable = true, precision = 4)
    public Double getAvailableQty() {
        return availableQty;
    }

    public void setAvailableQty(Double availableQty) {
        this.availableQty = availableQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Itemvsbin itemvsbin = (Itemvsbin) o;

        if (itemNo != null ? !itemNo.equals(itemvsbin.itemNo) : itemvsbin.itemNo != null) return false;
        if (binNo != null ? !binNo.equals(itemvsbin.binNo) : itemvsbin.binNo != null) return false;
        if (maxUnit != null ? !maxUnit.equals(itemvsbin.maxUnit) : itemvsbin.maxUnit != null) return false;
        if (unitType != null ? !unitType.equals(itemvsbin.unitType) : itemvsbin.unitType != null) return false;
        if (availableQty != null ? !availableQty.equals(itemvsbin.availableQty) : itemvsbin.availableQty != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemNo != null ? itemNo.hashCode() : 0;
        result = 31 * result + (binNo != null ? binNo.hashCode() : 0);
        result = 31 * result + (maxUnit != null ? maxUnit.hashCode() : 0);
        result = 31 * result + (unitType != null ? unitType.hashCode() : 0);
        result = 31 * result + (availableQty != null ? availableQty.hashCode() : 0);
        return result;
    }
}
