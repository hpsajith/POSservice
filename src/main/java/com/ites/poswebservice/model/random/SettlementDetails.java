/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ites.poswebservice.model.random;

import com.ites.poswebservice.model.hotelpos.MAcCreditcard;
import com.ites.poswebservice.model.hotelpos.PaymentType;
import com.ites.poswebservice.model.reservation.HouseAccount;
import java.util.List;

/**
 *
 * @author admin
 */
public class SettlementDetails {
    List<PaymentType> paymentTypeList;
    List<HouseAccount> houseAccountList;
    List<ReservationRoomLoad> reservedRoomList;
    List<MAcCreditcard> mAcCreditcard;

    public List<PaymentType> getPaymentTypeList() {
        return paymentTypeList;
    }

    public void setPaymentTypeList(List<PaymentType> paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }

    public List<HouseAccount> getHouseAccountList() {
        return houseAccountList;
    }

    public void setHouseAccountList(List<HouseAccount> houseAccountList) {
        this.houseAccountList = houseAccountList;
    }

    public List<ReservationRoomLoad> getReservedRoomList() {
        return reservedRoomList;
    }

    public void setReservedRoomList(List<ReservationRoomLoad> reservedRoomList) {
        this.reservedRoomList = reservedRoomList;
    }

    public List<MAcCreditcard> getmAcCreditcard() {
        return mAcCreditcard;
    }

    public void setmAcCreditcard(List<MAcCreditcard> mAcCreditcard) {
        this.mAcCreditcard = mAcCreditcard;
    }
    
    
}
