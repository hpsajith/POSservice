package com.ites.poswebservice.model.hotelfinance;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by sancwk on 1/19/17.
 */
@Entity
public class Inventoryposting {
    private int postingNo;
    private String referenceNo;
    private String accountNo;
    private Integer subDeptNo;
    private String description;
    private Integer creditDebit;
    private Double amount;
    private Double cAmount;
    private Double dAmount;
    private Date date;
    private Integer userId;
    private Timestamp currDateTime;
    private Integer postingState;
    private String postingType;
    private String itemNo;
    private Integer costFor;
    private String invNo;

    @Id
    @Column(name = "Posting_No", nullable = false)
    public int getPostingNo() {
        return postingNo;
    }

    public void setPostingNo(int postingNo) {
        this.postingNo = postingNo;
    }

    @Basic
    @Column(name = "Reference_No", nullable = true, length = 125)
    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    @Basic
    @Column(name = "Account_No", nullable = true, length = 100)
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Basic
    @Column(name = "Sub_Dept_No", nullable = true)
    public Integer getSubDeptNo() {
        return subDeptNo;
    }

    public void setSubDeptNo(Integer subDeptNo) {
        this.subDeptNo = subDeptNo;
    }

    @Basic
    @Column(name = "Description", nullable = true, length = 250)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Credit_Debit", nullable = true)
    public Integer getCreditDebit() {
        return creditDebit;
    }

    public void setCreditDebit(Integer creditDebit) {
        this.creditDebit = creditDebit;
    }

    @Basic
    @Column(name = "Amount", nullable = true, precision = 0)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "C_Amount", nullable = true, precision = 0)
    public Double getcAmount() {
        return cAmount;
    }

    public void setcAmount(Double cAmount) {
        this.cAmount = cAmount;
    }

    @Basic
    @Column(name = "D_Amount", nullable = true, precision = 0)
    public Double getdAmount() {
        return dAmount;
    }

    public void setdAmount(Double dAmount) {
        this.dAmount = dAmount;
    }

    @Basic
    @Column(name = "Date_", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "User_Id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Curr_Date_Time", nullable = true)
    public Timestamp getCurrDateTime() {
        return currDateTime;
    }

    public void setCurrDateTime(Timestamp currDateTime) {
        this.currDateTime = currDateTime;
    }

    @Basic
    @Column(name = "Posting_State", nullable = true)
    public Integer getPostingState() {
        return postingState;
    }

    public void setPostingState(Integer postingState) {
        this.postingState = postingState;
    }

    @Basic
    @Column(name = "Posting_Type", nullable = true, length = 10)
    public String getPostingType() {
        return postingType;
    }

    public void setPostingType(String postingType) {
        this.postingType = postingType;
    }

    @Basic
    @Column(name = "Item_No", nullable = true, length = 125)
    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    @Basic
    @Column(name = "CostFor", nullable = true)
    public Integer getCostFor() {
        return costFor;
    }

    public void setCostFor(Integer costFor) {
        this.costFor = costFor;
    }

    @Basic
    @Column(name = "inv_no", nullable = true, length = 100)
    public String getInvNo() {
        return invNo;
    }

    public void setInvNo(String invNo) {
        this.invNo = invNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventoryposting that = (Inventoryposting) o;

        if (postingNo != that.postingNo) return false;
        if (referenceNo != null ? !referenceNo.equals(that.referenceNo) : that.referenceNo != null) return false;
        if (accountNo != null ? !accountNo.equals(that.accountNo) : that.accountNo != null) return false;
        if (subDeptNo != null ? !subDeptNo.equals(that.subDeptNo) : that.subDeptNo != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (creditDebit != null ? !creditDebit.equals(that.creditDebit) : that.creditDebit != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (cAmount != null ? !cAmount.equals(that.cAmount) : that.cAmount != null) return false;
        if (dAmount != null ? !dAmount.equals(that.dAmount) : that.dAmount != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (currDateTime != null ? !currDateTime.equals(that.currDateTime) : that.currDateTime != null) return false;
        if (postingState != null ? !postingState.equals(that.postingState) : that.postingState != null) return false;
        if (postingType != null ? !postingType.equals(that.postingType) : that.postingType != null) return false;
        if (itemNo != null ? !itemNo.equals(that.itemNo) : that.itemNo != null) return false;
        if (costFor != null ? !costFor.equals(that.costFor) : that.costFor != null) return false;
        if (invNo != null ? !invNo.equals(that.invNo) : that.invNo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postingNo;
        result = 31 * result + (referenceNo != null ? referenceNo.hashCode() : 0);
        result = 31 * result + (accountNo != null ? accountNo.hashCode() : 0);
        result = 31 * result + (subDeptNo != null ? subDeptNo.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creditDebit != null ? creditDebit.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (cAmount != null ? cAmount.hashCode() : 0);
        result = 31 * result + (dAmount != null ? dAmount.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (currDateTime != null ? currDateTime.hashCode() : 0);
        result = 31 * result + (postingState != null ? postingState.hashCode() : 0);
        result = 31 * result + (postingType != null ? postingType.hashCode() : 0);
        result = 31 * result + (itemNo != null ? itemNo.hashCode() : 0);
        result = 31 * result + (costFor != null ? costFor.hashCode() : 0);
        result = 31 * result + (invNo != null ? invNo.hashCode() : 0);
        return result;
    }
}
