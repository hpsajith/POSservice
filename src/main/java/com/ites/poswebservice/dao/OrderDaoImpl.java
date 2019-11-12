package com.ites.poswebservice.dao;

import com.ites.poswebservice.model.hotelpos.FrontPosguest;
import com.ites.poswebservice.model.random.OrderedBillLs;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author ITESS
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactoryHotelPos;

    public Session getPosSession() {
        return sessionFactoryHotelPos.openSession();
    }

    @Override
    public int updateStates(FrontPosguest frontPosguest) {
        return 0;
    }

    @Override
    public List<OrderedBillLs> getOrderedBillList(Date date) {

        
//OrderedBillLs(Integer confNo,Integer kotNo,String tableNo,Integer mealPeriod,String firstName,String lastName,Integer adult,Integer child,String roomNo,String userName,Date systemDate,Integer status,Integer restId,String billNo,Boolean isPaid,Integer guestStatus)
//                       1     2              3             4               5                   6          7        8           9               10              11              12      13              14          15          16
        String qry = "select new com.ites.poswebservice.model.random.OrderedBillLs(fpg.confNo,fkm.kotNo,mrs.tableName,fkm.mealPeriod,fpg.firstName,fpg.lastName,fpg.adult,fpg.children,fpg.roomNo,usr.userName,fpg.systemDate,fpg.states,fkm.resturentId,fkm.billNo,fbs.isPaid,fpg.gueststates) "
                + " from "
                + " MRestaurantTable as mrs,"
                + " FrontPosguest as fpg,"
                + " FrontKotBotMain as fkm,"
                + " FrontBillSplit as fbs,"
                + " Userlogin as usr "
                + " where "
                + " usr.userID = fkm.userId" 
                + " and fkm.kotNo =  fbs.kotNo "
                + " and fkm.tableNo = mrs.tableId "
                + " and fkm.posGuestno = fpg.posGuestno"
                + " and fkm.state = '1'"
                + " and fkm.openInTable = '0' ";
//                + " and fkm.currentDate like '2017-01-06%'  ";
//                + " and fkm.currentDate = '" + date + "'";//2018-10-08 15:52:59  ,fkm.kotNo,fkm.mealPeriod,fkm.resturentId,fkm.billNo
         
        try {
            Session session = getPosSession();
            List<OrderedBillLs> orderedBills = (List<OrderedBillLs>) session.createQuery(qry).list();
            return orderedBills;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
