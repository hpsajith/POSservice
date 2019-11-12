package com.ites.poswebservice.model.hotelinventory;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by sancwk on 1/19/17.
 */
@Entity
@Table(name = "bin_out_d_pos", schema = "hotelinventory", catalog = "")
public class BinOutDPos {
    private int binNo;
    private String refNo;
    private Date strDate;
    private String itemNo;
    private Double outQty;
    private String description;
    private Integer outState;
    private Integer user;
    private Integer subSep;
    private int binOutNo;
    private String grnCode;
    private String serialNo;
    private Date grnDate;
    private Integer binInNo;
    private Integer posUser;
    private Integer pos;

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
    @Column(name = "Out_Qty", nullable = true, precision = 0)
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
    @Column(name = "binOutNo", nullable = false)
    public int getBinOutNo() {
        return binOutNo;
    }

    public void setBinOutNo(int binOutNo) {
        this.binOutNo = binOutNo;
    }

    @Basic
    @Column(name = "GrnCode", nullable = true, length = 125)
    public String getGrnCode() {
        return grnCode;
    }

    public void setGrnCode(String grnCode) {
        this.grnCode = grnCode;
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
    @Column(name = "binIn_No", nullable = true)
    public Integer getBinInNo() {
        return binInNo;
    }

    public void setBinInNo(Integer binInNo) {
        this.binInNo = binInNo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BinOutDPos that = (BinOutDPos) o;

        if (binNo != that.binNo) return false;
        if (binOutNo != that.binOutNo) return false;
        if (refNo != null ? !refNo.equals(that.refNo) : that.refNo != null) return false;
        if (strDate != null ? !strDate.equals(that.strDate) : that.strDate != null) return false;
        if (itemNo != null ? !itemNo.equals(that.itemNo) : that.itemNo != null) return false;
        if (outQty != null ? !outQty.equals(that.outQty) : that.outQty != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (outState != null ? !outState.equals(that.outState) : that.outState != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        if (subSep != null ? !subSep.equals(that.subSep) : that.subSep != null) return false;
        if (grnCode != null ? !grnCode.equals(that.grnCode) : that.grnCode != null) return false;
        if (serialNo != null ? !serialNo.equals(that.serialNo) : that.serialNo != null) return false;
        if (grnDate != null ? !grnDate.equals(that.grnDate) : that.grnDate != null) return false;
        if (binInNo != null ? !binInNo.equals(that.binInNo) : that.binInNo != null) return false;
        if (posUser != null ? !posUser.equals(that.posUser) : that.posUser != null) return false;
        if (pos != null ? !pos.equals(that.pos) : that.pos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = binNo;
        result = 31 * result + (refNo != null ? refNo.hashCode() : 0);
        result = 31 * result + (strDate != null ? strDate.hashCode() : 0);
        result = 31 * result + (itemNo != null ? itemNo.hashCode() : 0);
        result = 31 * result + (outQty != null ? outQty.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (outState != null ? outState.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (subSep != null ? subSep.hashCode() : 0);
        result = 31 * result + binOutNo;
        result = 31 * result + (grnCode != null ? grnCode.hashCode() : 0);
        result = 31 * result + (serialNo != null ? serialNo.hashCode() : 0);
        result = 31 * result + (grnDate != null ? grnDate.hashCode() : 0);
        result = 31 * result + (binInNo != null ? binInNo.hashCode() : 0);
        result = 31 * result + (posUser != null ? posUser.hashCode() : 0);
        result = 31 * result + (pos != null ? pos.hashCode() : 0);
        return result;
    }
}
