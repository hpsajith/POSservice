/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ites.poswebservice.services;

import com.ites.poswebservice.dao.OrderDao;
import com.ites.poswebservice.model.hotelpos.FrontKotBotItem;
import com.ites.poswebservice.model.hotelpos.FrontPosguest;
import com.ites.poswebservice.model.random.OrderedBillLs;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ITESS
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderDao orderDao;

    @Override
    public int updateStates(FrontPosguest frontPosguest) {
        return orderDao.updateStates(frontPosguest);
    }

//    @Override
//    public boolean addItems(JSONObject orderDetails, JSONArray itemsBucket) {
//
//        /**
//         * #attributes of orderDetails# int kotNo; int adultCount; int
//         * kidsCount; int roomNo; int guestNo; int guestType; int restId; int
//         * waiterId; String tableName; String waiterName; String guestFName;
//         * String guestLName; String remark; String date;
//         */
//        /**
//         * #attributes of an Item in itemsBucket# itemName; int qty; Double
//         * itemPrice; Double taxPrice; String comment; int itemCode; int
//         * taxClass; int currencyId;
//         */
//        boolean flag = false;
//        int kotId = orderDetails.getInt("kotNo");
//        int userId = orderDetails.getInt("waiterId");
//        int guestNo = orderDetails.getInt("guestNo");
//        int guestState = 1;
//        if (orderDetails.getInt("guestType") == 2) {
//            guestState = 4;
//        }
//        int restaurantNo = orderDetails.getInt("restId");
//
//        try {
//            //edit item
//            boolean isEdited = false;
//            List<FrontKotBotItem> beforRawItems = posService.gerBeforeRawCount(kotId);
//            if(beforRawItems.size()>0){
//            for (int j = 0; j < itemsBucket.length(); j++) {
//                JSONObject item = itemsBucket.getJSONObject(j);
//                isEdited = editItem(item, orderDetails, beforRawItems);
//                flag = true;
//            }
//            }
//
//            //add new item
//            if (!isEdited) {
//                for (int i = 0; i < itemsBucket.length(); i++) {
//                    JSONObject item = itemsBucket.getJSONObject(i);
//                    addItem(item, orderDetails);
//                }
//                finaliszeOrder(kotId, guestNo, userId, guestState, restaurantNo);
//                flag = true;
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return flag;
//    }
//    private void finaliszeOrder(int kotId, int guestNo, int userId, int guestState, int restaurantNo) {
//        posService.tempItem(kotId, restaurantNo);
//        posService.finishKotBotMenus(kotId, guestNo, userId, guestState, restaurantNo);
//        posService.updateStatusPos(kotId);
//    }
//    private void addItem(JSONObject item, JSONObject orderDetails) {
//        int itemCode = item.getInt("itemCode");
//        int itemQty = item.getInt("qty");
//        int guestState = 1;
//        if (orderDetails.getInt("guestType") == 2) {
//            guestState = 4;
//        }
//
//        double exchangeRate = posService.getExchangeRate(itemCode);
//
//        if (posService.isInventory()) {
//            String date = reservationService.getNightAuditDate();
//            if (!inventoryService.checkInventory(orderDetails.getInt("kotNo") + "", itemCode, itemQty, date, orderDetails.getInt("waiterId"), orderDetails.getInt("restId"))) {
////               "Can't Add Item" indicate this to the client
//                return;
//            }
//        }
//
//        double rate = posService.getRate(itemCode + "", guestState) * exchangeRate;
//        double rateRound = posService.getRateTax(itemCode + "", guestState) * exchangeRate;
//
//        posService.insertKotBotItem(orderDetails.getInt("kotNo"), guestState, itemCode, item.getInt("taxClass"), rate, itemQty, rateRound);
//
//    }
//
//    private boolean editItem(JSONObject item, JSONObject orderDetails, List<FrontKotBotItem> beforRawItems) {
//         int kotNo = orderDetails.getInt("kotNo");
//        int guestState = 1;
//        if (orderDetails.getInt("guestType") == 2) {
//            guestState = 4;
//        }
//        int itemCode = item.getInt("itemCode");
//        int itemQty = item.getInt("qty");
//        
//        boolean isEdited = true;
//        boolean isUpdated = false;
//        for (int i = 0; i < beforRawItems.size(); i++) {
//            if (beforRawItems.get(i).getItemCode().equals(itemCode)) {
//                posService.updateKotBotItem(kotNo, itemCode, itemQty, guestState);
//                isUpdated = true;
//            }
//        }
//        if(!isUpdated){
//        double exchangeRate = posService.getExchangeRate(itemCode);
//        double rate = posService.getRate(itemCode + "", guestState) * exchangeRate;
//        double rateRound = posService.getRateTax(itemCode + "", guestState) * exchangeRate;
//
//        posService.insertKotBotItem(orderDetails.getInt("kotNo"), guestState, itemCode, item.getInt("taxClass"), rate, itemQty, rateRound);
//        }
//
//        return isEdited;
//    }
    @Override
    public List<OrderedBillLs> getOrderedBillList(Date date) {
        List<OrderedBillLs> orderedBillList = orderDao.getOrderedBillList(date);
        return orderedBillList;
    }
}
