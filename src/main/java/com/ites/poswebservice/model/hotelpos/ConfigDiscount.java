package com.ites.poswebservice.model.hotelpos;

import javax.persistence.*;

/**
 * Created by sancwk on 1/9/17.
 */
@Entity
@Table(name = "config_discount", catalog = "")
public class ConfigDiscount {
    private int disNo;
    private Integer familyNo;
    private String disPosName;
    private String disBillName;
    private Integer disType;
    private Double disPercentage;
    private Double disValue;
    private String accountNo;
    private Integer isFamily;

    @Id
    @Column(name = "DisNo", nullable = false)
    public int getDisNo() {
        return disNo;
    }

    public void setDisNo(int disNo) {
        this.disNo = disNo;
    }

    @Basic
    @Column(name = "FamilyNo", nullable = true)
    public Integer getFamilyNo() {
        return familyNo;
    }

    public void setFamilyNo(Integer familyNo) {
        this.familyNo = familyNo;
    }

    @Basic
    @Column(name = "DisPosName", nullable = true, length = 20)
    public String getDisPosName() {
        return disPosName;
    }

    public void setDisPosName(String disPosName) {
        this.disPosName = disPosName;
    }

    @Basic
    @Column(name = "DisBillName", nullable = true, length = 20)
    public String getDisBillName() {
        return disBillName;
    }

    public void setDisBillName(String disBillName) {
        this.disBillName = disBillName;
    }

    @Basic
    @Column(name = "DisType", nullable = true)
    public Integer getDisType() {
        return disType;
    }

    public void setDisType(Integer disType) {
        this.disType = disType;
    }

    @Basic
    @Column(name = "DisPercentage", nullable = true, precision = 0)
    public Double getDisPercentage() {
        return disPercentage;
    }

    public void setDisPercentage(Double disPercentage) {
        this.disPercentage = disPercentage;
    }

    @Basic
    @Column(name = "DisValue", nullable = true, precision = 0)
    public Double getDisValue() {
        return disValue;
    }

    public void setDisValue(Double disValue) {
        this.disValue = disValue;
    }

    @Basic
    @Column(name = "AccountNo", nullable = true, length = 255)
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Basic
    @Column(name = "isFamily", nullable = true)
    public Integer getIsFamily() {
        return isFamily;
    }

    public void setIsFamily(Integer isFamily) {
        this.isFamily = isFamily;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfigDiscount that = (ConfigDiscount) o;

        if (disNo != that.disNo) return false;
        if (familyNo != null ? !familyNo.equals(that.familyNo) : that.familyNo != null) return false;
        if (disPosName != null ? !disPosName.equals(that.disPosName) : that.disPosName != null) return false;
        if (disBillName != null ? !disBillName.equals(that.disBillName) : that.disBillName != null) return false;
        if (disType != null ? !disType.equals(that.disType) : that.disType != null) return false;
        if (disPercentage != null ? !disPercentage.equals(that.disPercentage) : that.disPercentage != null)
            return false;
        if (disValue != null ? !disValue.equals(that.disValue) : that.disValue != null) return false;
        if (accountNo != null ? !accountNo.equals(that.accountNo) : that.accountNo != null) return false;
        if (isFamily != null ? !isFamily.equals(that.isFamily) : that.isFamily != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = disNo;
        result = 31 * result + (familyNo != null ? familyNo.hashCode() : 0);
        result = 31 * result + (disPosName != null ? disPosName.hashCode() : 0);
        result = 31 * result + (disBillName != null ? disBillName.hashCode() : 0);
        result = 31 * result + (disType != null ? disType.hashCode() : 0);
        result = 31 * result + (disPercentage != null ? disPercentage.hashCode() : 0);
        result = 31 * result + (disValue != null ? disValue.hashCode() : 0);
        result = 31 * result + (accountNo != null ? accountNo.hashCode() : 0);
        result = 31 * result + (isFamily != null ? isFamily.hashCode() : 0);
        return result;
    }
}
