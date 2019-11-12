/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ites.poswebservice.dao;

import com.ites.poswebservice.model.hotelpos.FrontPosguest;
import com.ites.poswebservice.model.random.OrderedBillLs;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ITESS
 */
public interface OrderDao {
    int updateStates(FrontPosguest frontPosguest);

    public List<OrderedBillLs> getOrderedBillList(Date date);
}