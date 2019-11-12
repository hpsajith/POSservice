package com.ites.poswebservice.model.hotelpos;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ITESS
 */
@Entity
@Table(name = "userlogin")
public class Userlogin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id //userID,userName,pwd,userType,active,pWCord,isCustom
    @Column(name = "User_Id")
    private Integer userID;
    @Column(name = "User_Name")
    private String userName;
    @Column(name = "Pwd")
    private String pwd;
    @Column(name = "User_Type")
    private Integer userType;
    @Column(name = "active")
    private Integer active;
    @Column(name = "PW_Cord")
    private String pWCord;
    @Column(name = "isCustom")
    private Integer isCustom;
    @Column(name = "isShow")
    private Integer isShow;
    
    public Userlogin() {
    }

    public Integer getUserId() {
        return userID;
    }

    public void setUserId(Integer userId) {
        this.userID = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getPWCord() {
        return pWCord;
    }

    public void setPWCord(String pWCord) {
        this.pWCord = pWCord;
    }

    public Integer getIsCustom() {
        return isCustom;
    }

    public void setIsCustom(Integer isCustom) {
        this.isCustom = isCustom;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    
}
