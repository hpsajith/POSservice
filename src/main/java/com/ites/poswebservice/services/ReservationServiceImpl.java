/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.services;

import com.ites.poswebservice.dao.ReservationDao;
import com.ites.poswebservice.model.random.ReservationRoomLoad;
import com.ites.poswebservice.model.reservation.HouseAccount;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ITESS
 */
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService{
    
    @Autowired
    private ReservationDao reservationDao;
    
    @Override
    public List<ReservationRoomLoad> getReservationRooms(){        
        List<ReservationRoomLoad> reservationRoomLoad = reservationDao.getReservationRooms();        
        return reservationRoomLoad;
    }
    
    @Override
    public List<HouseAccount> getHouseAccList(){
     List<HouseAccount> houseAccList = reservationDao.getHouseAccList();        
        return houseAccList;
    }
    
    @Override
    public String getNightAuditDate(){
    String date = reservationDao.getNightAuditDate();
    return date;
    }
}
