package com.ites.poswebservice.model.hotelpos;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by sancwk on 1/20/17.
 */
@Entity
@Table(name = "tax_class_taxes", catalog = "")
public class TaxClassTaxes {
    private int pkNo;
    private Integer taxClassNo;
    private Integer taxNo;
    private Integer userId;
    private Timestamp currDate;

    @Id
    @Column(name = "Pk_No", nullable = false)
    public int getPkNo() {
        return pkNo;
    }

    public void setPkNo(int pkNo) {
        this.pkNo = pkNo;
    }

    @Basic
    @Column(name = "Tax_Class_No", nullable = true)
    public Integer getTaxClassNo() {
        return taxClassNo;
    }

    public void setTaxClassNo(Integer taxClassNo) {
        this.taxClassNo = taxClassNo;
    }

    @Basic
    @Column(name = "Tax_No", nullable = true)
    public Integer getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(Integer taxNo) {
        this.taxNo = taxNo;
    }

    @Basic
    @Column(name = "User_ID", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Curr_Date", nullable = true)
    public Timestamp getCurrDate() {
        return currDate;
    }

    public void setCurrDate(Timestamp currDate) {
        this.currDate = currDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxClassTaxes that = (TaxClassTaxes) o;

        if (pkNo != that.pkNo) return false;
        if (taxClassNo != null ? !taxClassNo.equals(that.taxClassNo) : that.taxClassNo != null) return false;
        if (taxNo != null ? !taxNo.equals(that.taxNo) : that.taxNo != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (currDate != null ? !currDate.equals(that.currDate) : that.currDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkNo;
        result = 31 * result + (taxClassNo != null ? taxClassNo.hashCode() : 0);
        result = 31 * result + (taxNo != null ? taxNo.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (currDate != null ? currDate.hashCode() : 0);
        return result;
    }
}
