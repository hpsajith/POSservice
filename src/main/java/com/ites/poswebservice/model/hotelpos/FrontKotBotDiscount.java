package com.ites.poswebservice.model.hotelpos;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by sancwk on 1/9/17.
 */
@Entity
@Table(name = "front_kot_bot_discount", catalog = "")
public class FrontKotBotDiscount {
    private int discountNo;
    private Integer kotBotNo;
    private Integer disvountType;
    private Double value;
    private Timestamp cdate;
    private Integer userId;
    private String remark;
    private Integer valueType;
    private Integer isFamily;
    private Integer itemNo;
    private Integer frompms;
    private Integer haveTotalBillDis;

    @Id
    @Column(name = "discount_no", nullable = false)
    public int getDiscountNo() {
        return discountNo;
    }

    public void setDiscountNo(int discountNo) {
        this.discountNo = discountNo;
    }

    @Basic
    @Column(name = "kot_bot_no", nullable = true)
    public Integer getKotBotNo() {
        return kotBotNo;
    }

    public void setKotBotNo(Integer kotBotNo) {
        this.kotBotNo = kotBotNo;
    }

    @Basic
    @Column(name = "disvount_type", nullable = true)
    public Integer getDisvountType() {
        return disvountType;
    }

    public void setDisvountType(Integer disvountType) {
        this.disvountType = disvountType;
    }

    @Basic
    @Column(name = "value", nullable = true, precision = 0)
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Basic
    @Column(name = "cdate", nullable = true)
    public Timestamp getCdate() {
        return cdate;
    }

    public void setCdate(Timestamp cdate) {
        this.cdate = cdate;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 100)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "ValueType", nullable = true)
    public Integer getValueType() {
        return valueType;
    }

    public void setValueType(Integer valueType) {
        this.valueType = valueType;
    }

    @Basic
    @Column(name = "isFamily", nullable = true)
    public Integer getIsFamily() {
        return isFamily;
    }

    public void setIsFamily(Integer isFamily) {
        this.isFamily = isFamily;
    }

    @Basic
    @Column(name = "item_no", nullable = true)
    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    @Basic
    @Column(name = "frompms", nullable = true)
    public Integer getFrompms() {
        return frompms;
    }

    public void setFrompms(Integer frompms) {
        this.frompms = frompms;
    }

    @Basic
    @Column(name = "haveTotalBillDis", nullable = true)
    public Integer getHaveTotalBillDis() {
        return haveTotalBillDis;
    }

    public void setHaveTotalBillDis(Integer haveTotalBillDis) {
        this.haveTotalBillDis = haveTotalBillDis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FrontKotBotDiscount that = (FrontKotBotDiscount) o;

        if (discountNo != that.discountNo) return false;
        if (kotBotNo != null ? !kotBotNo.equals(that.kotBotNo) : that.kotBotNo != null) return false;
        if (disvountType != null ? !disvountType.equals(that.disvountType) : that.disvountType != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
        if (cdate != null ? !cdate.equals(that.cdate) : that.cdate != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (valueType != null ? !valueType.equals(that.valueType) : that.valueType != null) return false;
        if (isFamily != null ? !isFamily.equals(that.isFamily) : that.isFamily != null) return false;
        if (itemNo != null ? !itemNo.equals(that.itemNo) : that.itemNo != null) return false;
        if (frompms != null ? !frompms.equals(that.frompms) : that.frompms != null) return false;
        if (haveTotalBillDis != null ? !haveTotalBillDis.equals(that.haveTotalBillDis) : that.haveTotalBillDis != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = discountNo;
        result = 31 * result + (kotBotNo != null ? kotBotNo.hashCode() : 0);
        result = 31 * result + (disvountType != null ? disvountType.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (cdate != null ? cdate.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (valueType != null ? valueType.hashCode() : 0);
        result = 31 * result + (isFamily != null ? isFamily.hashCode() : 0);
        result = 31 * result + (itemNo != null ? itemNo.hashCode() : 0);
        result = 31 * result + (frompms != null ? frompms.hashCode() : 0);
        result = 31 * result + (haveTotalBillDis != null ? haveTotalBillDis.hashCode() : 0);
        return result;
    }
}
