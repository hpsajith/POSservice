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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
    , @NamedQuery(name = "Room.findByRNo", query = "SELECT r FROM Room r WHERE r.rNo = :rNo")
    , @NamedQuery(name = "Room.findByRoomNo", query = "SELECT r FROM Room r WHERE r.roomNo = :roomNo")
    , @NamedQuery(name = "Room.findByRType", query = "SELECT r FROM Room r WHERE r.rType = :rType")
    , @NamedQuery(name = "Room.findByFloorNo", query = "SELECT r FROM Room r WHERE r.floorNo = :floorNo")
    , @NamedQuery(name = "Room.findByHSKPZone", query = "SELECT r FROM Room r WHERE r.hSKPZone = :hSKPZone")
    , @NamedQuery(name = "Room.findByRStatus", query = "SELECT r FROM Room r WHERE r.rStatus = :rStatus")
    , @NamedQuery(name = "Room.findByRcleanStatus", query = "SELECT r FROM Room r WHERE r.rcleanStatus = :rcleanStatus")
    , @NamedQuery(name = "Room.findByRcredit", query = "SELECT r FROM Room r WHERE r.rcredit = :rcredit")
    , @NamedQuery(name = "Room.findByRName", query = "SELECT r FROM Room r WHERE r.rName = :rName")
    , @NamedQuery(name = "Room.findByRDescription", query = "SELECT r FROM Room r WHERE r.rDescription = :rDescription")
    , @NamedQuery(name = "Room.findByRMaxGuest", query = "SELECT r FROM Room r WHERE r.rMaxGuest = :rMaxGuest")
    , @NamedQuery(name = "Room.findByConnectRoom", query = "SELECT r FROM Room r WHERE r.connectRoom = :connectRoom")
    , @NamedQuery(name = "Room.findBySmokeStatus", query = "SELECT r FROM Room r WHERE r.smokeStatus = :smokeStatus")
    , @NamedQuery(name = "Room.findByAutoTurndownRoom", query = "SELECT r FROM Room r WHERE r.autoTurndownRoom = :autoTurndownRoom")
    , @NamedQuery(name = "Room.findByOutOfoOrder", query = "SELECT r FROM Room r WHERE r.outOfoOrder = :outOfoOrder")
    , @NamedQuery(name = "Room.findByConRoom1", query = "SELECT r FROM Room r WHERE r.conRoom1 = :conRoom1")
    , @NamedQuery(name = "Room.findByConRoom2", query = "SELECT r FROM Room r WHERE r.conRoom2 = :conRoom2")
    , @NamedQuery(name = "Room.findByConection", query = "SELECT r FROM Room r WHERE r.conection = :conection")
    , @NamedQuery(name = "Room.findByDummyuser", query = "SELECT r FROM Room r WHERE r.dummyuser = :dummyuser")
    , @NamedQuery(name = "Room.findByIsDummy", query = "SELECT r FROM Room r WHERE r.isDummy = :isDummy")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "R_No")
    private Integer rNo;
    @Size(max = 50)
    @Column(name = "Room_No")
    private String roomNo;
    @Column(name = "R_Type")
    private Integer rType;
    @Column(name = "Floor_No")
    private Integer floorNo;
    @Size(max = 100)
    @Column(name = "HSKP_Zone")
    private String hSKPZone;
    @Column(name = "R_Status")
    private Integer rStatus;
    @Column(name = "R_clean_Status")
    private Integer rcleanStatus;
    @Column(name = "R_credit")
    private Integer rcredit;
    @Size(max = 100)
    @Column(name = "R_Name")
    private String rName;
    @Size(max = 100)
    @Column(name = "R_Description")
    private String rDescription;
    @Column(name = "R_Max_Guest")
    private Integer rMaxGuest;
    @Size(max = 100)
    @Column(name = "Connect_Room")
    private String connectRoom;
    @Column(name = "Smoke_Status")
    private Integer smokeStatus;
    @Size(max = 100)
    @Column(name = "Auto_Turndown_Room")
    private String autoTurndownRoom;
    @Column(name = "outOfoOrder")
    private Integer outOfoOrder;
    @Size(max = 100)
    @Column(name = "ConRoom1")
    private String conRoom1;
    @Size(max = 100)
    @Column(name = "ConRoom2")
    private String conRoom2;
    @Column(name = "Conection")
    private Integer conection;
    @Column(name = "Dummy_user")
    private Integer dummyuser;
    @Column(name = "is_Dummy")
    private Integer isDummy;

    public Room() {
    }

    public Room(Integer rNo) {
        this.rNo = rNo;
    }

    public Integer getRNo() {
        return rNo;
    }

    public void setRNo(Integer rNo) {
        this.rNo = rNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getRType() {
        return rType;
    }

    public void setRType(Integer rType) {
        this.rType = rType;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }

    public String getHSKPZone() {
        return hSKPZone;
    }

    public void setHSKPZone(String hSKPZone) {
        this.hSKPZone = hSKPZone;
    }

    public Integer getRStatus() {
        return rStatus;
    }

    public void setRStatus(Integer rStatus) {
        this.rStatus = rStatus;
    }

    public Integer getRcleanStatus() {
        return rcleanStatus;
    }

    public void setRcleanStatus(Integer rcleanStatus) {
        this.rcleanStatus = rcleanStatus;
    }

    public Integer getRcredit() {
        return rcredit;
    }

    public void setRcredit(Integer rcredit) {
        this.rcredit = rcredit;
    }

    public String getRName() {
        return rName;
    }

    public void setRName(String rName) {
        this.rName = rName;
    }

    public String getRDescription() {
        return rDescription;
    }

    public void setRDescription(String rDescription) {
        this.rDescription = rDescription;
    }

    public Integer getRMaxGuest() {
        return rMaxGuest;
    }

    public void setRMaxGuest(Integer rMaxGuest) {
        this.rMaxGuest = rMaxGuest;
    }

    public String getConnectRoom() {
        return connectRoom;
    }

    public void setConnectRoom(String connectRoom) {
        this.connectRoom = connectRoom;
    }

    public Integer getSmokeStatus() {
        return smokeStatus;
    }

    public void setSmokeStatus(Integer smokeStatus) {
        this.smokeStatus = smokeStatus;
    }

    public String getAutoTurndownRoom() {
        return autoTurndownRoom;
    }

    public void setAutoTurndownRoom(String autoTurndownRoom) {
        this.autoTurndownRoom = autoTurndownRoom;
    }

    public Integer getOutOfoOrder() {
        return outOfoOrder;
    }

    public void setOutOfoOrder(Integer outOfoOrder) {
        this.outOfoOrder = outOfoOrder;
    }

    public String getConRoom1() {
        return conRoom1;
    }

    public void setConRoom1(String conRoom1) {
        this.conRoom1 = conRoom1;
    }

    public String getConRoom2() {
        return conRoom2;
    }

    public void setConRoom2(String conRoom2) {
        this.conRoom2 = conRoom2;
    }

    public Integer getConection() {
        return conection;
    }

    public void setConection(Integer conection) {
        this.conection = conection;
    }

    public Integer getDummyuser() {
        return dummyuser;
    }

    public void setDummyuser(Integer dummyuser) {
        this.dummyuser = dummyuser;
    }

    public Integer getIsDummy() {
        return isDummy;
    }

    public void setIsDummy(Integer isDummy) {
        this.isDummy = isDummy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rNo != null ? rNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.rNo == null && other.rNo != null) || (this.rNo != null && !this.rNo.equals(other.rNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ites.poswebservice.model.reservation.Room[ rNo=" + rNo + " ]";
    }
    
}
