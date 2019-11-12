package com.ites.poswebservice.services;

import com.ites.poswebservice.dao.InventoryDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wannix on 1/18/17.
 */
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryDao inventoryDao;

    @Override
    public boolean checkInventory(String bil, int itemCode, int qty, String nightDate, int userId, int restaurantId) {
        return inventoryDao.checkInventory(bil, itemCode, qty, nightDate, userId,restaurantId);
    }
}
