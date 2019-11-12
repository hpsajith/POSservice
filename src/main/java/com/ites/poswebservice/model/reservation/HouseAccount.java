/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.reservation;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "house_account")
@NamedQueries({
    @NamedQuery(name = "HouseAccount.findAll", query = "SELECT h FROM HouseAccount h")})
public class HouseAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "H_Account_ID")
    private Integer hAccountID;
    @Size(max = 10)
    @Column(name = "Account_No")
    private String accountNo;
    @Size(max = 250)
    @Column(name = "Status")
    private String status;
    @Size(max = 250)
    @Column(name = "Company")
    private String company;
    @Size(max = 250)
    @Column(name = "EmployeeName")
    private String employeeName;
    @Size(max = 100)
    @Column(name = "EmployeeNo")
    private String employeeNo;
    @Size(max = 100)
    @Column(name = "Address1")
    private String address1;
    @Size(max = 100)
    @Column(name = "Address2")
    private String address2;
    @Size(max = 15)
    @Column(name = "Phone1")
    private String phone1;
    @Size(max = 15)
    @Column(name = "Phone2")
    private String phone2;
    @Size(max = 15)
    @Column(name = "Mobile1")
    private String mobile1;
    @Size(max = 15)
    @Column(name = "Mobile2")
    private String mobile2;
    @Size(max = 15)
    @Column(name = "Fax1")
    private String fax1;
    @Size(max = 15)
    @Column(name = "Fax2")
    private String fax2;
    @Size(max = 15)
    @Column(name = "VAT_REGNO")
    private String vatRegno;
    @Size(max = 15)
    @Column(name = "VAT_STAT")
    private String vatStat;
    @Size(max = 100)
    @Column(name = "Contact_Person")
    private String contactPerson;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OUTBAL")
    private Double outbal;
    @Column(name = "CR_LIMIT")
    private Double crLimit;
    @Column(name = "CR_PERIOD")
    private Double crPeriod;
    @Column(name = "Acitve")
    private Integer acitve;
    @Size(max = 150)
    @Column(name = "TERM")
    private String term;

    public HouseAccount() {
    }

    public HouseAccount(Integer hAccountID) {
        this.hAccountID = hAccountID;
    }

    public Integer getHAccountID() {
        return hAccountID;
    }

    public void setHAccountID(Integer hAccountID) {
        this.hAccountID = hAccountID;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getFax1() {
        return fax1;
    }

    public void setFax1(String fax1) {
        this.fax1 = fax1;
    }

    public String getFax2() {
        return fax2;
    }

    public void setFax2(String fax2) {
        this.fax2 = fax2;
    }

    public String getVatRegno() {
        return vatRegno;
    }

    public void setVatRegno(String vatRegno) {
        this.vatRegno = vatRegno;
    }

    public String getVatStat() {
        return vatStat;
    }

    public void setVatStat(String vatStat) {
        this.vatStat = vatStat;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Double getOutbal() {
        return outbal;
    }

    public void setOutbal(Double outbal) {
        this.outbal = outbal;
    }

    public Double getCrLimit() {
        return crLimit;
    }

    public void setCrLimit(Double crLimit) {
        this.crLimit = crLimit;
    }

    public Double getCrPeriod() {
        return crPeriod;
    }

    public void setCrPeriod(Double crPeriod) {
        this.crPeriod = crPeriod;
    }

    public Integer getAcitve() {
        return acitve;
    }

    public void setAcitve(Integer acitve) {
        this.acitve = acitve;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hAccountID != null ? hAccountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HouseAccount)) {
            return false;
        }
        HouseAccount other = (HouseAccount) object;
        if ((this.hAccountID == null && other.hAccountID != null) || (this.hAccountID != null && !this.hAccountID.equals(other.hAccountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.reservation.HouseAccount[ hAccountID=" + hAccountID + " ]";
    }
    
}
