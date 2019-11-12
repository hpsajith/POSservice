package com.ites.poswebservice.model.hotelinventory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by wannix on 1/5/17.
 */
@Entity
@Table(name = "substore_in_d", schema = "hotelinventory", catalog = "")
public class SubstoreInD {
    private int subInNo;
    private int binNo;
    private String refNo;
    private Integer stoNo;
    private Integer subStoNo;
    private Date inDate;
    private Double inQty;
    private String iteNo;
    private Double balQty;
    private Integer active;
    private Date expireDate;
    private Integer user;
    private Integer subDep;
    private Integer inState;
    private String description;
    private Double unitPrice;
    private String chartOfAcc;
    private String serial;
    private BigDecimal disrate;
    private Timestamp dateTime;
    private String grnCode;
    private Integer binInNo;

    @Id
    @Column(name = "SubIn_No", nullable = false)
    public int getSubInNo() {
        return subInNo;
    }

    public void setSubInNo(int subInNo) {
        this.subInNo = subInNo;
    }

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
    @Column(name = "Sub_StoNo", nullable = true)
    public Integer getSubStoNo() {
        return subStoNo;
    }

    public void setSubStoNo(Integer subStoNo) {
        this.subStoNo = subStoNo;
    }

    @Basic
    @Column(name = "In_Date", nullable = true)
    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    @Basic
    @Column(name = "In_qty", nullable = true, precision = 4)
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
    @Column(name = "bal_qty", nullable = true, precision = 4)
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

    @Basic
    @Column(name = "UnitPrice", nullable = true, precision = 4)
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
    @Column(name = "disrate", nullable = true, precision = 2)
    public BigDecimal getDisrate() {
        return disrate;
    }

    public void setDisrate(BigDecimal disrate) {
        this.disrate = disrate;
    }

    @Basic
    @Column(name = "Date_Time", nullable = true)
    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Basic
    @Column(name = "grn_code", nullable = true, length = 100)
    public String getGrnCode() {
        return grnCode;
    }

    public void setGrnCode(String grnCode) {
        this.grnCode = grnCode;
    }

    @Basic
    @Column(name = "binIn_No", nullable = true)
    public Integer getBinInNo() {
        return binInNo;
    }

    public void setBinInNo(Integer binInNo) {
        this.binInNo = binInNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubstoreInD that = (SubstoreInD) o;

        if (subInNo != that.subInNo) return false;
        if (binNo != that.binNo) return false;
        if (refNo != null ? !refNo.equals(that.refNo) : that.refNo != null) return false;
        if (stoNo != null ? !stoNo.equals(that.stoNo) : that.stoNo != null) return false;
        if (subStoNo != null ? !subStoNo.equals(that.subStoNo) : that.subStoNo != null) return false;
        if (inDate != null ? !inDate.equals(that.inDate) : that.inDate != null) return false;
        if (inQty != null ? !inQty.equals(that.inQty) : that.inQty != null) return false;
        if (iteNo != null ? !iteNo.equals(that.iteNo) : that.iteNo != null) return false;
        if (balQty != null ? !balQty.equals(that.balQty) : that.balQty != null) return false;
        if (active != null ? !active.equals(that.active) : that.active != null) return false;
        if (expireDate != null ? !expireDate.equals(that.expireDate) : that.expireDate != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (subDep != null ? !subDep.equals(that.subDep) : that.subDep != null) return false;
        if (inState != null ? !inState.equals(that.inState) : that.inState != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (unitPrice != null ? !unitPrice.equals(that.unitPrice) : that.unitPrice != null) return false;
        if (chartOfAcc != null ? !chartOfAcc.equals(that.chartOfAcc) : that.chartOfAcc != null) return false;
        if (serial != null ? !serial.equals(that.serial) : that.serial != null) return false;
        if (disrate != null ? !disrate.equals(that.disrate) : that.disrate != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (grnCode != null ? !grnCode.equals(that.grnCode) : that.grnCode != null) return false;
        if (binInNo != null ? !binInNo.equals(that.binInNo) : that.binInNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subInNo;
        result = 31 * result + binNo;
        result = 31 * result + (refNo != null ? refNo.hashCode() : 0);
        result = 31 * result + (stoNo != null ? stoNo.hashCode() : 0);
        result = 31 * result + (subStoNo != null ? subStoNo.hashCode() : 0);
        result = 31 * result + (inDate != null ? inDate.hashCode() : 0);
        result = 31 * result + (inQty != null ? inQty.hashCode() : 0);
        result = 31 * result + (iteNo != null ? iteNo.hashCode() : 0);
        result = 31 * result + (balQty != null ? balQty.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (expireDate != null ? expireDate.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (subDep != null ? subDep.hashCode() : 0);
        result = 31 * result + (inState != null ? inState.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (chartOfAcc != null ? chartOfAcc.hashCode() : 0);
        result = 31 * result + (serial != null ? serial.hashCode() : 0);
        result = 31 * result + (disrate != null ? disrate.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (grnCode != null ? grnCode.hashCode() : 0);
        result = 31 * result + (binInNo != null ? binInNo.hashCode() : 0);
        return result;
    }
}
