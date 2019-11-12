package com.ites.poswebservice.services;

/**
 * Created by wannix on 1/18/17.
 */
public interface InventoryService {
    boolean checkInventory(String bil, int itemCode, int qty, String nightDate, int userId, int restaurantId);
}
