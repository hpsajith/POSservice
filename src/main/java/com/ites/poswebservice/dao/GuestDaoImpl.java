/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ites.poswebservice.dao;

import com.ites.poswebservice.model.hotelpos.FrontBillSplit;
import com.ites.poswebservice.model.hotelpos.FrontKotBotMain;
import com.ites.poswebservice.model.hotelpos.FrontPosguest;
import com.ites.poswebservice.model.random.GuestProfile;
import com.ites.poswebservice.model.random.LoadRestItem;
import com.ites.poswebservice.services.ReservationService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ITESS
 */
@Repository
public class GuestDaoImpl implements GuestDao {

    @Autowired
    private SessionFactory sessionFactoryHotelPos;

    public Session getPOSSession() {
        return sessionFactoryHotelPos.openSession();
    }

    @Override
    public boolean setPosGuestDetails(GuestProfile guestProfile) {
        boolean status = false;
        Date date = new Date();//2016-12-07 16:09:43
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date systemDate = null;
        try {
            systemDate = df.parse(guestProfile.getSystemDate());
        } catch (ParseException ex) {
            Logger.getLogger(GuestDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FrontPosguest frontPosguest = new FrontPosguest();
            //states,SystemDate,startTyme,endTime,TransactionNo,isTax,RoomNo,
//ConfNo,mealCheck,mealNo,walkingGuest,miniBar,Guest_states,House_No,package
            frontPosguest.setTableNo(guestProfile.getTableNo());
            frontPosguest.setWaiterNo(guestProfile.getWaiterNo());
            frontPosguest.setFirstName(guestProfile.getFirstName());
            frontPosguest.setLastName(guestProfile.getLastName());
            frontPosguest.setAdult(guestProfile.getAdult());
            frontPosguest.setChildren(guestProfile.getChildren());
            frontPosguest.setTableDate(date);
            frontPosguest.setRemrk(guestProfile.getRemrk());
            frontPosguest.setStates(guestProfile.getStates());
            frontPosguest.setSystemDate(systemDate);
            frontPosguest.setStrartTime(date);
            frontPosguest.setEndTime(date);
//        frontPosguest.setTransactionNo("TRAN001");
            frontPosguest.setIsTax(1);
            frontPosguest.setRoomNo(guestProfile.getRoomNo());
            frontPosguest.setConfNo(guestProfile.getConfNo());
            frontPosguest.setMealCheck(guestProfile.getMealNo());
            if (guestProfile.getRoomNo().isEmpty()) {
                frontPosguest.setWalkingGuest(1);
            }
            frontPosguest.setMiniBar(0);
            frontPosguest.setGueststates(1);
            frontPosguest.setHouseNo(guestProfile.getHouseNo());
            frontPosguest.setPackage1(guestProfile.getPackage1());

            Session session = getPOSSession();
            session.save(frontPosguest);
            session.close();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean setFrontKotBotMain(GuestProfile guestProfile) {
        boolean status = false;
        try {//SELECT * FROM front_posguest ORDER BY posGuest_no  DESC LIMIT 1            
            Date date = new Date();
            Object obj = null;
            String qry = "select max(posGuestno) from FrontPosguest";
            obj = (Object) getPOSSession().createQuery(qry).uniqueResult();

            int guestNo = 0;
            if (obj != null) {
                guestNo = Integer.parseInt(obj.toString());
            }
            FrontKotBotMain frontKotBotMain = new FrontKotBotMain();

            frontKotBotMain.setPosGuestno(guestNo);
            frontKotBotMain.setResturentId(guestProfile.getRestId());
            frontKotBotMain.setTableNo(guestProfile.getTableNo());
            frontKotBotMain.setMealPeriod(guestProfile.getMealNo());
            frontKotBotMain.setCurrentDate(date);
            frontKotBotMain.setUserId(guestProfile.getWaiterNo());
            frontKotBotMain.setState(1);
            frontKotBotMain.setIsEnter(0);
            frontKotBotMain.setResRoom(guestProfile.getRestRoomNo());
            frontKotBotMain.setNightDate(guestProfile.getSystemDate().toString());
            frontKotBotMain.setRemark("");
            frontKotBotMain.setViewuser(0);
            frontKotBotMain.setLoguserID(0);
            frontKotBotMain.setBillNo("0");
            frontKotBotMain.setIntBillNo(0);
            frontKotBotMain.setPrintUser(0);
            frontKotBotMain.setHasSplit(false);
            frontKotBotMain.setHasMergeid(0);
            frontKotBotMain.setMergeBillNo("0");
            frontKotBotMain.setIntMergeBillNo(0);
            frontKotBotMain.setOpenInTable(1);

            Session session = getPOSSession();
            session.save(frontKotBotMain);
            session.close();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean setFrontBillSplit(GuestProfile guestProfile) {
        boolean status = false;

        Object obj = null;
        String qry = "select max(kotNo) from FrontKotBotMain";
        obj = (Object) getPOSSession().createQuery(qry).uniqueResult();
        int kotNo = 0;
        if (obj != null) {
            kotNo = Integer.parseInt(obj.toString());
        }
        try {
            FrontBillSplit frontBillSplit = new FrontBillSplit();
            frontBillSplit.setKotNo(kotNo);
            frontBillSplit.setBillNo("0");
            frontBillSplit.setIntBillNo(0);
            frontBillSplit.setIsPaid(false);
            frontBillSplit.setPaymentId(0);
            frontBillSplit.setRoomNo("0");

            Session session = getPOSSession();
            session.save(frontBillSplit);
            session.close();
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
 

    @Override
    public List<LoadRestItem> getRestaurantItem(int restId) {
        String s = "(SELECT rateValue FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 1) AS dUnitPrice,"
                + "(SELECT roundPrice FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 1) AS dTaxPrice,"
                + "(SELECT taxClass FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 1) AS dtaxClass,"
                + "(SELECT rateValue FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 4) AS mUnitPrice,"
                + "(SELECT roundPrice FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 4) AS mTaxPrice,"
                + "(SELECT taxClass FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 4) AS mTaxClass,"
                + "(SELECT currencyId FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 1) AS currencyId";

        List<LoadRestItem> loadRestItemList = null;
        String qry = "select new com.ites.poswebservice.model.random.LoadRestItem(MGF.fno,MGF.fname,MGM.masterno,MGM.mastername,MIT.itemCode,MIT.itemName,"
                + " (SELECT rateValue FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 1) AS dUnitPrice,"
                + "(SELECT roundPrice FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 1) AS dTaxPrice,"
                + "(SELECT taxClass FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 1) AS dtaxClass,"
                + "(SELECT rateValue FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 4) AS mUnitPrice,"
                + "(SELECT roundPrice FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 4) AS mTaxPrice,"
                + "(SELECT taxClass FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 4) AS mTaxClass,"
                + "(SELECT currencyId FROM MItemRate WHERE itemNo = MIT.itemCode AND rateNo = 1) AS currencyId,"
                + " MIT.subMenu) "
                + " from ConfigRestaurantItem as CRI,"
                + " MGroupFamily as MGF,"
                + " MGroupMaster as MGM,"
                + " MItem as MIT "
                + " where CRI.familyNo = MGF.fno"
                + " and MGF.fno = MIT.familyGno"
                + " and CRI.masterNo = MGM.masterno"
                + " and MIT.masterGno = MGM.masterno"
                + " and CRI.configRestaurantItemPK.resNo='" + restId + "'"
                + " group by MIT.itemCode order by MGF.fno,MGM.masterno ";
        loadRestItemList = (List<LoadRestItem>) getPOSSession().createQuery(qry).list();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadRestItemList;
    }

    @Override
    public int getKotNo() {
        Object obj = null;
        String qry = "select max(kotNo) from FrontKotBotMain";
        obj = (Object) getPOSSession().createQuery(qry).uniqueResult();
        int kotNo = 0;
        if (obj != null) {
            kotNo = Integer.parseInt(obj.toString());
        }
        return kotNo;
    }

    @Override
    public int getPosGuestNo(int kotNo) {
        Object obj = null;
        String qry = "select posGuestno from FrontKotBotMain where kotNo= '" + kotNo + "'";
        obj = (Object) getPOSSession().createQuery(qry).uniqueResult();
        int posGuestNo = 0;
        if (obj != null) {
            posGuestNo = Integer.parseInt(obj.toString());
        }
        return posGuestNo;
    }

    @Override
    public FrontPosguest getPosGuestDetail(int guestNo) {
        FrontPosguest obj = new FrontPosguest();
        String qry = "from FrontPosguest where posGuestno = '" + guestNo + "'";
        obj = (FrontPosguest) getPOSSession().createQuery(qry).uniqueResult();

        return obj;
    }

    @Override
    public boolean updatePosGuestDetails(FrontPosguest obj) {
        boolean status = false;
        FrontPosguest fpg = obj;

        Session session = getPOSSession();
        session.update(fpg);
        session.close();
        status = true;
        return status;
    }
}
