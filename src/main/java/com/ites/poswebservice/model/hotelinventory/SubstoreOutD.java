package com.ites.poswebservice.model.hotelinventory;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;

/**
 * Created by wannix on 1/5/17.
 */
@Entity
@Table(name = "substore_out_d", schema = "hotelinventory", catalog = "")
public class SubstoreOutD {
    private Integer stockno;
    private Integer subStockno;
    private int binNo;
    private String refNo;
    private Date strDate;
    private String itemNo;
    private Double outQty;
    private String description;
    private Integer outState;
    private Integer user;
    private Integer subSep;
    private int substoreOutNo;
    private String inCode;
    private String serialNo;
    private Date grnDate;
    private Integer substoreInNo;
    private Timestamp dateTime;
    private String grnCode;
    private Double unitPrice;
    private Integer binInNo;

    @Basic
    @Column(name = "stockno", nullable = true)
    public Integer getStockno() {
        return stockno;
    }

    public void setStockno(Integer stockno) {
        this.stockno = stockno;
    }

    @Basic
    @Column(name = "sub_stockno", nullable = true)
    public Integer getSubStockno() {
        return subStockno;
    }

    public void setSubStockno(Integer subStockno) {
        this.subStockno = subStockno;
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
    @Column(name = "Str_Date", nullable = false)
    public Date getStrDate() {
        return strDate;
    }

    public void setStrDate(Date strDate) {
        this.strDate = strDate;
    }

    @Basic
    @Column(name = "item_No", nullable = false, length = 50)
    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    @Basic
    @Column(name = "Out_Qty", nullable = true, precision = 4)
    public Double getOutQty() {
        return outQty;
    }

    public void setOutQty(Double outQty) {
        this.outQty = outQty;
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
    @Column(name = "outState", nullable = true)
    public Integer getOutState() {
        return outState;
    }

    public void setOutState(Integer outState) {
        this.outState = outState;
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
    @Column(name = "subSep", nullable = true)
    public Integer getSubSep() {
        return subSep;
    }

    public void setSubSep(Integer subSep) {
        this.subSep = subSep;
    }

    @Id
    @Column(name = "substore_OutNo", nullable = false)
    public int getSubstoreOutNo() {
        return substoreOutNo;
    }

    public void setSubstoreOutNo(int substoreOutNo) {
        this.substoreOutNo = substoreOutNo;
    }

    @Basic
    @Column(name = "InCode", nullable = true, length = 125)
    public String getInCode() {
        return inCode;
    }

    public void setInCode(String inCode) {
        this.inCode = inCode;
    }

    @Basic
    @Column(name = "serialNo", nullable = true, length = 255)
    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    @Basic
    @Column(name = "GrnDate", nullable = true)
    public Date getGrnDate() {
        return grnDate;
    }

    public void setGrnDate(Date grnDate) {
        this.grnDate = grnDate;
    }

    @Basic
    @Column(name = "substore_In_No", nullable = true)
    public Integer getSubstoreInNo() {
        return substoreInNo;
    }

    public void setSubstoreInNo(Integer substoreInNo) {
        this.substoreInNo = substoreInNo;
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
    @Column(name = "unit_price", nullable = true, precision = 4)
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
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

        SubstoreOutD that = (SubstoreOutD) o;

        if (binNo != that.binNo) return false;
        if (substoreOutNo != that.substoreOutNo) return false;
        if (stockno != null ? !stockno.equals(that.stockno) : that.stockno != null) return false;
        if (subStockno != null ? !subStockno.equals(that.subStockno) : that.subStockno != null) return false;
        if (refNo != null ? !refNo.equals(that.refNo) : that.refNo != null) return false;
        if (strDate != null ? !strDate.equals(that.strDate) : that.strDate != null) return false;
        if (itemNo != null ? !itemNo.equals(that.itemNo) : that.itemNo != null) return false;
        if (outQty != null ? !outQty.equals(that.outQty) : that.outQty != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (outState != null ? !outState.equals(that.outState) : that.outState != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (subSep != null ? !subSep.equals(that.subSep) : that.subSep != null) return false;
        if (inCode != null ? !inCode.equals(that.inCode) : that.inCode != null) return false;
        if (serialNo != null ? !serialNo.equals(that.serialNo) : that.serialNo != null) return false;
        if (grnDate != null ? !grnDate.equals(that.grnDate) : that.grnDate != null) return false;
        if (substoreInNo != null ? !substoreInNo.equals(that.substoreInNo) : that.substoreInNo != null) return false;
        if (dateTime != null ? !dateTime.equals(that.dateTime) : that.dateTime != null) return false;
        if (grnCode != null ? !grnCode.equals(that.grnCode) : that.grnCode != null) return false;
        if (unitPrice != null ? !unitPrice.equals(that.unitPrice) : that.unitPrice != null) return false;
        if (binInNo != null ? !binInNo.equals(that.binInNo) : that.binInNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockno != null ? stockno.hashCode() : 0;
        result = 31 * result + (subStockno != null ? subStockno.hashCode() : 0);
        result = 31 * result + binNo;
        result = 31 * result + (refNo != null ? refNo.hashCode() : 0);
        result = 31 * result + (strDate != null ? strDate.hashCode() : 0);
        result = 31 * result + (itemNo != null ? itemNo.hashCode() : 0);
        result = 31 * result + (outQty != null ? outQty.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (outState != null ? outState.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (subSep != null ? subSep.hashCode() : 0);
        result = 31 * result + substoreOutNo;
        result = 31 * result + (inCode != null ? inCode.hashCode() : 0);
        result = 31 * result + (serialNo != null ? serialNo.hashCode() : 0);
        result = 31 * result + (grnDate != null ? grnDate.hashCode() : 0);
        result = 31 * result + (substoreInNo != null ? substoreInNo.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        result = 31 * result + (grnCode != null ? grnCode.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (binInNo != null ? binInNo.hashCode() : 0);
        return result;
    }
}
