/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.random;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ITESS
 */
public class GuestProfile {
    //table_no,waiter_no,first_name,last_name,adult,children,tableDate,remrk,SystemDate,states,isTax,RoomNo,ConfNo,mealCheck,mealNo,walkingGuest,miniBar,Guest_states,House_No,package

    private Integer tableNo;
    private Integer waiterNo;
    private String firstName;
    private String lastName;
    private Integer adult;
    private Integer children;
    private Date tableDate;
    private String remrk;
    private Integer states;
    private Date strartTime;
    private Date endTime;
    private String roomNo;
    private Integer confNo;
    private Integer mealNo;
    private Integer houseNo;
    private String package1;
    private int restId;
    private int restRoomNo;
    private String systemDate;

    public Integer getTableNo() {
        return tableNo;
    }

    public void setTableNo(Integer tableNo) {
        this.tableNo = tableNo;
    }

    public Integer getWaiterNo() {
        return waiterNo;
    }

    public void setWaiterNo(Integer waiterNo) {
        this.waiterNo = waiterNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAdult() {
        return adult;
    }

    public void setAdult(Integer adult) {
        this.adult = adult;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Date getTableDate() {
        return tableDate;
    }

    public void setTableDate(Date tableDate) {
        this.tableDate = tableDate;
    }

    public String getRemrk() {
        return remrk;
    }

    public void setRemrk(String remrk) {
        this.remrk = remrk;
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    public Date getStrartTime() {
        return strartTime;
    }

    public void setStrartTime(Date strartTime) {
        this.strartTime = strartTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public String getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(String systemDate) {
        this.systemDate = systemDate;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public Integer getConfNo() {
        return confNo;
    }

    public void setConfNo(Integer confNo) {
        this.confNo = confNo;
    }

    public Integer getMealNo() {
        return mealNo;
    }

    public void setMealNo(Integer mealNo) {
        this.mealNo = mealNo;
    }

    public Integer getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(Integer houseNo) {
        this.houseNo = houseNo;
    }

    public String getPackage1() {
        return package1;
    }

    public void setPackage1(String package1) {
        this.package1 = package1;
    }

    public int getRestId() {
        return restId;
    }

    public void setRestId(int restId) {
        this.restId = restId;
    }

    public int getRestRoomNo() {
        return restRoomNo;
    }

    public void setRestRoomNo(int restRoomNo) {
        this.restRoomNo = restRoomNo;
    }
    
    
}
