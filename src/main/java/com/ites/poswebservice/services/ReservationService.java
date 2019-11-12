/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.services;

import com.ites.poswebservice.model.random.ReservationRoomLoad;
import com.ites.poswebservice.model.reservation.HouseAccount;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ITESS
 */
public interface ReservationService {

    List<ReservationRoomLoad> getReservationRooms();

    List<HouseAccount> getHouseAccList();
    
    String getNightAuditDate();
    
}
