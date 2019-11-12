/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ites.poswebservice.model.random;

import java.util.List;

/**
 *
 * @author admin
 */
public class OpenedBillDetails {

    List<OpenedBillItemList> openedBillItemList;
    double totalDiscount;
    double totalWithoutTax;
    double totalTax;
    double payment;
    double billAmount;

    public List<OpenedBillItemList> getOpenedBillItemList() {
        return openedBillItemList;
    }

    public void setOpenedBillItemList(List<OpenedBillItemList> openedBillItemList) {
        this.openedBillItemList = openedBillItemList;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTotalWithoutTax() {
        return totalWithoutTax;
    }

    public void setTotalWithoutTax(double totalWithoutTax) {
        this.totalWithoutTax = totalWithoutTax;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

}
