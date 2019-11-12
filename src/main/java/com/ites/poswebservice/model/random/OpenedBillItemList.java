/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ites.poswebservice.model.random;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author admin
 */
public class OpenedBillItemList {

    String itemName;
    int itemCode;
    double quantity;
    double unitPrice;
    double itemPrice;

    public OpenedBillItemList(String itemName, int itemCode, double quantity, double unitPrice, double itemPrice) {
        this.itemName = itemName;
        this.itemCode = itemCode;
        this.quantity = quantity;
        BigDecimal bd = new BigDecimal(unitPrice);
        bd = bd.setScale(2, RoundingMode.HALF_EVEN);
        this.unitPrice = bd.doubleValue();
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

}
