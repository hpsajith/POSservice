package com.ites.poswebservice.model.hotelpos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;

/**
 * Created by sancwk on 2/1/17.
 */
@Entity
public class Company {
    private int pkNo;
    private String companyName;
    private String address;
    private String telephone;
    private String email;
    private String vatReg;
    private byte[] logo;
    private Integer billFormat;

    @Id
    @Column(name = "PkNo", nullable = false)
    public int getPkNo() {
        return pkNo;
    }

    public void setPkNo(int pkNo) {
        this.pkNo = pkNo;
    }

    @Basic
    @Column(name = "CompanyName", nullable = true, length = 255)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "Address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Telephone", nullable = true, length = 455)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "vatReg", nullable = true, length = 255)
    public String getVatReg() {
        return vatReg;
    }

    public void setVatReg(String vatReg) {
        this.vatReg = vatReg;
    }

    @Basic
    @Column(name = "logo", nullable = true)
    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    @Basic
    @Column(name = "billFormat", nullable = true)
    public Integer getBillFormat() {
        return billFormat;
    }

    public void setBillFormat(Integer billFormat) {
        this.billFormat = billFormat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (pkNo != company.pkNo) return false;
        if (companyName != null ? !companyName.equals(company.companyName) : company.companyName != null) return false;
        if (address != null ? !address.equals(company.address) : company.address != null) return false;
        if (telephone != null ? !telephone.equals(company.telephone) : company.telephone != null) return false;
        if (email != null ? !email.equals(company.email) : company.email != null) return false;
        if (vatReg != null ? !vatReg.equals(company.vatReg) : company.vatReg != null) return false;
        if (!Arrays.equals(logo, company.logo)) return false;
        if (billFormat != null ? !billFormat.equals(company.billFormat) : company.billFormat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkNo;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (vatReg != null ? vatReg.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(logo);
        result = 31 * result + (billFormat != null ? billFormat.hashCode() : 0);
        return result;
    }
}
