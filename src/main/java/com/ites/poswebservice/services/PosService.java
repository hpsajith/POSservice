package com.ites.poswebservice.services;

import com.ites.poswebservice.model.hotelpos.FrontKotBotItem;
import com.ites.poswebservice.model.hotelpos.FrontPosguest;
import com.ites.poswebservice.model.hotelpos.MVoidReason;
import com.ites.poswebservice.model.random.OpenedBillDetails;
import com.ites.poswebservice.model.random.SettlementDetails;
import java.util.List;
import org.json.JSONObject;

/**
 * Created by wannix on 1/18/17.
 */
public interface PosService {

    double getExchangeRate(int ItemCode);

    boolean isInventory();

    double getRate(String itemCode, int rateType);

    double getRateTax(String itemCode, int rateType);

    String getUnit(String itemCode);

    int insertKotBotItem(int kotNo, int guestState, int itemNo, int taxId, double unitPrice, int qty, double roundRate,String itemComment);

    boolean finishKotBotMenus(int kotId, int guestNo, int userId, int guestState, int restaurantNo);

    void updateStatusPos(int kotId);

    void tempItem(int kotId, int restId,String resourcePath,String subReportPath);

    public List<FrontKotBotItem> gerBeforeRawCount(int kotId);

    public void updateKotBotItem(int kotNo, int itemCode, int itemQty, int guestState);

    public String printGuestBill(int kotNo, int userId, int restId, int posNo, String userName);

    public void deletetempItem(int kotNo);

    public List<Object[]> getFrontKotBotItem(int kotNo, int printer);

    public void insertKotBotitemTemp(int kotNo, int itemCode, int qty, int typ, int printer);

    public void insertVoidItem(int kotNo, int parseInt, int voidQty, int voidRes,JSONObject orderDetails);

    public int itemPrinter(String itemCode);

    public List<MVoidReason> getVoidReason();

    public void deleteKotBotTax(int kotId, String ItemCode);

    public void deactiveKot(int kotId);

    public void deleteKotBotMenus(int kotId);

    public OpenedBillDetails getBillDetails(int kotNo);

    public SettlementDetails getSettlementDetails();

}
