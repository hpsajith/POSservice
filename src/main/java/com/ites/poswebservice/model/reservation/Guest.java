/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.reservation;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "guest")
@NamedQueries({
    @NamedQuery(name = "Guest.findAll", query = "SELECT g FROM Guest g")})
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Guest_No")
    private Integer guestNo;
    @Size(max = 200)
    @Column(name = "Titel")
    private String titel;
    @Size(max = 100)
    @Column(name = "F_Name")
    private String fName;
    @Size(max = 100)
    @Column(name = "L_Name")
    private String lName;
    @Size(max = 500)
    @Column(name = "Address")
    private String address;
    @Size(max = 500)
    @Column(name = "Address2")
    private String address2;
    @Size(max = 100)
    @Column(name = "Country")
    private String country;
    @Size(max = 100)
    @Column(name = "City")
    private String city;
    @Size(max = 100)
    @Column(name = "State")
    private String state;
    @Size(max = 100)
    @Column(name = "Zip")
    private String zip;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "Email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "Fax")
    private String fax;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "phone")
    private String phone;
    @Size(max = 100)
    @Column(name = "company")
    private String company;
    @Size(max = 100)
    @Column(name = "Divition")
    private String divition;
    @Size(max = 100)
    @Column(name = "Initial")
    private String initial;
    @Size(max = 4)
    @Column(name = "vpi")
    private String vpi;
    @Size(max = 100)
    @Column(name = "Nationality")
    private String nationality;
    @Column(name = "Dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Size(max = 100)
    @Column(name = "PassportNo")
    private String passportNo;
    @Column(name = "PassportDate")
    @Temporal(TemporalType.DATE)
    private Date passportDate;
    @Size(max = 100)
    @Column(name = "passportIssuesby")
    private String passportIssuesby;
    @Size(max = 100)
    @Column(name = "EmailOptOut")
    private String emailOptOut;
    @Size(max = 100)
    @Column(name = "DL_Number")
    private String dLNumber;
    @Size(max = 100)
    @Column(name = "co")
    private String co;
    @Column(name = "guest_Level")
    private Integer guestLevel;
    @Column(name = "Corparate_id")
    private Integer corparateid;
    @Column(name = "guest_type")
    private Integer guestType;
    @Size(max = 50)
    @Column(name = "guest_gender")
    private String guestGender;
    @Size(max = 250)
    @Column(name = "Profession")
    private String profession;
    @Column(name = "Anniversary_Date")
    @Temporal(TemporalType.DATE)
    private Date anniversaryDate;
    @Column(name = "grc_no")
    private Integer grcNo;

    public Guest() {
    }

    public Guest(Integer guestNo) {
        this.guestNo = guestNo;
    }

    public Integer getGuestNo() {
        return guestNo;
    }

    public void setGuestNo(Integer guestNo) {
        this.guestNo = guestNo;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDivition() {
        return divition;
    }

    public void setDivition(String divition) {
        this.divition = divition;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getVpi() {
        return vpi;
    }

    public void setVpi(String vpi) {
        this.vpi = vpi;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public Date getPassportDate() {
        return passportDate;
    }

    public void setPassportDate(Date passportDate) {
        this.passportDate = passportDate;
    }

    public String getPassportIssuesby() {
        return passportIssuesby;
    }

    public void setPassportIssuesby(String passportIssuesby) {
        this.passportIssuesby = passportIssuesby;
    }

    public String getEmailOptOut() {
        return emailOptOut;
    }

    public void setEmailOptOut(String emailOptOut) {
        this.emailOptOut = emailOptOut;
    }

    public String getDLNumber() {
        return dLNumber;
    }

    public void setDLNumber(String dLNumber) {
        this.dLNumber = dLNumber;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public Integer getGuestLevel() {
        return guestLevel;
    }

    public void setGuestLevel(Integer guestLevel) {
        this.guestLevel = guestLevel;
    }

    public Integer getCorparateid() {
        return corparateid;
    }

    public void setCorparateid(Integer corparateid) {
        this.corparateid = corparateid;
    }

    public Integer getGuestType() {
        return guestType;
    }

    public void setGuestType(Integer guestType) {
        this.guestType = guestType;
    }

    public String getGuestGender() {
        return guestGender;
    }

    public void setGuestGender(String guestGender) {
        this.guestGender = guestGender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getAnniversaryDate() {
        return anniversaryDate;
    }

    public void setAnniversaryDate(Date anniversaryDate) {
        this.anniversaryDate = anniversaryDate;
    }

    public Integer getGrcNo() {
        return grcNo;
    }

    public void setGrcNo(Integer grcNo) {
        this.grcNo = grcNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guestNo != null ? guestNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Guest)) {
            return false;
        }
        Guest other = (Guest) object;
        if ((this.guestNo == null && other.guestNo != null) || (this.guestNo != null && !this.guestNo.equals(other.guestNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.reservation.Guest[ guestNo=" + guestNo + " ]";
    }
    
}
