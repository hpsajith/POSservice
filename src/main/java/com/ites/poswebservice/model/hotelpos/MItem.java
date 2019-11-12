package com.ites.poswebservice.model.hotelpos;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
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
@Table(name = "m_item", catalog = "")
@NamedQueries({
    @NamedQuery(name = "MItem.findAll", query = "SELECT m FROM MItem m")})
public class MItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "item_code")
    private int itemCode;
    @Basic(optional = false)
    @Column(name = "majer_gno")
    private int majerGno;
    @Basic(optional = false)
    @Column(name = "family_gno")
    private int familyGno;
    @Basic(optional = false)
    @Column(name = "master_gno")
    private int masterGno;
    @Column(name = "unit_no")
    private Integer unitNo;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "Default_Rate")
    private Integer defaultRate;
    @Column(name = "item_image")
    private String itemImage;
    @Basic(optional = false)
    @Column(name = "tax_calssId")
    private int taxcalssId;
    @Column(name = "is_setmenu")
    private Integer isSetmenu;
    @Column(name = "User_ID")
    private Integer userID;
    @Column(name = "Curr_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date currDate;
    @Column(name = "revenueType")
    private Integer revenueType;
    @Column(name = "printer")
    private Integer printer;
    @Column(name = "ItemOrderNo")
    private Integer itemOrderNo;
    @Column(name = "roundPrice")
    private Double roundPrice;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "txtWithTax")
    private Double txtWithTax;
    @Column(name = "invOutlet")
    private Integer invOutlet;
    @Column(name = "GroupNo")
    private Integer groupNo;
    @Basic(optional = false)
    @Column(name = "subMenu")
    private int subMenu;
    @Basic(optional = false)
    @Column(name = "isSubItem")
    private int isSubItem;
    @Basic(optional = false)
    @Column(name = "currencyId")
    private int currencyId;
    @Column(name = "isSpa")
    private Boolean isSpa;

    public MItem() {
    }


    public Integer getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getDefaultRate() {
        return defaultRate;
    }

    public void setDefaultRate(Integer defaultRate) {
        this.defaultRate = defaultRate;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public int getTaxcalssId() {
        return taxcalssId;
    }

    public void setTaxcalssId(int taxcalssId) {
        this.taxcalssId = taxcalssId;
    }

    public Integer getIsSetmenu() {
        return isSetmenu;
    }

    public void setIsSetmenu(Integer isSetmenu) {
        this.isSetmenu = isSetmenu;
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

    public Integer getRevenueType() {
        return revenueType;
    }

    public void setRevenueType(Integer revenueType) {
        this.revenueType = revenueType;
    }

    public Integer getPrinter() {
        return printer;
    }

    public void setPrinter(Integer printer) {
        this.printer = printer;
    }

    public Integer getItemOrderNo() {
        return itemOrderNo;
    }

    public void setItemOrderNo(Integer itemOrderNo) {
        this.itemOrderNo = itemOrderNo;
    }

    public Double getRoundPrice() {
        return roundPrice;
    }

    public void setRoundPrice(Double roundPrice) {
        this.roundPrice = roundPrice;
    }

    public Double getTxtWithTax() {
        return txtWithTax;
    }

    public void setTxtWithTax(Double txtWithTax) {
        this.txtWithTax = txtWithTax;
    }

    public Integer getInvOutlet() {
        return invOutlet;
    }

    public void setInvOutlet(Integer invOutlet) {
        this.invOutlet = invOutlet;
    }

    public Integer getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(Integer groupNo) {
        this.groupNo = groupNo;
    }

    public int getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(int subMenu) {
        this.subMenu = subMenu;
    }

    public int getIsSubItem() {
        return isSubItem;
    }

    public void setIsSubItem(int isSubItem) {
        this.isSubItem = isSubItem;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public Boolean getIsSpa() {
        return isSpa;
    }

    public void setIsSpa(Boolean isSpa) {
        this.isSpa = isSpa;
    }
    
    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public int getMajerGno() {
        return majerGno;
    }

    public void setMajerGno(int majerGno) {
        this.majerGno = majerGno;
    }

    public int getFamilyGno() {
        return familyGno;
    }

    public void setFamilyGno(int familyGno) {
        this.familyGno = familyGno;
    }

    public int getMasterGno() {
        return masterGno;
    }

    public void setMasterGno(int masterGno) {
        this.masterGno = masterGno;
    }




    
}
