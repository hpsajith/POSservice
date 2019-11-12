package com.ites.poswebservice.model.hotelinventory;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by sancwk on 1/19/17.
 */
@Entity
public class Item {
    private String iteNo;
    private Double cat3No;
    private Double cat1No;
    private Double cat2No;
    private String iteName;
    private String iteDescription;
    private Double unitType;
    private Double iteReorderQty;
    private Double iteReorderLevel;
    private Double iteMin;
    private Double iteMax;
    private Double iteActive;
    private Double iteVat;
    private Double iteNbt;
    private Double iteBtt;
    private Double iteTax;
    private String chartOfAcc;
    private Double store;
    private Double zone;
    private Double bin;
    private Double empNo;
    private String partNo;
    private Double noOfQty;
    private String posItemName;

    @Id
    @Basic
    @Column(name = "Ite_No", nullable = false, length = 150)
    public String getIteNo() {
        return iteNo;
    }

    public void setIteNo(String iteNo) {
        this.iteNo = iteNo;
    }

    @Basic
    @Column(name = "Cat3_No", nullable = true, precision = 0)
    public Double getCat3No() {
        return cat3No;
    }

    public void setCat3No(Double cat3No) {
        this.cat3No = cat3No;
    }

    @Basic
    @Column(name = "Cat1_No", nullable = true, precision = 0)
    public Double getCat1No() {
        return cat1No;
    }

    public void setCat1No(Double cat1No) {
        this.cat1No = cat1No;
    }

    @Basic
    @Column(name = "Cat2_No", nullable = true, precision = 0)
    public Double getCat2No() {
        return cat2No;
    }

    public void setCat2No(Double cat2No) {
        this.cat2No = cat2No;
    }

    @Basic
    @Column(name = "Ite_Name", nullable = true, length = 765)
    public String getIteName() {
        return iteName;
    }

    public void setIteName(String iteName) {
        this.iteName = iteName;
    }

    @Basic
    @Column(name = "Ite_Description", nullable = true, length = 1533)
    public String getIteDescription() {
        return iteDescription;
    }

    public void setIteDescription(String iteDescription) {
        this.iteDescription = iteDescription;
    }

    @Basic
    @Column(name = "unitType", nullable = true, precision = 0)
    public Double getUnitType() {
        return unitType;
    }

    public void setUnitType(Double unitType) {
        this.unitType = unitType;
    }

    @Basic
    @Column(name = "Ite_Reorder_Qty", nullable = true, precision = 0)
    public Double getIteReorderQty() {
        return iteReorderQty;
    }

    public void setIteReorderQty(Double iteReorderQty) {
        this.iteReorderQty = iteReorderQty;
    }

    @Basic
    @Column(name = "Ite_Reorder_level", nullable = true, precision = 0)
    public Double getIteReorderLevel() {
        return iteReorderLevel;
    }

    public void setIteReorderLevel(Double iteReorderLevel) {
        this.iteReorderLevel = iteReorderLevel;
    }

    @Basic
    @Column(name = "Ite_min", nullable = true, precision = 0)
    public Double getIteMin() {
        return iteMin;
    }

    public void setIteMin(Double iteMin) {
        this.iteMin = iteMin;
    }

    @Basic
    @Column(name = "Ite_max", nullable = true, precision = 0)
    public Double getIteMax() {
        return iteMax;
    }

    public void setIteMax(Double iteMax) {
        this.iteMax = iteMax;
    }

    @Basic
    @Column(name = "Ite_active", nullable = true, precision = 0)
    public Double getIteActive() {
        return iteActive;
    }

    public void setIteActive(Double iteActive) {
        this.iteActive = iteActive;
    }

    @Basic
    @Column(name = "Ite_Vat", nullable = true, precision = 0)
    public Double getIteVat() {
        return iteVat;
    }

    public void setIteVat(Double iteVat) {
        this.iteVat = iteVat;
    }

    @Basic
    @Column(name = "Ite_Nbt", nullable = true, precision = 0)
    public Double getIteNbt() {
        return iteNbt;
    }

    public void setIteNbt(Double iteNbt) {
        this.iteNbt = iteNbt;
    }

    @Basic
    @Column(name = "Ite_Btt", nullable = true, precision = 0)
    public Double getIteBtt() {
        return iteBtt;
    }

    public void setIteBtt(Double iteBtt) {
        this.iteBtt = iteBtt;
    }

    @Basic
    @Column(name = "Ite_Tax", nullable = true, precision = 0)
    public Double getIteTax() {
        return iteTax;
    }

    public void setIteTax(Double iteTax) {
        this.iteTax = iteTax;
    }

    @Basic
    @Column(name = "ChartOfAcc", nullable = true, length = 45)
    public String getChartOfAcc() {
        return chartOfAcc;
    }

    public void setChartOfAcc(String chartOfAcc) {
        this.chartOfAcc = chartOfAcc;
    }

    @Basic
    @Column(name = "Store", nullable = true, precision = 0)
    public Double getStore() {
        return store;
    }

    public void setStore(Double store) {
        this.store = store;
    }

    @Basic
    @Column(name = "Zone", nullable = true, precision = 0)
    public Double getZone() {
        return zone;
    }

    public void setZone(Double zone) {
        this.zone = zone;
    }

    @Basic
    @Column(name = "Bin", nullable = true, precision = 0)
    public Double getBin() {
        return bin;
    }

    public void setBin(Double bin) {
        this.bin = bin;
    }

    @Basic
    @Column(name = "empNo", nullable = true, precision = 0)
    public Double getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Double empNo) {
        this.empNo = empNo;
    }

    @Basic
    @Column(name = "partNo", nullable = true, length = 765)
    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    @Basic
    @Column(name = "NoOfQty", nullable = true, precision = 0)
    public Double getNoOfQty() {
        return noOfQty;
    }

    public void setNoOfQty(Double noOfQty) {
        this.noOfQty = noOfQty;
    }

    @Basic
    @Column(name = "PosItemName", nullable = true, length = 100)
    public String getPosItemName() {
        return posItemName;
    }

    public void setPosItemName(String posItemName) {
        this.posItemName = posItemName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (iteNo != null ? !iteNo.equals(item.iteNo) : item.iteNo != null) return false;
        if (cat3No != null ? !cat3No.equals(item.cat3No) : item.cat3No != null) return false;
        if (cat1No != null ? !cat1No.equals(item.cat1No) : item.cat1No != null) return false;
        if (cat2No != null ? !cat2No.equals(item.cat2No) : item.cat2No != null) return false;
        if (iteName != null ? !iteName.equals(item.iteName) : item.iteName != null) return false;
        if (iteDescription != null ? !iteDescription.equals(item.iteDescription) : item.iteDescription != null)
            return false;
        if (unitType != null ? !unitType.equals(item.unitType) : item.unitType != null) return false;
        if (iteReorderQty != null ? !iteReorderQty.equals(item.iteReorderQty) : item.iteReorderQty != null)
            return false;
        if (iteReorderLevel != null ? !iteReorderLevel.equals(item.iteReorderLevel) : item.iteReorderLevel != null)
            return false;
        if (iteMin != null ? !iteMin.equals(item.iteMin) : item.iteMin != null) return false;
        if (iteMax != null ? !iteMax.equals(item.iteMax) : item.iteMax != null) return false;
        if (iteActive != null ? !iteActive.equals(item.iteActive) : item.iteActive != null) return false;
        if (iteVat != null ? !iteVat.equals(item.iteVat) : item.iteVat != null) return false;
        if (iteNbt != null ? !iteNbt.equals(item.iteNbt) : item.iteNbt != null) return false;
        if (iteBtt != null ? !iteBtt.equals(item.iteBtt) : item.iteBtt != null) return false;
        if (iteTax != null ? !iteTax.equals(item.iteTax) : item.iteTax != null) return false;
        if (chartOfAcc != null ? !chartOfAcc.equals(item.chartOfAcc) : item.chartOfAcc != null) return false;
        if (store != null ? !store.equals(item.store) : item.store != null) return false;
        if (zone != null ? !zone.equals(item.zone) : item.zone != null) return false;
        if (bin != null ? !bin.equals(item.bin) : item.bin != null) return false;
        if (empNo != null ? !empNo.equals(item.empNo) : item.empNo != null) return false;
        if (partNo != null ? !partNo.equals(item.partNo) : item.partNo != null) return false;
        if (noOfQty != null ? !noOfQty.equals(item.noOfQty) : item.noOfQty != null) return false;
        if (posItemName != null ? !posItemName.equals(item.posItemName) : item.posItemName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iteNo != null ? iteNo.hashCode() : 0;
        result = 31 * result + (cat3No != null ? cat3No.hashCode() : 0);
        result = 31 * result + (cat1No != null ? cat1No.hashCode() : 0);
        result = 31 * result + (cat2No != null ? cat2No.hashCode() : 0);
        result = 31 * result + (iteName != null ? iteName.hashCode() : 0);
        result = 31 * result + (iteDescription != null ? iteDescription.hashCode() : 0);
        result = 31 * result + (unitType != null ? unitType.hashCode() : 0);
        result = 31 * result + (iteReorderQty != null ? iteReorderQty.hashCode() : 0);
        result = 31 * result + (iteReorderLevel != null ? iteReorderLevel.hashCode() : 0);
        result = 31 * result + (iteMin != null ? iteMin.hashCode() : 0);
        result = 31 * result + (iteMax != null ? iteMax.hashCode() : 0);
        result = 31 * result + (iteActive != null ? iteActive.hashCode() : 0);
        result = 31 * result + (iteVat != null ? iteVat.hashCode() : 0);
        result = 31 * result + (iteNbt != null ? iteNbt.hashCode() : 0);
        result = 31 * result + (iteBtt != null ? iteBtt.hashCode() : 0);
        result = 31 * result + (iteTax != null ? iteTax.hashCode() : 0);
        result = 31 * result + (chartOfAcc != null ? chartOfAcc.hashCode() : 0);
        result = 31 * result + (store != null ? store.hashCode() : 0);
        result = 31 * result + (zone != null ? zone.hashCode() : 0);
        result = 31 * result + (bin != null ? bin.hashCode() : 0);
        result = 31 * result + (empNo != null ? empNo.hashCode() : 0);
        result = 31 * result + (partNo != null ? partNo.hashCode() : 0);
        result = 31 * result + (noOfQty != null ? noOfQty.hashCode() : 0);
        result = 31 * result + (posItemName != null ? posItemName.hashCode() : 0);
        return result;
    }
}
