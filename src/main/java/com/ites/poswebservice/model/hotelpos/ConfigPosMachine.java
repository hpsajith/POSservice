/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.hotelpos;

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
import javax.validation.constraints.Size;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "config_pos_machine")
@NamedQueries({
    @NamedQuery(name = "ConfigPosMachine.findAll", query = "SELECT c FROM ConfigPosMachine c")})
public class ConfigPosMachine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pos_machine_id")
    private Integer posMachineId;
    @Column(name = "restraunt_id")
    private Integer restrauntId;
    @Column(name = "pos_no")
    private Integer posNo;
    @Size(max = 50)
    @Column(name = "pos_ip")
    private String posIp;
    @Column(name = "User_ID")
    private Integer userID;
    @Column(name = "Curr_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currDate;
    @Column(name = "inv_dep")
    private Integer invDep;
    @Column(name = "isSpa")
    private Boolean isSpa;

    public ConfigPosMachine() {
    }

    public ConfigPosMachine(Integer posMachineId) {
        this.posMachineId = posMachineId;
    }

    public Integer getPosMachineId() {
        return posMachineId;
    }

    public void setPosMachineId(Integer posMachineId) {
        this.posMachineId = posMachineId;
    }

    public Integer getRestrauntId() {
        return restrauntId;
    }

    public void setRestrauntId(Integer restrauntId) {
        this.restrauntId = restrauntId;
    }

    public Integer getPosNo() {
        return posNo;
    }

    public void setPosNo(Integer posNo) {
        this.posNo = posNo;
    }

    public String getPosIp() {
        return posIp;
    }

    public void setPosIp(String posIp) {
        this.posIp = posIp;
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

    public Integer getInvDep() {
        return invDep;
    }

    public void setInvDep(Integer invDep) {
        this.invDep = invDep;
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
        hash += (posMachineId != null ? posMachineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConfigPosMachine)) {
            return false;
        }
        ConfigPosMachine other = (ConfigPosMachine) object;
        if ((this.posMachineId == null && other.posMachineId != null) || (this.posMachineId != null && !this.posMachineId.equals(other.posMachineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.hotelpos.ConfigPosMachine[ posMachineId=" + posMachineId + " ]";
    }
    
}
