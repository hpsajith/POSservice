/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ites.poswebservice.dao;

import com.ites.poswebservice.model.random.ReservationRoomLoad;
import com.ites.poswebservice.model.reservation.HouseAccount;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITESS
 */
@Repository
public class ReservationDaoImpl implements ReservationDao {

    @Autowired
    private SessionFactory sessionFactoryReservation;

    public Session getResSession() {
        return sessionFactoryReservation.openSession();
    }

    @Override
    public List<ReservationRoomLoad> getReservationRooms() {
        List<ReservationRoomLoad> reservationRoomLoadList = null;
        String qry = "select new com.ites.poswebservice.model.random.ReservationRoomLoad(gt.fName,gt.lName,gt.guestNo,rc.confNo,rc.guestStatus,"
                + " rt.roomNo,rt.noofadults,rt.noofchildren,rt.package1,rt.reservationNo,rt.marketCategory,(select rName from Room where roomNo = rt.roomNo)) "
                + " from ReservationConf as rc,ReservationTemp as rt,Guest as gt where rc.resevationNo=rt.reservationNo and  rc.guestNo = gt.guestNo"
                + " and rc.guestStatus=1 and rt.roomNo like'%'";
        reservationRoomLoadList = (List<ReservationRoomLoad>) getResSession().createQuery(qry).list();

        return reservationRoomLoadList;
    }
    
    @Override
    public List<HouseAccount> getHouseAccList(){
     List<HouseAccount> houseAccList =null;        
      String qry = "from HouseAccount where acitve=1";
        houseAccList = (List<HouseAccount>) getResSession().createQuery(qry).list();
        return houseAccList;
    }

    @Override
    public double getSellingPrice(int curencyId){
        double rate;
        Query hql2 = getResSession().createQuery("select c.sellingPrice from CurrencyExchange c " +
                "where c.currencyId=:currencyId order by c.exchangeDate desc").setParameter("currencyId", curencyId);
        rate = (double) hql2.list().get(0);

        return rate;
    }

    @Override
    public String getNightAuditDate() {
        Query hql = getResSession().createQuery("select MAX(nADDate) as nDate from NightAuditDate");

        return hql.list().get(0).toString();
    }
}
