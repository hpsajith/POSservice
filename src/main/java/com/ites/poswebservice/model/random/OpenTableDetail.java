/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.random;

import java.util.Date;

/**
 *
 * @author ITESS
 */
public class OpenTableDetail {

    String itemName;
    Date systemDate;
    int kotNo;
    int tableNo;
    int posGuestno;
    String roomNo;
    int itemCode;
    int itemNo;
    Double qty;
    Double itemPrices;
    Double unitPrice;
    String unitName;
    String userName;
    int taxClass;
    double unitPrices;
    String itemcomment;
    int currencyId;
    
/*mit.itemName,fpg.systemDate,fkbm.kotNo,fkbm.tableNo,fpg.posGuestno,"
+ " fpg.roomNo,fkbi.itemCode,fkbi.itemNo,fkbi.qty,fkbi.unitPrices,"
+ " miu.uName,ulg.userName*/
    //int taxClass,double unitPrices,String itemcomment,int currencyId
    public OpenTableDetail(String itemName,Date systemDate,int kotNo,int tableNo,int posGuestno,String roomNo,int itemCode,int itemNo,Double qty,Double unitPrice,String unitName,String userName,int taxClass,double unitPrices,String itemcomment,int currencyId){
     this.itemName=itemName;
    this.systemDate=systemDate;
    this.kotNo=kotNo;
    this.tableNo=tableNo;
    this.posGuestno=posGuestno;
    this.roomNo=roomNo;
    this.itemCode=itemCode;
    this.itemNo=itemNo;
    this.qty=qty;
    this.unitPrice=unitPrice;
    this.unitName=unitName;
    this.userName=userName;
    this.taxClass = taxClass;
    this.unitPrices=unitPrices;
    this.itemcomment=itemcomment;
    this.currencyId=currencyId;
    }
    public OpenTableDetail(String itemName,Date systemDate,int kotNo,int tableNo,int posGuestno,String roomNo,int itemCode,int itemNo,Double qty,Double unitPrice,String unitName,String userName,Double itemPrices){
     this.itemName=itemName;
    this.systemDate=systemDate;
    this.kotNo=kotNo;
    this.tableNo=tableNo;
    this.posGuestno=posGuestno;
    this.roomNo=roomNo;
    this.itemCode=itemCode;
    this.itemNo=itemNo;
    this.qty=qty;
    this.unitPrice=unitPrice;
    this.unitName=unitName;
    this.userName=userName;
    this.itemPrices=itemPrices;
    }

    public int getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(int taxClass) {
        this.taxClass = taxClass;
    }

    public double getUnitPrices() {
        return unitPrices;
    }

    public void setUnitPrices(double unitPrices) {
        this.unitPrices = unitPrices;
    }

    public String getItemcomment() {
        return itemcomment;
    }

    public void setItemcomment(String itemcomment) {
        this.itemcomment = itemcomment;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }
    
    
    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
    }

    public int getKotNo() {
        return kotNo;
    }

    public void setKotNo(int kotNo) {
        this.kotNo = kotNo;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public int getPosGuestno() {
        return posGuestno;
    }

    public void setPosGuestno(int posGuestno) {
        this.posGuestno = posGuestno;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public Double getItemPrices() {
        return itemPrices;
    }

    public void setItemPrices(Double itemPrices) {
        this.itemPrices = itemPrices;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    
    
}
