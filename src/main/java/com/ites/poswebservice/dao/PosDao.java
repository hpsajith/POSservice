package com.ites.poswebservice.dao;

import com.ites.poswebservice.model.hotelpos.FrontKotBotItem;
import com.ites.poswebservice.model.hotelpos.FrontPosguest;
import com.ites.poswebservice.model.hotelpos.MVoidReason;
import com.ites.poswebservice.model.random.OpenedBillDetails;
import com.ites.poswebservice.model.random.SettlementDetails;
import java.io.InputStream;

import java.math.BigDecimal;
import java.util.List;
import org.json.JSONObject;

/**
 * Created by wannix on 1/18/17.
 */
public interface PosDao {

    List getTaxCalcResultSet(int taxId, boolean flag);

    boolean financePostingPos(String code, String chAccC, String chAccD, BigDecimal issPrice, BigDecimal cdAmt, String refNo, String itemNo, int subDepNo, Double amt, String date, int uId);

    double getRate(String itemCode, int rateType);

    double getRateTax(String itemCode, int rateType);

    String getUnit(String itemCode);

    String getChOfItemExp(int dep, int c, int cat2);

    boolean isFinance();

    InputStream getCompanyLogo();
    
    String getRestRoom(int kotNo);

    int isIteCon(int ite, int subDep);

    int getInvSubStore(int itemCode, String subItemCode, int restId);

    double getExchangeRate(int ItemCode);

    int updateStates(FrontPosguest frontPosguest);

    boolean isInventory();

    boolean insertKotBotMenu(int menuId, int kotId, int isSetMenu, int setMenuNo);

    int insertKotBotItemAb(int kotNo, int itemCode, int taxId, double unitPrice, int qty, double roundRate, int guestState,String itemComment);

    void insertKotBotTax(int itemNo, int taxId, double unitPrice, int qty);

    void insertKotBotTaxSC(int itemNo, int taxId, double unitPrice, int qty);

    boolean finishKotBotMenus(int kotId, int guestNo, int userId, int guestState, int restaurantNo);

    void updateStatusPos(int kotId);

    boolean insertKotBotItemTemp(int kotId, int itemCode, int qty, int type, int printer);

    List<Object[]> getSubItems(int itemCode);

    void tempItem(int kotId, int restId,String resourcePath,String subReportPath);

    public List<FrontKotBotItem> gerBeforeRawCount(int kotId);

    int getBillFormat();

    public void updateKotBotItem(int kotNo, int itemCode, int itemQty, int guestState);

    String getPosRestDescription(int kotNo);

    int getfbsId(int kotNo);

    String getbillNumber(String kotNo, String dis, int splitKotId, int userId);

    public void deletetempItem(int kotNo);

    public List<Object[]> getFrontKotBotItem(int kotNo, int printer);

    public void insertKotBotitemTemp(int kotNo, int itemCode, int qty, int typ, int printer);

    public void insertVoidItem(int kotNo, int itemCode, int voidQty, int voidRes,JSONObject orderDetails);

    public int itemPrinter(String itemCode);

    public List<MVoidReason> getVoidReason();

    public void deleteKotBotTax(int kotId, String ItemCode);

    public void deactiveKot(int kotId);

    public void deleteKotBotMenus(int kotId);

    public OpenedBillDetails getBillDetails(int kotNo);

    public SettlementDetails getSettlementDetails();

}
