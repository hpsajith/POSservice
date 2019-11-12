/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ites.poswebservice.services;

/**
 *
 * @author ITESS
 */
import com.ites.poswebservice.dao.GuestDao;
import com.ites.poswebservice.model.hotelpos.FrontPosguest;
import com.ites.poswebservice.model.random.GuestProfile;
import com.ites.poswebservice.model.random.LoadRestItem;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestDao guestDao;
    
    @Autowired
    private PosService posService;

//    @Override
//    public boolean setPosGuestDetails(GuestProfile guestProfile) {
//        boolean status = guestDao.setPosGuestDetails(guestProfile);
//        boolean status2 = guestDao.setFrontKotBotMain(guestProfile);
//        boolean status3 = guestDao.setFrontBillSplit(guestProfile);
//        return status && status2 && status3;
//    }
    
    @Override
    public boolean setPosGuestDetails(GuestProfile obj){
    return guestDao.setPosGuestDetails(obj);
    }
    
    @Override
    public boolean setFrontKotBotMain(GuestProfile obj){
    return guestDao.setFrontKotBotMain(obj);
    }
    
    @Override
    public boolean setFrontBillSplit(GuestProfile obj){
    return guestDao.setFrontBillSplit(obj);
    }

    @Override
    public List<LoadRestItem> getRestaurantItem(int restId) {
        List<LoadRestItem> loadRestItem = guestDao.getRestaurantItem(restId);
        return loadRestItem;
    }

    @Override
    public int getKotNo() {
        int kotNo = guestDao.getKotNo();
        return kotNo;
    }

    @Override
    public int getPosGuestNo(int kotNo) {
        int posGuestNo = guestDao.getPosGuestNo(kotNo);
        return posGuestNo;
    }

    @Override
    public FrontPosguest getPosGuestDetail(int guestNo) {
        FrontPosguest posGuest = guestDao.getPosGuestDetail(guestNo);
        return posGuest;
    }

    @Override
    public String printGuestBill(int kotNo, int userId, int restId, int posNo, String userName) {
        String billno = posService.printGuestBill(kotNo, userId, restId, posNo, userName);
        return billno;
    }
    
    @Override
    public boolean updatePosGuestDetails(FrontPosguest obj){
    return guestDao.updatePosGuestDetails(obj);
    }
}
