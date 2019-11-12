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
@Table(name = "front_meal_period")
@NamedQueries({
    @NamedQuery(name = "FrontMealPeriod.findAll", query = "SELECT f FROM FrontMealPeriod f")})
public class FrontMealPeriod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "meal_period_id")
    private Integer mealPeriodId;
    @Column(name = "meal_periad_name")
    private String mealPeriadName;
    @Column(name = "From_time")
    @Temporal(TemporalType.TIME)
    private Date fromtime;
    @Column(name = "To_time")
    @Temporal(TemporalType.TIME)
    private Date totime;
    @Column(name = "isSpa")
    private Boolean isSpa;

    public FrontMealPeriod() {
    }

    public FrontMealPeriod(Integer mealPeriodId) {
        this.mealPeriodId = mealPeriodId;
    }

    public Integer getMealPeriodId() {
        return mealPeriodId;
    }

    public void setMealPeriodId(Integer mealPeriodId) {
        this.mealPeriodId = mealPeriodId;
    }

    public String getMealPeriadName() {
        return mealPeriadName;
    }

    public void setMealPeriadName(String mealPeriadName) {
        this.mealPeriadName = mealPeriadName;
    }

    public Date getFromtime() {
        return fromtime;
    }

    public void setFromtime(Date fromtime) {
        this.fromtime = fromtime;
    }

    public Date getTotime() {
        return totime;
    }

    public void setTotime(Date totime) {
        this.totime = totime;
    }

    public Boolean getIsSpa() {
        return isSpa;
    }

    public void setIsSpa(Boolean isSpa) {
        this.isSpa = isSpa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mealPeriodId != null ? mealPeriodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FrontMealPeriod)) {
            return false;
        }
        FrontMealPeriod other = (FrontMealPeriod) object;
        if ((this.mealPeriodId == null && other.mealPeriodId != null) || (this.mealPeriodId != null && !this.mealPeriodId.equals(other.mealPeriodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FrontMealPeriod[ mealPeriodId=" + mealPeriodId + " ]";
    }
    
}
