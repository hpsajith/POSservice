/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.services;

import com.ites.poswebservice.model.hotelpos.FrontPosguest;
import com.ites.poswebservice.model.random.OrderedBillLs;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ITESS
 */
public interface OrderService {
    int updateStates(FrontPosguest frontPosguest);
//    boolean addItems(JSONObject orderDetails, JSONArray itemsBucket);

    public List<OrderedBillLs> getOrderedBillList(Date date);
}
