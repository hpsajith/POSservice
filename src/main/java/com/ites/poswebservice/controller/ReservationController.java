/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ites.poswebservice.controller;

import com.ites.poswebservice.model.random.GuestProfile;
import com.ites.poswebservice.model.random.ReservationRoomLoad;
import com.ites.poswebservice.model.reservation.HouseAccount;
import com.ites.poswebservice.services.ReservationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ITESS
 */
@Controller
@RequestMapping(value = {"/ReservationController"})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @RequestMapping(value = {"getReservationRooms"}, method = RequestMethod.GET)
    public @ResponseBody
        List<ReservationRoomLoad> getReservationRooms() {
        List<ReservationRoomLoad> reservationRoomList = reservationService.getReservationRooms();
        return reservationRoomList;
    }
    
   @RequestMapping(value = {"getHouseAccList"}, method = RequestMethod.GET)
   public @ResponseBody
   List<HouseAccount> getHouseAccList() {
        List<HouseAccount> houseAccList = reservationService.getHouseAccList();
        return houseAccList;
    }
        
}