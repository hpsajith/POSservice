/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.dao;

import com.ites.poswebservice.model.hotelpos.FrontPosguest;
import com.ites.poswebservice.model.random.GuestProfile;
import com.ites.poswebservice.model.random.LoadRestItem;
import java.util.List;

/**
 *
 * @author ITESS
 */
public interface GuestDao {

    public boolean setPosGuestDetails(GuestProfile guestProfile);
    
    public boolean setFrontKotBotMain(GuestProfile guestProfile);

    public boolean setFrontBillSplit(GuestProfile guestProfile);

    public List<LoadRestItem> getRestaurantItem(int restId);

    public int getKotNo();

    public int getPosGuestNo(int kotNo);

    public FrontPosguest getPosGuestDetail(int guestNo);

    public boolean updatePosGuestDetails(FrontPosguest obj);
}
