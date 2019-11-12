/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ites.poswebservice.controller;

import com.ites.poswebservice.model.hotelpos.FrontKotBotItem;
import com.ites.poswebservice.model.random.MsgContainer;
import com.ites.poswebservice.model.random.OpenedBillDetails;
import com.ites.poswebservice.model.random.SettlementDetails;
import com.ites.poswebservice.report.GetReport;
import com.ites.poswebservice.services.InventoryService;
import com.ites.poswebservice.services.OrderService;
import com.ites.poswebservice.services.PosService;
import com.ites.poswebservice.services.ReservationService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ITESS
 */
@Controller
@RequestMapping(value = {"/OrderController"})
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    private PosService posService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = {"setNewOrderedItemList"}, method = RequestMethod.POST)
    public @ResponseBody
    MsgContainer setOrderedItemLIst(HttpServletRequest request, HttpServletResponse response) {
//        response.setContentType("text/html;charset=UTF-8");

        MsgContainer msg = new MsgContainer();

        JSONArray itemList = new JSONArray(request.getParameter("itemBucket"));
        JSONArray voidItemList = new JSONArray(request.getParameter("voidItemBucket"));
        JSONObject orderDetails = new JSONObject(request.getParameter("orderDetails"));

//        if(orderService.addItems(orderDetails, itemList)){
        if (addItems(orderDetails, itemList, voidItemList)) {
            msg.setMsg("done");
        } else {
            msg.setMsg("undone");
        }

        return msg;
    }

    @RequestMapping(value = {"setExitItemList"}, method = RequestMethod.POST)
    public @ResponseBody
    MsgContainer setExitItemList(HttpServletRequest request, HttpServletResponse response) {
//        response.setContentType("text/html;charset=UTF-8");

        MsgContainer msg = new MsgContainer();

        JSONArray itemsBucket = new JSONArray(request.getParameter("itemBucket"));
        JSONArray voidItemsBucket = new JSONArray(request.getParameter("voidItemBucket"));
        JSONObject orderDetails = new JSONObject(request.getParameter("orderDetails"));

        int kotId = orderDetails.getInt("kotNo");

        HashMap<String, Integer> itemBuct = new HashMap<String, Integer>();
        for (int j = 0; j < itemsBucket.length(); j++) {
            JSONObject item = itemsBucket.getJSONObject(j);
            String itemCode = item.getInt("itemCode") + "";
            int itemQty = item.getInt("qty");
            itemBuct.put(itemCode, itemQty);
        }
        HashMap<String, Integer> voidItemsBckt = new HashMap<String, Integer>();
        for (int k = 0; k < voidItemsBucket.length(); k++) {
            JSONObject voiditem = voidItemsBucket.getJSONObject(k);
            String itemCd = voiditem.getInt("itemCode") + "";
            int itmQty = voiditem.getInt("qty");
            voidItemsBckt.put(itemCd, itmQty);
        }
        List<FrontKotBotItem> beforRawItems = posService.gerBeforeRawCount(kotId);
        HashMap<String, Integer> beforeItemsBckt = new HashMap<String, Integer>();
        for (int m = 0; m < beforRawItems.size(); m++) {
            int bfitemCd = beforRawItems.get(m).getItemCode();

            Double bfitmQty = beforRawItems.get(m).getQty();
            int qnt = bfitmQty.intValue();
            beforeItemsBckt.put(bfitemCd + "", qnt);
        }
        posService.deactiveKot(kotId);
        exitvoidtempItem(kotId, voidItemsBucket, orderDetails);
        updatetempItem(kotId, beforeItemsBckt, voidItemsBckt, orderDetails);
        return msg;
    }

//    @Override
    public boolean addItems(JSONObject orderDetails, JSONArray itemsBucket, JSONArray voidItemsBucket) {

        /**
         * #attributes of orderDetails# int kotNo; int adultCount; int
         * kidsCount; int roomNo; int guestNo; int guestType; int restId; int
         * waiterId; String tableName; String waiterName; String guestFName;
         * String guestLName; String remark; String date;
         */
        /**
         * #attributes of an Item in itemsBucket# itemName; int qty; Double
         * itemPrice; Double taxPrice; String comment; int itemCode; int
         * taxClass; int currencyId;
         */
        boolean flag = false;
        int kotId = orderDetails.getInt("kotNo");
        int userId = orderDetails.getInt("waiterId");
        int restaurantNo = orderDetails.getInt("restId");
        int guestNo = orderDetails.getInt("guestNo");
        int guestState = 1;
        if (orderDetails.getInt("guestType") == 2) {
            guestState = 4;
        }

        try {
            //edit item
            boolean isEdited = false;
            List<FrontKotBotItem> beforRawItems = posService.gerBeforeRawCount(kotId);
            if (beforRawItems.size() > 0) {
                HashMap<String, Integer> itemBuct = new HashMap<String, Integer>();
                for (int j = 0; j < itemsBucket.length(); j++) {
                    JSONObject item = itemsBucket.getJSONObject(j);
                    isEdited = editItem(item, orderDetails, beforRawItems);
                    String itemCode = item.getInt("itemCode") + "";
                    int itemQty = item.getInt("qty");
                    itemBuct.put(itemCode, itemQty);
                    flag = true;
                }
                HashMap<String, Integer> voidItemsBckt = new HashMap<String, Integer>();
                for (int k = 0; k < voidItemsBucket.length(); k++) {
                    JSONObject voiditem = voidItemsBucket.getJSONObject(k);
                    String itemCd = voiditem.getInt("itemCode") + "";
                    int itmQty = voiditem.getInt("qty");
                    voidItemsBckt.put(itemCd, itmQty);
                }

                HashMap<String, Integer> beforeItemsBckt = new HashMap<String, Integer>();
                for (int m = 0; m < beforRawItems.size(); m++) {
                    int bfitemCd = beforRawItems.get(m).getItemCode();

                    Double bfitmQty = beforRawItems.get(m).getQty();
                    int qnt = bfitmQty.intValue();
                    beforeItemsBckt.put(bfitemCd + "", qnt);
                }

                voidtempItem(kotId, beforRawItems, voidItemsBucket);
//                updatetempItem(kotId, itemBuct, voidItemsBckt, orderDetails);
                updatetempItem(kotId, beforeItemsBckt, voidItemsBckt, orderDetails);
            }

            //add new item
            if (!isEdited) {
                for (int i = 0; i < itemsBucket.length(); i++) {
                    JSONObject item = itemsBucket.getJSONObject(i);
                    addItem(item, orderDetails);
                }
                finaliszeOrder(kotId, guestNo, userId, guestState, restaurantNo);
                flag = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return flag;
    }

    private void addItem(JSONObject item, JSONObject orderDetails) {
        int itemCode = item.getInt("itemCode");
        int itemQty = item.getInt("qty");
        String itemComment = item.getString("itemComment");
        int guestState = 1;
        if (orderDetails.getInt("guestType") == 2) {
            guestState = 4;
        }

        double exchangeRate = posService.getExchangeRate(itemCode);

        if (posService.isInventory()) {
            String date = reservationService.getNightAuditDate();
            if (!inventoryService.checkInventory(orderDetails.getInt("kotNo") + "", itemCode, itemQty, date, orderDetails.getInt("waiterId"), orderDetails.getInt("restId"))) {
//               "Can't Add Item" indicate this to the client
                return;
            }
        }

        double rate = posService.getRate(itemCode + "", guestState) * exchangeRate;
        double rateRound = posService.getRateTax(itemCode + "", guestState) * exchangeRate;

        posService.insertKotBotItem(orderDetails.getInt("kotNo"), guestState, itemCode, item.getInt("taxClass"), rate, itemQty, rateRound, itemComment);

    }

    private boolean editItem(JSONObject item, JSONObject orderDetails, List<FrontKotBotItem> beforRawItems) {
        int kotNo = orderDetails.getInt("kotNo");
        int guestState = 1;
        if (orderDetails.getInt("guestType") == 2) {
            guestState = 4;
        }
        int itemCode = item.getInt("itemCode");
        int itemQty = item.getInt("qty");
        String itemComment = item.getString("itemComment");

        boolean isEdited = true;
        boolean isUpdated = false;
        for (int i = 0; i < beforRawItems.size(); i++) {
            if (beforRawItems.get(i).getItemCode().equals(itemCode) && beforRawItems.get(i).getQty() < itemQty) {
                if (!beforRawItems.get(i).getQty().equals(itemQty)) {
                    posService.updateKotBotItem(kotNo, itemCode, itemQty, guestState);
                    isUpdated = true;
                }
            } else if (beforRawItems.get(i).getItemCode().equals(itemCode) && beforRawItems.get(i).getQty() == itemQty) {
                isUpdated = true;
            }
        }
        if (!isUpdated) {
            double exchangeRate = posService.getExchangeRate(itemCode);
            double rate = posService.getRate(itemCode + "", guestState) * exchangeRate;
            double rateRound = posService.getRateTax(itemCode + "", guestState) * exchangeRate;

            posService.insertKotBotItem(orderDetails.getInt("kotNo"), guestState, itemCode, item.getInt("taxClass"), rate, itemQty, rateRound, itemComment);
        }

        return isEdited;
    }

    private void finaliszeOrder(int kotId, int guestNo, int userId, int guestState, int restaurantNo) {
        String reportSource = servletContext.getRealPath("/WEB-INF/Report/KotItem/kotItem.jrxml");
        String subreportSource = servletContext.getRealPath("/WEB-INF/Report/KotItem/");
        posService.tempItem(kotId, restaurantNo, reportSource, subreportSource);
        posService.finishKotBotMenus(kotId, guestNo, userId, guestState, restaurantNo);
        posService.updateStatusPos(kotId);
    }

    private void updatetempItem(int kotNo, HashMap<String, Integer> beformap, HashMap<String, Integer> voidmap, JSONObject orderDetails) {
        int restId = orderDetails.getInt("restId");

        boolean add = false, delete = false, adding = false, voiding = false;
        deletetempItem(kotNo);
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        int printer = 1;
        List<Object[]> rs = posService.getFrontKotBotItem(kotNo, printer);
        String itemCode;
        Double dqnt;
        int qnt;
        for (int i = 0; i < rs.size(); i++) {
            itemCode = rs.get(i)[0].toString();
            dqnt = (Double) rs.get(i)[1];
            qnt = dqnt.intValue();
            map1.put(itemCode, qnt);
            if (beformap.containsKey(itemCode)) {
                if (beformap.get(itemCode) < qnt) {
                    insertKotBotitemTemp(kotNo, itemCode, qnt - beformap.get(itemCode), 2, printer);
                    adding = true;
                } else if (beformap.get(itemCode) > qnt) {
                    insertKotBotitemTemp(kotNo, itemCode, beformap.get(itemCode) - qnt, 3, printer);
                    insertVoidItem(kotNo, itemCode, beformap.get(itemCode) - qnt, voidmap.get(itemCode), orderDetails);
                    voiding = true;
                }
            } else {
                insertKotBotitemTemp(kotNo, itemCode, qnt, 1, 1);
                add = true;
            }
        }

        boolean add1 = false, delete1 = false, adding1 = false, voiding1 = false;
        printer = 2;
        rs = posService.getFrontKotBotItem(kotNo, printer);
        for (int i = 0; i < rs.size(); i++) {
            itemCode = rs.get(i)[0].toString();
            dqnt = (Double) rs.get(i)[1];
            qnt = dqnt.intValue();
            map1.put(itemCode, qnt);
            if (beformap.containsKey(itemCode)) {
                if (beformap.get(itemCode) < qnt) {
                    insertKotBotitemTemp(kotNo, itemCode, qnt - beformap.get(itemCode), 2, printer);
                    adding1 = true;
                } else if (beformap.get(itemCode) > qnt) {
                    insertKotBotitemTemp(kotNo, itemCode, beformap.get(itemCode) - qnt, 3, printer);
                    insertVoidItem(kotNo, itemCode, beformap.get(itemCode) - qnt, voidmap.get(itemCode), orderDetails);
                    voiding1 = true;
                }
            } else {
                insertKotBotitemTemp(kotNo, itemCode, qnt, 1, printer);
                add1 = true;
            }
        }

        boolean add2 = false, delete2 = false, adding2 = false, voiding2 = false;
        printer = 3;
        rs = posService.getFrontKotBotItem(kotNo, printer);
        for (int i = 0; i < rs.size(); i++) {
            itemCode = rs.get(i)[0].toString();
            dqnt = (Double) rs.get(i)[1];
            qnt = dqnt.intValue();
            map1.put(itemCode, qnt);
            if (beformap.containsKey(itemCode)) {
                if (beformap.get(itemCode) < qnt) {
                    insertKotBotitemTemp(kotNo, itemCode, qnt - beformap.get(itemCode), 2, printer);
                    adding2 = true;
                } else if (beformap.get(itemCode) > qnt) {
                    insertKotBotitemTemp(kotNo, itemCode, beformap.get(itemCode) - qnt, 3, printer);
                    insertVoidItem(kotNo, itemCode, beformap.get(itemCode) - qnt, voidmap.get(itemCode), orderDetails);
                    voiding2 = true;
                }
            } else {
                insertKotBotitemTemp(kotNo, itemCode, qnt, 1, printer);
                add2 = true;
            }
        }

        boolean add3 = false, delete3 = false, adding3 = false, voiding3 = false;
        printer = 4;
        rs = posService.getFrontKotBotItem(kotNo, printer);
        for (int i = 0; i < rs.size(); i++) {
            itemCode = rs.get(i)[0].toString();
            dqnt = (Double) rs.get(i)[1];
            qnt = dqnt.intValue();
            map1.put(itemCode, qnt);
            if (beformap.containsKey(itemCode)) {
                if (beformap.get(itemCode) < qnt) {
                    insertKotBotitemTemp(kotNo, itemCode, qnt - beformap.get(itemCode), 2, printer);
                    adding3 = true;
                } else if (beformap.get(itemCode) > qnt) {
                    insertKotBotitemTemp(kotNo, itemCode, beformap.get(itemCode) - qnt, 3, printer);
                    insertVoidItem(kotNo, itemCode, beformap.get(itemCode) - qnt, voidmap.get(itemCode), orderDetails);
                    voiding3 = true;
                }
            } else {
                insertKotBotitemTemp(kotNo, itemCode, qnt, 1, printer);
                add3 = true;
            }
        }

        Set<String> keys4 = beformap.keySet();
        TreeSet<String> keys5 = new TreeSet<String>(keys4);
        Iterator<String> it3 = keys5.iterator();
        while (it3.hasNext()) {
            String key = it3.next();
            if (!map1.containsKey(key)) {
                if (posService.itemPrinter(key) == 1) {
                    delete = true;
                    insertKotBotitemTemp(kotNo, key, beformap.get(key), 4, 1);
                } else if (posService.itemPrinter(key) == 2) {
                    delete1 = true;
                    insertKotBotitemTemp(kotNo, key, beformap.get(key), 4, 2);
                } else if (posService.itemPrinter(key) == 3) {
                    delete2 = true;
                    insertKotBotitemTemp(kotNo, key, beformap.get(key), 4, 3);
                } else if (posService.itemPrinter(key) == 4) {
                    delete3 = true;
                    insertKotBotitemTemp(kotNo, key, beformap.get(key), 4, 4);
                }
                insertVoidItem(kotNo, key, beformap.get(key), voidmap.get(key), orderDetails);
            }
            key = null;
        }

        String reportSource = servletContext.getRealPath("/WEB-INF/Report/KotItem/kotItem.jrxml");
        String subreportSource = servletContext.getRealPath("/WEB-INF/Report/KotItem/");

        if (add3 && adding3 && voiding3) {
            GetReport t = new GetReport(restId, kotNo, "1", "2", "3", "4", "Item", "Item", "Void Item", "Void Item", 4, reportSource, subreportSource);
            t.generateReport();
        } else if (add3 && adding3) {
            GetReport t = new GetReport(restId, kotNo, "1", "2", "4", "3", "Item", "Item", "Void Item", "Void Item", 4, reportSource, subreportSource);
            t.generateReport();
        } else if (add3 && voiding3) {
            GetReport t = new GetReport(restId, kotNo, "1", "2", "4", "3", "Item", "Item", "Void Item", "Void Item", 4, reportSource, subreportSource);
            t.generateReport();
        } else if (add3) {
            GetReport t = new GetReport(restId, kotNo, "1", "4", "2", "3", "Item", "Void Item", "Item", "Void Item", 4, reportSource, subreportSource);
            t.generateReport();
        } else if (adding3 && voiding3) {
            GetReport t = new GetReport(restId, kotNo, "2", "3", "4", "1", "Item", "Void Item", "Void Item", "Item", 4, reportSource, subreportSource);
            t.generateReport();
        } else if (adding3) {
            GetReport t = new GetReport(restId, kotNo, "2", "4", "3", "1", "Item", "Void Item", "Void Item", "Item", 4, reportSource, subreportSource);
            t.generateReport();
        } else if (voiding3) {
            GetReport t = new GetReport(restId, kotNo, "3", "4", "1", "2", "Void Item", "Void Item", "Item", "Item", 4, reportSource, subreportSource);
            t.generateReport();
        } else if (delete3) {
            GetReport t = new GetReport(restId, kotNo, "4", "1", "2", "3", "Void Item", "Item", "Item", "Void Item", 4, reportSource, subreportSource);
            t.generateReport();
        }

        if (add2 && adding2 && voiding2) {
            GetReport t = new GetReport(restId, kotNo, "1", "2", "3", "4", "Item", "Item", "Void Item", "Void Item", 3, reportSource, subreportSource);
            t.generateReport();
        } else if (add2 && adding2) {
            GetReport t = new GetReport(restId, kotNo, "1", "2", "4", "3", "Item", "Item", "Void Item", "Void Item", 3, reportSource, subreportSource);
            t.generateReport();
        } else if (add2 && voiding2) {
            GetReport t = new GetReport(restId, kotNo, "1", "3", "4", "2", "Item", "Void Item", "Void Item", "Item", 3, reportSource, subreportSource);
            t.generateReport();
        } else if (add2) {
            GetReport t = new GetReport(restId, kotNo, "1", "4", "2", "3", "Item", "Void Item", "Item", "Void Item", 3, reportSource, subreportSource);
            t.generateReport();
        } else if (adding2 && voiding2) {
            GetReport t = new GetReport(restId, kotNo, "2", "3", "4", "1", "Item", "Void Item", "Void Item", "Item", 3, reportSource, subreportSource);
            t.generateReport();
        } else if (adding2) {
            GetReport t = new GetReport(restId, kotNo, "2", "4", "3", "1", "Item", "Void Item", "Void Item", "Item", 3, reportSource, subreportSource);
            t.generateReport();
        } else if (voiding2) {
            GetReport t = new GetReport(restId, kotNo, "3", "4", "1", "2", "Void Item", "Void Item", "Item", "Item", 3, reportSource, subreportSource);
            t.generateReport();
        } else if (delete2) {
            GetReport t = new GetReport(restId, kotNo, "4", "1", "2", "3", "Void Item", "Item", "Item", "Void Item", 3, reportSource, subreportSource);
            t.generateReport();
        }

        if (add1 && adding1 && voiding1) {
            GetReport t = new GetReport(restId, kotNo, "1", "2", "3", "4", "Item", "Item", "Void Item", "Void Item", 2, reportSource, subreportSource);
            t.generateReport();
        } else if (add1 && adding1) {
            GetReport t = new GetReport(restId, kotNo, "1", "2", "4", "3", "Item", "Item", "Void Item", "Void Item", 2, reportSource, subreportSource);
            t.generateReport();
        } else if (add1 && voiding1) {
            GetReport t = new GetReport(restId, kotNo, "1", "3", "4", "2", "Item", "Void Item", "Void Item", "Item", 2, reportSource, subreportSource);
            t.generateReport();
        } else if (add1) {
            GetReport t = new GetReport(restId, kotNo, "1", "4", "2", "3", "Item", "Void Item", "Item", "Void Item", 2, reportSource, subreportSource);
            t.generateReport();
        } else if (adding1 && voiding1) {
            GetReport t = new GetReport(restId, kotNo, "2", "3", "4", "1", "Item", "Void Item", "Void Item", "Item", 2, reportSource, subreportSource);
            t.generateReport();
        } else if (adding1) {
            GetReport t = new GetReport(restId, kotNo, "2", "4", "3", "1", "Item", "Void Item", "Void Item", "Item", 2, reportSource, subreportSource);
            t.generateReport();
        } else if (voiding1) {
            GetReport t = new GetReport(restId, kotNo, "3", "4", "1", "2", "Void Item", "Void Item", "Item", "Item", 2, reportSource, subreportSource);
            t.generateReport();
        } else if (delete1) {
            GetReport t = new GetReport(restId, kotNo, "4", "1", "2", "3", "Void Item", "Item", "Item", "Void Item", 2, reportSource, subreportSource);
            t.generateReport();
        }

        if (add && adding && voiding) {
            GetReport t = new GetReport(restId, kotNo, "1", "2", "3", "4", "Item", "Item", "Void Item", "Void Item", 1, reportSource, subreportSource);
            t.generateReport();
        } else if (add && adding) {
            GetReport t = new GetReport(restId, kotNo, "1", "2", "4", "3", "Item", "Item", "Void Item", "Void Item", 1, reportSource, subreportSource);
            t.generateReport();
        } else if (add && voiding) {
            GetReport t = new GetReport(restId, kotNo, "1", "3", "4", "2", "Item", "Void Item", "Void Item", "Item", 1, reportSource, subreportSource);
            t.generateReport();
        } else if (add) {
            GetReport t = new GetReport(restId, kotNo, "1", "4", "2", "3", "Item", "Void Item", "Item", "Void Item", 1, reportSource, subreportSource);
            t.generateReport();
        } else if (adding && voiding) {
            GetReport t = new GetReport(restId, kotNo, "2", "3", "4", "1", "Item", "Void Item", "Void Item", "Item", 1, reportSource, subreportSource);
            t.generateReport();
        } else if (adding) {
            GetReport t = new GetReport(restId, kotNo, "2", "4", "3", "1", "Item", "Void Item", "Void Item", "Item", 1, reportSource, subreportSource);
            t.generateReport();
        } else if (voiding) {
            GetReport t = new GetReport(restId, kotNo, "3", "4", "1", "2", "Void Item", "Void Item", "Item", "Item", 1, reportSource, subreportSource);
            t.generateReport();
        } else if (delete) {
            GetReport t = new GetReport(restId, kotNo, "4", "1", "2", "3", "Void Item", "Item", "Item", "Void Item", 1, reportSource, subreportSource);
            t.generateReport();
        }
    }

    private void deletetempItem(int kotNo) {
        posService.deletetempItem(kotNo);
    }

    private void insertKotBotitemTemp(int kotNo, String itemCode, int qty, int typ, int printer) {
        posService.insertKotBotitemTemp(kotNo, Integer.parseInt(itemCode), qty, typ, printer);
    }

    private void insertVoidItem(int kotNo, String itemCode, int voidQty, Integer voidRes, JSONObject orderDetails) {
        posService.insertVoidItem(kotNo, Integer.parseInt(itemCode), voidQty, voidRes, orderDetails);
    }

    private void voidtempItem(int kotId, List<FrontKotBotItem> beforRawItems, JSONArray voidItemsBucket) {
        HashMap<String, Integer> itemBuct = new HashMap<String, Integer>();
        for (int j = 0; j < beforRawItems.size(); j++) {
            FrontKotBotItem item = beforRawItems.get(j);
            String itemCode = item.getItemCode() + "";
            int itemQty = item.getQty().intValue();
            itemBuct.put(itemCode, itemQty);
        }

        for (int j = 0; j < voidItemsBucket.length(); j++) {
            JSONObject voiditem = voidItemsBucket.getJSONObject(j);
            String voidItemCode = voiditem.getInt("itemCode") + "";
            int voidItemQty = voiditem.getInt("qty");
            int voidNo = voiditem.getInt("voidNo");

            if (itemBuct.containsKey(voidItemCode)) {
                int comCount = itemBuct.get(voidItemCode) - voidItemQty;
                if (comCount <= 0) {
                    String ItemCode = voidItemCode;
//                        if (isInventry) {
//                            int beforeCount = ic.getkotItemQty(txtKotNo.getText(), ItemCode);
//                            System.out.println("changeMenuR5beforeCount=" + beforeCount);
//                            ic.checkInventryUpdate(txtKotNo.getText(), ItemCode, beforeCount);
//                        }
                    posService.deleteKotBotTax(kotId, ItemCode);
                }
            }

        }
    }

    private void exitvoidtempItem(int kotId, JSONArray voidItemsBucket, JSONObject orderDetails) {

        for (int j = 0; j < voidItemsBucket.length(); j++) {
            JSONObject voiditem = voidItemsBucket.getJSONObject(j);
            String voidItemCode = voiditem.getInt("itemCode") + "";
            int voidItemQty = voiditem.getInt("qty");
            int voidNo = voiditem.getInt("voidNo");
//                        if (isInventry) {
//                            int beforeCount = ic.getkotItemQty(txtKotNo.getText(), ItemCode);
//                            System.out.println("changeMenuR5beforeCount=" + beforeCount);
//                            ic.checkInventryUpdate(txtKotNo.getText(), ItemCode, beforeCount);
//                        }
            posService.deleteKotBotTax(kotId, voidItemCode);
            posService.insertVoidItem(kotId, voiditem.getInt("itemCode"), voidItemQty, voidNo, orderDetails);
            posService.deleteKotBotMenus(kotId);
        }
    }

    @RequestMapping(value = {"casGetBillDetails"}, method = RequestMethod.GET)
    public @ResponseBody
    OpenedBillDetails casGetBillDetails(@RequestParam(value = "kotNo", defaultValue = "0") int kotNo) {
        OpenedBillDetails oderedBillDetails = posService.getBillDetails(kotNo);
        return oderedBillDetails;
    }
// OrderController/casGetSettlementDetails

    @RequestMapping(value = {"casGetSettlementDetails"}, method = RequestMethod.GET)
    public @ResponseBody
    SettlementDetails casGetSettlementDetails() {
        SettlementDetails getSettlementDetails = posService.getSettlementDetails();
        return getSettlementDetails;
    }

    @Consumes("application/json")
    @RequestMapping(value = {"casSetPostingData"}, method = RequestMethod.POST)
    public @ResponseBody
    MsgContainer casSetPostingData(HttpServletRequest request, HttpServletResponse response) {//@RequestBody Map<String, Object> map
        MsgContainer msg = new MsgContainer();
        JSONObject jsonObj = new JSONObject();
        Map<String, String[]> params = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : params.entrySet()) {
            String v[] = entry.getValue();
            Object o = (v.length == 1) ? v[0] : v;
            jsonObj.put(entry.getKey(), o);
        }
//        JSONObject jsonObj = new JSONObject(map.get("casSetPostingData").toString());
//        System.out.println("***"+request.toString());
//        System.out.println("+++"+response.toString());        
//        JSONArray itemList = new JSONArray(request.getParameter("itemBucket"));
//        JSONArray voidItemList = new JSONArray(request.getParameter("voidItemBucket"));
//        JSONObject orderDetails = new JSONObject(request.getParameter("orderDetails"));

//        if(orderService.addItems(orderDetails, itemList)){
//        if (addItems(orderDetails, itemList, voidItemList)) {
//            msg.setMsg("done");
//        } else {
//            msg.setMsg("undone");
//        }
        return msg;
    }
}
