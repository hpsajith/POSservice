/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.model.random;

/**
 *
 * @author ITESS
 */
public class ReservationRoomLoad {
    /* F_Name,
  L_Name,
  guest.Guest_No,
  Conf_No,
  GuestStatus,
  RoomNo,
  No_of_adults,
  isTax,
  Package,
  resevation_No,
  No_of_children,
  ExtraBed_Adults,
  Market_Category*/
    
    String fName;
    String lName;
    int guestNo;
    int confNo;
    int guestStatus;
    String roomId;
    String roomNo;
    int noOfAdults;
    int noChild;
    String pakage;
    int reservationNo;
    String marketCategary;
    
    public ReservationRoomLoad(){
    }

    public ReservationRoomLoad(String fName,String lName,int guestNo,int confNo,int guestStatus,String roomId,int noOfAdults,int noChild,String pakage,int reservationNo,String marketCategary,String roomNo){
      this.fName=fName;
    this.lName=lName;
    this.guestNo=guestNo;
    this.confNo=confNo;
    this.guestStatus=guestStatus;
    this.roomId=roomId;
    this.noOfAdults=noOfAdults;
    this.noChild=noChild;
    this.pakage=pakage;
    this.reservationNo=reservationNo;
    this.marketCategary=marketCategary;
    this.roomNo=roomNo;
    }
    
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getGuestNo() {
        return guestNo;
    }

    public void setGuestNo(int guestNo) {
        this.guestNo = guestNo;
    }

    public int getConfNo() {
        return confNo;
    }

    public void setConfNo(int confNo) {
        this.confNo = confNo;
    }

    public int getGuestStatus() {
        return guestStatus;
    }

    public void setGuestStatus(int guestStatus) {
        this.guestStatus = guestStatus;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    
    

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(int noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public int getNoChild() {
        return noChild;
    }

    public void setNoChild(int noChild) {
        this.noChild = noChild;
    }

    public String getPakage() {
        return pakage;
    }

    public void setPakage(String pakage) {
        this.pakage = pakage;
    }

    public int getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(int reservationNo) {
        this.reservationNo = reservationNo;
    }

    public String getMarketCategary() {
        return marketCategary;
    }

    public void setMarketCategary(String marketCategary) {
        this.marketCategary = marketCategary;
    }
    
    
    
}
