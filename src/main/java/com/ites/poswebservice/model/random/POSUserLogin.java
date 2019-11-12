/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.random;

import java.util.List;

/**
 *
 * @author ITESS
 */
public class POSUserLogin {
    private Integer userID;
    private String userName;
    private String pwd;
    private Integer userType;
    private Integer active;
    private String pWCord;
    private Integer isCustom;
    private List<Object> posMachine;
    
    
    public POSUserLogin() {
    }//us.userID,us.userName,us.pwd,us.userType,us.active,us.pWCord,us.isCusto
public POSUserLogin(Integer userID,String userName,String pwd,Integer userType,Integer active,String pWCord,Integer isCustom) {
    this.userID=userID;
    this.userName=userName;
    this.pwd=pwd;
    this.userType=userType;
    this.active=active;
    this.pWCord=pWCord;
    this.isCustom=isCustom;
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

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getpWCord() {
        return pWCord;
    }

    public void setpWCord(String pWCord) {
        this.pWCord = pWCord;
    }

    public List<Object> getPosMachine() {
        return posMachine;
    }

    public void setPosMachine(List<Object> posMachine) {
        this.posMachine = posMachine;
    }


}
