package com.ites.poswebservice.dao;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wannix on 1/18/17.
 */
public interface InventoryDao {
    BigDecimal getItemSubStorePrice(String iteNo, String rQty, String binIn);

    int getBinNo(String itemCode);

    String getRefCodePos();

    int addSubStorInventoryPos(int binNo, int subInNo, String grnDate, String refNo, double outQty, String itemCode, String startDate,
                               int user, String grnCode, int pos, String bilNo, int binInNo, int invDepartment, int subStore,
                               double unitPrice, String refCode);

    void updateSubStoreInventory(int binInNo, double balance);

    boolean checkInventory(String bil, int itemCode, int qty, String nightDate, int userId, int restaurantId);
}
