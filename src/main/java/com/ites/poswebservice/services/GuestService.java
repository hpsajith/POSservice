/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ites.poswebservice.services;

import com.ites.poswebservice.model.hotelpos.FrontPosguest;
import com.ites.poswebservice.model.random.GuestProfile;
import com.ites.poswebservice.model.random.LoadRestItem;
import java.util.List;

/**
 *
 * @author ITESS
 */
public interface GuestService {

    public boolean setPosGuestDetails(GuestProfile guestProfile);
    
    public boolean setFrontKotBotMain(GuestProfile obj);
    
    public boolean setFrontBillSplit(GuestProfile obj);

    public List<LoadRestItem> getRestaurantItem(int restId);

    public int getKotNo();

    public int getPosGuestNo(int kotNo);

    public FrontPosguest getPosGuestDetail(int guestNo);

    public String printGuestBill(int kotNo, int userId, int restId, int posNo, String userName);

    public boolean updatePosGuestDetails(FrontPosguest obj);
}
