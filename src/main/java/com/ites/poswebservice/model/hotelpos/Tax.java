package com.ites.poswebservice.model.hotelpos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by sancwk on 1/20/17.
 */
@Entity
public class Tax {
    private int taxNo;
    private String taxName;
    private String discription;
    private Double rate;
    private Double taxCalculateValue;
    private Integer groopNo;
    private String accountNo;
    private Integer active;
    private Integer userId;
    private Timestamp currDate;

    @Id
    @Column(name = "TaxNo", nullable = false)
    public int getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(int taxNo) {
        this.taxNo = taxNo;
    }

    @Basic
    @Column(name = "TaxName", nullable = true, length = 500)
    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    @Basic
    @Column(name = "discription", nullable = true, length = 500)
    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Basic
    @Column(name = "Rate", nullable = true, precision = 0)
    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Basic
    @Column(name = "taxCalculateValue", nullable = true, precision = 0)
    public Double getTaxCalculateValue() {
        return taxCalculateValue;
    }

    public void setTaxCalculateValue(Double taxCalculateValue) {
        this.taxCalculateValue = taxCalculateValue;
    }

    @Basic
    @Column(name = "GroopNo", nullable = true)
    public Integer getGroopNo() {
        return groopNo;
    }

    public void setGroopNo(Integer groopNo) {
        this.groopNo = groopNo;
    }

    @Basic
    @Column(name = "Account_No", nullable = true, length = 50)
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
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

        Tax tax = (Tax) o;

        if (taxNo != tax.taxNo) return false;
        if (taxName != null ? !taxName.equals(tax.taxName) : tax.taxName != null) return false;
        if (discription != null ? !discription.equals(tax.discription) : tax.discription != null) return false;
        if (rate != null ? !rate.equals(tax.rate) : tax.rate != null) return false;
        if (taxCalculateValue != null ? !taxCalculateValue.equals(tax.taxCalculateValue) : tax.taxCalculateValue != null)
            return false;
        if (groopNo != null ? !groopNo.equals(tax.groopNo) : tax.groopNo != null) return false;
        if (accountNo != null ? !accountNo.equals(tax.accountNo) : tax.accountNo != null) return false;
        if (active != null ? !active.equals(tax.active) : tax.active != null) return false;
        if (userId != null ? !userId.equals(tax.userId) : tax.userId != null) return false;
        if (currDate != null ? !currDate.equals(tax.currDate) : tax.currDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taxNo;
        result = 31 * result + (taxName != null ? taxName.hashCode() : 0);
        result = 31 * result + (discription != null ? discription.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        result = 31 * result + (taxCalculateValue != null ? taxCalculateValue.hashCode() : 0);
        result = 31 * result + (groopNo != null ? groopNo.hashCode() : 0);
        result = 31 * result + (accountNo != null ? accountNo.hashCode() : 0);
        result = 31 * result + (active != null ? active.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (currDate != null ? currDate.hashCode() : 0);
        return result;
    }
}
