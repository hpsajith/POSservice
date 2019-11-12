/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.random;

import com.ites.poswebservice.model.hotelpos.MVoidReason;
import com.ites.poswebservice.model.hotelpos.Subitems;
import java.util.List;


/**
 *
 * @author ITESS
 */
public class LoadRestItem {
    //F_no,F_name,m_group_master.Master_no,Master_name,item_code,item_name
    
    int kotNo;
    int posGuestNo;
    int familyNno;
    String familyName;
    int masterNo;
    String masterName;
    int itemCode;
    String itemName;
    double dUnitPrice;
    double dTaxPrice;
    int dtaxClass;
    double mUnitPrice;
    double mTaxPrice;
    int mTaxClass; 
    int currencyId;
    int subMenu;
    List<MVoidReason> voidReasons;
    /*(int fno,String fname,int masterno,String mastername,int itemCode,String itemName)*/
    public LoadRestItem(int fno,String fname,int masterno,String mastername,int itemCode,String itemName,double dUnitPrice,double dTaxPrice,
            int dtaxClass,double mUnitPrice,double mTaxPrice,int mTaxClass,int currencyId,int subMenu){
    this.familyNno = fno;
    this.familyName = fname;
    this.masterNo = masterno;
    this.masterName = mastername;
    this.itemCode = itemCode;
    this.itemName = itemName;
    this.dUnitPrice = dUnitPrice;
    this.dTaxPrice = dTaxPrice;
    this.dtaxClass = dtaxClass;
    this.mUnitPrice = mUnitPrice;
    this.mTaxPrice = mTaxPrice;
    this.mTaxClass = mTaxClass; 
    this.currencyId = currencyId;
    this.subMenu = subMenu;
    }

    public int getKotNo() {
        return kotNo;
    }

    public void setKotNo(int kotNo) {
        this.kotNo = kotNo;
    }

    public int getPosGuestNo() {
        return posGuestNo;
    }

    public void setPosGuestNo(int posGuestNo) {
        this.posGuestNo = posGuestNo;
    }

    
    
    public int getFamilyNno() {
        return familyNno;
    }

    public void setFamilyNno(int familyNno) {
        this.familyNno = familyNno;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getMasterNo() {
        return masterNo;
    }

    public void setMasterNo(int masterNo) {
        this.masterNo = masterNo;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getdUnitPrice() {
        return dUnitPrice;
    }

    public void setdUnitPrice(double dUnitPrice) {
        this.dUnitPrice = dUnitPrice;
    }

    public double getdTaxPrice() {
        return dTaxPrice;
    }

    public void setdTaxPrice(double dTaxPrice) {
        this.dTaxPrice = dTaxPrice;
    }

    public int getDtaxClass() {
        return dtaxClass;
    }

    public void setDtaxClass(int dtaxClass) {
        this.dtaxClass = dtaxClass;
    }

    public double getmUnitPrice() {
        return mUnitPrice;
    }

    public void setmUnitPrice(double mUnitPrice) {
        this.mUnitPrice = mUnitPrice;
    }

    public double getmTaxPrice() {
        return mTaxPrice;
    }

    public void setmTaxPrice(double mTaxPrice) {
        this.mTaxPrice = mTaxPrice;
    }

    public int getmTaxClass() {
        return mTaxClass;
    }

    public void setmTaxClass(int mTaxClass) {
        this.mTaxClass = mTaxClass;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public int getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(int subMenu) {
        this.subMenu = subMenu;
    }

    public List<MVoidReason> getVoidReasons() {
        return voidReasons;
    }

    public void setVoidReasons(List<MVoidReason> voidReasons) {
        this.voidReasons = voidReasons;
    }
            
    
}
