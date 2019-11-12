package com.ites.poswebservice.services;

import com.ites.poswebservice.dao.PosDao;
import com.ites.poswebservice.model.hotelpos.FrontKotBotItem;
import com.ites.poswebservice.model.hotelpos.FrontPosguest;
import com.ites.poswebservice.model.hotelpos.MVoidReason;
import com.ites.poswebservice.model.random.OpenedBillDetails;
import com.ites.poswebservice.model.random.SettlementDetails;
import java.util.List;
import org.hibernate.Query;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wannix on 1/18/17.
 */
public class PosServiceImpl implements PosService {

    @Autowired
    private PosDao posDao;

//    @Autowired
//    private GetGuestBill getGuestBill;
    @Override
    public double getExchangeRate(int ItemCode) {
        return posDao.getExchangeRate(ItemCode);
    }

    @Override
    public boolean isInventory() {
        return posDao.isInventory();
    }

    @Override
    public double getRate(String itemCode, int rateType) {
        return posDao.getRate(itemCode, rateType);
    }

    @Override
    public double getRateTax(String itemCode, int rateType) {
        return posDao.getRateTax(itemCode, rateType);
    }

    @Override
    public String getUnit(String itemCode) {
        return posDao.getUnit(itemCode);
    }

    @Override
    public int insertKotBotItem(int kotNo, int guestState, int itemNo, int taxId, double unitPrice, int qty, double roundRate, String itemComment) {
        return posDao.insertKotBotItemAb(kotNo, itemNo, taxId, unitPrice, qty, roundRate, guestState, itemComment);
    }

    @Override
    public boolean finishKotBotMenus(int kotId, int guestNo, int userId, int guestState, int restaurantNo) {
        return posDao.finishKotBotMenus(kotId, guestNo, userId, guestState, restaurantNo);
    }

    @Override
    public void updateStatusPos(int kotId) {
        posDao.updateStatusPos(kotId);
    }

    @Override
    public void tempItem(int kotId, int restId, String resourcePath, String subReportPath) {
        posDao.tempItem(kotId, restId, resourcePath, subReportPath);
    }

    @Override
    public List<FrontKotBotItem> gerBeforeRawCount(int kotId) {
        return posDao.gerBeforeRawCount(kotId);
    }

    @Override
    public void updateKotBotItem(int kotNo, int itemCode, int itemQty, int guestState) {
        posDao.updateKotBotItem(kotNo, itemCode, itemQty, guestState);
    }

    @Override
    public String printGuestBill(int kotNo, int userId, int restId, int posNo, String userName) {
        String restRoom = posDao.getPosRestDescription(kotNo);
        int psplit_kot_id = posDao.getfbsId(kotNo);
        String guestBillNumber = posDao.getbillNumber(kotNo + "", restRoom, psplit_kot_id, userId);
//        getGuestBill.getReport(kotNo, guestBillNumber, restId, posNo, userName); // generate guest bill
        return guestBillNumber;
    }

    @Override
    public void deletetempItem(int kotNo) {
        posDao.deletetempItem(kotNo);
    }

    @Override
    public List<Object[]> getFrontKotBotItem(int kotNo, int printer) {
        List<Object[]> rs = posDao.getFrontKotBotItem(kotNo, printer);
        return rs;
    }

    @Override
    public void insertKotBotitemTemp(int kotNo, int itemCode, int qty, int typ, int printer) {
        posDao.insertKotBotitemTemp(kotNo, itemCode, qty, typ, printer);
    }

    @Override
    public void insertVoidItem(int kotNo, int itemCode, int voidQty, int voidRes, JSONObject orderDetails) {
        posDao.insertVoidItem(kotNo, itemCode, voidQty, voidRes, orderDetails);
    }

    @Override
    public int itemPrinter(String itemCode) {
        return posDao.itemPrinter(itemCode);
    }

    @Override
    public List<MVoidReason> getVoidReason() {
        return posDao.getVoidReason();
    }

    @Override
    public void deleteKotBotTax(int kotId, String ItemCode) {
        posDao.deleteKotBotTax(kotId, ItemCode);
    }

    @Override
    public void deactiveKot(int kotId) {
        posDao.deactiveKot(kotId);
    }

    @Override
    public void deleteKotBotMenus(int kotId) {
        posDao.deleteKotBotMenus(kotId);
    }

    @Override
    public OpenedBillDetails getBillDetails(int kotNo) {
        return posDao.getBillDetails(kotNo);
    }

    @Override
    public SettlementDetails getSettlementDetails() {
        return posDao.getSettlementDetails();
    }

    
}
