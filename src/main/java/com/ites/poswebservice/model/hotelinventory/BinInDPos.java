package com.ites.poswebservice.model.hotelinventory;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by sancwk on 1/23/17.
 */
@Entity
@Table(name = "bin_in_d_pos", schema = "hotelinventory", catalog = "")
public class BinInDPos {
    private int binNo;
    private String refNo;
    private Integer stoNo;
    private Date grnDate;
    private Double inQty;
    private String iteNo;
    private Double balQty;
    private Integer active;
    private Date expireDate;
    private Integer user;
    private Integer subDep;
    private Integer inState;
    private String description;
    private int binInNo;
    private Double unitPrice;
    private String chartOfAcc;
    private String serial;
    private Integer posUser;
    private Integer pos;
    private Integer noOfQty;
    private Integer noOfTotQty;

    @Basic
    @Column(name = "binNo", nullable = false)
    public int getBinNo() {
        return binNo;
    }

    public void setBinNo(int binNo) {
        this.binNo = binNo;
    }

    @Basic
    @Column(name = "RefNo", nullable = false, length = 125)
    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    @Basic
    @Column(name = "StoNo", nullable = true)
    public Integer getStoNo() {
        return stoNo;
    }

    public void setStoNo(Integer stoNo) {
        this.stoNo = stoNo;
    }

    @Basic
    @Column(name = "Grn_Date", nullable = true)
    public Date getGrnDate() {
        return grnDate;
    }

    public void setGrnDate(Date grnDate) {
        this.grnDate = grnDate;
    }

    @Basic
    @Column(name = "In_qty", nullable = true, precision = 0)
    public Double getInQty() {
        return inQty;
    }

    public void setInQty(Double inQty) {
        this.inQty = inQty;
    }

    @Basic
    @Column(name = "ite_No", nullable = false, length = 50)
    public String getIteNo() {
        return iteNo;
    }

    public void setIteNo(String iteNo) {
        this.iteNo = iteNo;
    }

    @Basic
    @Column(name = "bal_qty", nullable = true, precision = 0)
    public Double getBalQty() {
        return balQty;
    }

    public void setBalQty(Double balQty) {
        this.balQty = balQty;
    }

    @Basic
    @Column(name = "active", nullable = true)
    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    @Basic
    @Column(name = "expire_date", nullable = true)
    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Basic
    @Column(name = "user", nullable = true)
    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    @Basic
    @Column(name = "subDep", nullable = true)
    public Integer getSubDep() {
        return subDep;
    }

    public void setSubDep(Integer subDep) {
        this.subDep = subDep;
    }

    @Basic
    @Column(name = "InState", nullable = true)
    public Integer getInState() {
        return inState;
    }

    public void setInState(Integer inState) {
        this.inState = inState;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @Column(name = "binIn_No", nullable = false)
    public int getBinInNo() {
        return binInNo;
    }

    public void setBinInNo(int binInNo) {
        this.binInNo = binInNo;
    }

    @Basic
    @Column(name = "UnitPrice", nullable = true, precision = 0)
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "ChartOfAcc", nullable = true, length = 50)
    public String getChartOfAcc() {
        return chartOfAcc;
    }

    public void setChartOfAcc(String chartOfAcc) {
        this.chartOfAcc = chartOfAcc;
    }

    @Basic
    @Column(name = "serial", nullable = true, length = 100)
    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Basic
    @Column(name = "PosUser", nullable = true)
    public Integer getPosUser() {
        return posUser;
    }

    public void setPosUser(Integer posUser) {
        this.posUser = posUser;
    }

    @Basic
    @Column(name = "Pos", nullable = true)
    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    @Basic
    @Column(name = "NoOfQty", nullable = true)
    public Integer getNoOfQty() {
        return noOfQty;
    }

    public void setNoOfQty(Integer noOfQty) {
        this.noOfQty = noOfQty;
    }

    @Basic
    @Column(name = "NoOfTotQty", nullable = true)
    public Integer getNoOfTotQty() {
        return noOfTotQty;
    }

    public void setNoOfTotQty(Integer noOfTotQty) {
        this.noOfTotQty = noOfTotQty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinInDPos binInDPos = (BinInDPos) o;

        if (binNo != binInDPos.binNo) return false;
        if (binInNo != binInDPos.binInNo) return false;
        if (refNo != null ? !refNo.equals(binInDPos.refNo) : binInDPos.refNo != null) return false;
        if (stoNo != null ? !stoNo.equals(binInDPos.stoNo) : binInDPos.stoNo != null) return false;
        if (grnDate != null ? !grnDate.equals(binInDPos.grnDate) : binInDPos.grnDate != null) return false;
        if (inQty != null ? !inQty.equals(binInDPos.inQty) : binInDPos.inQty != null) return false;
        if (iteNo != null ? !iteNo.equals(binInDPos.iteNo) : binInDPos.iteNo != null) return false;
        if (balQty != null ? !balQty.equals(binInDPos.balQty) : binInDPos.balQty != null) return false;
        if (active != null ? !active.equals(binInDPos.active) : binInDPos.active != null) return false;
        if (expireDate != null ? !expireDate.equals(binInDPos.expireDate) : binInDPos.expireDate != null) return false;
        if (user != null ? !user.equals(binInDPos.user) : binInDPos.user != null) return false;
        if (subDep != null ? !subDep.equals(binInDPos.subDep) : binInDPos.subDep != null) return false;
        if (inState != null ? !inState.equals(binInDPos.inState) : binInDPos.inState != null) return false;
        if (description != null ? !description.equals(binInDPos.description) : binInDPos.description != null)
            return false;
        if (unitPrice != null ? !unitPrice.equals(binInDPos.unitPrice) : binInDPos.unitPrice != null) return false;
        if (chartOfAcc != null ? !chartOfAcc.equals(binInDPos.chartOfAcc) : binInDPos.chartOfAcc != null) return false;
        if (serial != null ? !serial.equals(binInDPos.serial) : binInDPos.serial != null) return false;
        if (posUser != null ? !posUser.equals(binInDPos.posUser) : binInDPos.posUser != null) return false;
        if (pos != null ? !pos.equals(binInDPos.pos) : binInDPos.pos != null) return false;
        if (noOfQty != null ? !noOfQty.equals(binInDPos.noOfQty) : binInDPos.noOfQty != null) return false;
        if (noOfTotQty != null ? !noOfTotQty.equals(binInDPos.noOfTotQty) : binInDPos.noOfTotQty != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = binNo;
        result = 31 * result + (refNo != null ? refNo.hashCode() : 0);
        result = 31 * result + (stoNo != null ? stoNo.hashCode() : 0);
        result = 31 * result + (grnDate != null ? grnDate.hashCode() : 0);
        result = 31 * result + (inQty != null ? inQty.hashCode() : 0);
        result = 31 * result + (iteNo != null ? iteNo.hashCode() : 0);
        result = 31 * result + (balQty != null ? balQty.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (subDep != null ? subDep.hashCode() : 0);
        result = 31 * result + (inState != null ? inState.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + binInNo;
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (chartOfAcc != null ? chartOfAcc.hashCode() : 0);
        result = 31 * result + (serial != null ? serial.hashCode() : 0);
        result = 31 * result + (posUser != null ? posUser.hashCode() : 0);
        result = 31 * result + (pos != null ? pos.hashCode() : 0);
        result = 31 * result + (noOfQty != null ? noOfQty.hashCode() : 0);
        result = 31 * result + (noOfTotQty != null ? noOfTotQty.hashCode() : 0);
        return result;
    }
}
