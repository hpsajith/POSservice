/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ites.poswebservice.model.random;
import com.ites.poswebservice.model.hotelpos.FrontMealPeriod;
import com.ites.poswebservice.model.hotelpos.MRestaurant;
import com.ites.poswebservice.model.hotelpos.Userlogin;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class OrderedBillLs {

    /*
    data[x][0] = rs5.getString("ConfNo");
            data[x][1] = rs5.getString("kot_no");
            data[x][2] = rs5.getString("tableNo");
            data[x][3] = rs5.getInt("meal_period") == 1 ? "Breakfast" : (rs5.getInt("meal_period") == 2 ? "Lunch" : (rs5.getInt("meal_period") == 3 ? "Dinner" : ""));
            data[x][4] = rs5.getString("first_name");
            data[x][5] = rs5.getString("last_name");
            data[x][6] = rs5.getString("adult");
            data[x][7] = rs5.getString("children");
            data[x][8] = rs5.getString("RoomNo");
            data[x][9] = rs5.getString("username");
            data[x][10] = rs5.getString("SystemDate");
            data[x][11] = rs5.getString("states");
            data[x][12] = rs5.getString("resturent_id");
            //data[x][13] = rs5.getString("front_kot_bot_main.BillNo");
            //data[x][13] = rs5.getString("front_kot_bot_main.BillNo");//champika comment
            data[x][13] = rs5.getString("front_bill_split.bill_no");//add by champika
            data[x][14] = rs5.getString("front_kot_bot_main.viewuser");
            data[x][15] = rs5.getString("front_kot_bot_main.loguserID");
            data[x][16] = rs5.getString("fbs_id");
            data[x][17] = rs5.getString("isPaid");
            data[x][18] = rs5.getString("resRoom");
            data[x][19] = wc.getGuestStatus(rs5.getString("ConfNo"));
     */
    private List<MRestaurant> restuarantList;
    private List<FrontMealPeriod> mealPeriodList;
    private Integer confNo;
    private Integer kotNo;
    private String tableNo;
    private Integer mealPeriod;
    private String firstName;
    private String lastName;
    private Integer adult;
    private Integer child;
    private String roomNo;
    private String userName;
    private Date systemDate;
    private Integer status;
    private Integer restId;
    private String billNo;
    private Boolean isPaid;
    private Integer guestStatus;
    private List<Userlogin> userLogin;

    public OrderedBillLs(Integer confNo,Integer kotNo,String tableNo,Integer mealPeriod,String firstName,String lastName,Integer adult,Integer child,String roomNo,String userName,Date systemDate,Integer status,Integer restId,String billNo,Boolean isPaid,Integer guestStatus) {
        this.confNo = confNo;
        this.kotNo = kotNo;
        this.tableNo = tableNo;
        this.mealPeriod = mealPeriod;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adult = adult;
        this.child = child;
        this.roomNo = roomNo;
        this.userName = userName;
        this.systemDate = systemDate;
        this.status = status;
        this.restId = restId;
        this.billNo = billNo;
        this.isPaid = isPaid;
        this.guestStatus = guestStatus;
    }
    
    public List<MRestaurant> getRestuarantList() {
        return restuarantList;
    }

    public void setRestuarantList(List<MRestaurant> restuarantList) {
        this.restuarantList = restuarantList;
    }

    public List<FrontMealPeriod> getMealPeriodList() {
        return mealPeriodList;
    }

    public void setMealPeriodList(List<FrontMealPeriod> mealPeriodList) {
        this.mealPeriodList = mealPeriodList;
    }

    public Integer getConfNo() {
        return confNo;
    }

    public void setConfNo(Integer confNo) {
        this.confNo = confNo;
    }

    public Integer getKotNo() {
        return kotNo;
    }

    public void setKotNo(Integer kotNo) {
        this.kotNo = kotNo;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public Integer getMealPeriod() {
        return mealPeriod;
    }

    public void setMealPeriod(Integer mealPeriod) {
        this.mealPeriod = mealPeriod;
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

    public Integer getChild() {
        return child;
    }

    public void setChild(Integer child) {
        this.child = child;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getSystemDate() {
        return systemDate;
    }

    public void setSystemDate(Date systemDate) {
        this.systemDate = systemDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRestId() {
        return restId;
    }

    public void setRestId(Integer restId) {
        this.restId = restId;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Integer getGuestStatus() {
        return guestStatus;
    }

    public void setGuestStatus(Integer guestStatus) {
        this.guestStatus = guestStatus;
    }

    public List<Userlogin> getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(List<Userlogin> userLogin) {
        this.userLogin = userLogin;
    }

    
}
