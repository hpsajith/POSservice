package com.ites.poswebservice.model.hotelpos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "m_restaurant_room")
@NamedQueries({
    @NamedQuery(name = "MRestaurantRoom.findAll", query = "SELECT m FROM MRestaurantRoom m")})
public class MRestaurantRoom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "R_no")
    private Integer rno;
    @Basic(optional = false)
    @Column(name = "Res_no")
    private int resno;
    @Column(name = "R_name")
    private String rname;
    @Column(name = "No_of_tables")
    private Integer nooftables;
    @Column(name = "User_ID")
    private Integer userID;
    @Column(name = "Curr_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currDate;
    @Column(name = "description")
    private String description;

    public MRestaurantRoom() {
    }

    public MRestaurantRoom(Integer rno) {
        this.rno = rno;
    }

    public MRestaurantRoom(Integer rno, int resno) {
        this.rno = rno;
        this.resno = resno;
    }

    public Integer getRno() {
        return rno;
    }

    public void setRno(Integer rno) {
        this.rno = rno;
    }

    public int getResno() {
        return resno;
    }

    public void setResno(int resno) {
        this.resno = resno;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public Integer getNooftables() {
        return nooftables;
    }

    public void setNooftables(Integer nooftables) {
        this.nooftables = nooftables;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Date getCurrDate() {
        return currDate;
    }

    public void setCurrDate(Date currDate) {
        this.currDate = currDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rno != null ? rno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MRestaurantRoom)) {
            return false;
        }
        MRestaurantRoom other = (MRestaurantRoom) object;
        if ((this.rno == null && other.rno != null) || (this.rno != null && !this.rno.equals(other.rno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MRestaurantRoom[ rno=" + rno + " ]";
    }
    
}
