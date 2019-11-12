/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ites.poswebservice.controller;

import com.ites.poswebservice.dao.PosDao;
import com.ites.poswebservice.model.hotelpos.FrontPosguest;
import com.ites.poswebservice.model.hotelpos.MVoidReason;
import com.ites.poswebservice.model.random.GuestProfile;
import com.ites.poswebservice.model.random.LoadRestItem;
import com.ites.poswebservice.model.random.MsgContainer;
import com.ites.poswebservice.report.DBFacade;
import com.ites.poswebservice.report.ReportManager;
import com.ites.poswebservice.services.GuestService;
import com.ites.poswebservice.services.PosService;
import com.ites.poswebservice.services.ReservationService;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ITESS
 */
@Controller
@RequestMapping(value = {"/GuestController"})
public class GuestController {

    @Autowired
    private GuestService guestService;
    @Autowired
    private ReservationService reservationService;
    @Autowired
    private PosDao posDao;
    @Autowired
    ServletContext servletContext;
        @Autowired
    private PosService posService;

    @RequestMapping(value = {"setPosGuestDetails"}, method = RequestMethod.POST)
    public
    @ResponseBody
    List<LoadRestItem> setPosGuestDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NullPointerException {
        response.setContentType("text/html;charset=UTF-8");
        boolean status = false;
        int i = 1;
        System.out.println("ttttttttt" +i);
        i++;

        List<LoadRestItem> loadRestItem = null;
        try {
            Integer tableNo = Integer.parseInt(request.getParameter("tableId"));
            Integer waiterNo = Integer.parseInt(request.getParameter("waiterId"));
            
            String firstName = request.getParameter("hAccountName");
            if(firstName.isEmpty()){
            firstName = request.getParameter("guestFname");
            }
            String lastName = request.getParameter("guestLname");
            Integer adult = Integer.parseInt(request.getParameter("adultsCount"));
            Integer children = Integer.parseInt(request.getParameter("kidsCount"));
            int restRoomNo = Integer.parseInt(request.getParameter("roomId"));
            String roomNo = request.getParameter("reservRoomNo");
            Integer confNo = Integer.parseInt(request.getParameter("confNo"));
            Integer mealNo = Integer.parseInt(request.getParameter("mealId"));
            Integer houseNo = Integer.parseInt(request.getParameter("hAccountId"));
            String package1 = request.getParameter("foodPackage");
            Integer restId = Integer.parseInt(request.getParameter("restaurantId"));
            String systemDate = reservationService.getNightAuditDate();

            GuestProfile obj = new GuestProfile();
            obj.setTableNo(tableNo);
            obj.setWaiterNo(waiterNo);
            obj.setFirstName(firstName);
            obj.setLastName(lastName);
            obj.setAdult(adult);
            obj.setChildren(children);
            obj.setRemrk("");
            obj.setStates(1);
            obj.setRestRoomNo(restRoomNo);
            obj.setRoomNo(roomNo);
            obj.setConfNo(confNo);
            obj.setMealNo(mealNo);
            obj.setHouseNo(houseNo);
            obj.setPackage1(package1);
            obj.setRestId(restId);
            obj.setSystemDate(systemDate);

//            status = guestService.setPosGuestDetails(obj);
            status = guestService.setPosGuestDetails(obj);
            status = guestService.setFrontKotBotMain(obj);
            status = guestService.setFrontBillSplit(obj);
            int kotNo = guestService.getKotNo();
            int posGbuestNo = guestService.getPosGuestNo(kotNo);
            List<MVoidReason> voidReson = posService.getVoidReason();
            loadRestItem = guestService.getRestaurantItem(restId);
            LoadRestItem loadRest = loadRestItem.get(0);
            loadRest.setVoidReasons(voidReson);
            loadRest.setKotNo(kotNo);
            loadRest.setPosGuestNo(posGbuestNo);
            
            loadRestItem.set(0, loadRest);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return status;
        return loadRestItem;
    }

    @RequestMapping(value = {"getSubItemList"}, method = RequestMethod.GET)
    public
    @ResponseBody
    List<LoadRestItem> getSubItemList(@RequestParam(value = "itemCode", defaultValue = "0") int itemCode) {
        List<LoadRestItem> loadRestItem = null;
        loadRestItem = guestService.getRestaurantItem(6);
        return loadRestItem;
    }

    @RequestMapping(value = {"getRestaurantItem"}, method = RequestMethod.GET)
    public
    @ResponseBody
    List<LoadRestItem> getRestaurantItem(@RequestParam(value = "restId", defaultValue = "0")int restId) {
        List<LoadRestItem> loadRestItem = null;
        List<MVoidReason> voidReson = posService.getVoidReason();
        loadRestItem = guestService.getRestaurantItem(restId);
        LoadRestItem loadRest = loadRestItem.get(0);
        loadRest.setVoidReasons(voidReson);
        return loadRestItem;
    }

    @RequestMapping(value = {"getPosGuestDetail"}, method = RequestMethod.GET)
    public
    @ResponseBody
    FrontPosguest getPosGuestDetail(@RequestParam(value = "guestNo", defaultValue = "0") int guestNo) {
        FrontPosguest guestDetail = null;
        guestDetail = guestService.getPosGuestDetail(guestNo);
        return guestDetail;
    }

    @RequestMapping(value = {"printGuestBill"}, method = RequestMethod.GET)
    public
    @ResponseBody
    MsgContainer printGuestBill(@RequestParam Map<String,String> params){
        MsgContainer msg = new MsgContainer();
        try{
//            String guestBillNumber = guestService.printGuestBill(Integer.valueOf(params.get("kotNo")),Integer.valueOf(params.get("userId")),Integer.valueOf(params.get("restId")), 0, params.get("userName"));
//            getReport(Integer.valueOf(params.get("kotNo")), guestBillNumber, Integer.valueOf(params.get("restId")), 0,  params.get("userName")); // generate guest bill
        getReport(6815, "test123", 1, 0,"testName"); // generate guest bill
            msg.setMsg("done");
        }catch(Exception ex){
            msg.setMsg("undone");
            ex.printStackTrace();
        }
        return msg;
    }
    
    
    public void getReport(int kotNo, String billNo, int restId, int posNo, String userName) {
        ReportManager report = new ReportManager();

        Connection cnn = DBFacade.connect();
        String reportSource = "";
        String subreportSource="";
        int x = posDao.getBillFormat();
        
        switch (x) {
            case 1:
                System.out.println("########"+servletContext.getRealPath("/WEB-INF/Report/GuestBill/GuestBill.jrxml"));
                reportSource = servletContext.getRealPath("/WEB-INF/Report/GuestBill/GuestBill.jrxml");
                subreportSource = servletContext.getRealPath("/WEB-INF/Report/GuestBill/");
                Map<String, Object> params = new HashMap<>();
                params.put("kotNo", kotNo);
                params.put("butName", userName);
//                params.put("pos_ID", posNo);
                params.put("billNo", billNo);
                params.put("SUBREPORT_DIR", subreportSource);
                params.put("REPORT_CONNECTION", cnn);
                report.generateReport(reportSource, params, "Kot Item Report", cnn, 3, restId);
                report = null;
                params = null;
                subreportSource = null;
                reportSource = null;
                cnn = null;
                break;
            case 2:
                InputStream logo = posDao.getCompanyLogo();
                String currencyName;
                double exchangeRate;
                String posName = posDao.getRestRoom(kotNo);

                currencyName = "Rs";
                exchangeRate = 1;
                System.out.println("########"+servletContext.getRealPath("/WEB-INF/Report/PosGuestBill2/GuestBill.jrxml"));
                reportSource = servletContext.getRealPath("/WEB-INF/Report/PosGuestBill2/GuestBill.jrxml");
                subreportSource = servletContext.getRealPath("/WEB-INF/Report/PosGuestBill2/");
                Map<String, Object> params1 = new HashMap<>();
                params1.put("PrintKots", "(" + kotNo + ")");
                params1.put("kotNo", "(" + kotNo + ")");
                params1.put("butName", userName);
                params1.put("pos_Name", posName);
                params1.put("comments", "");
                params1.put("copy", "");
                params1.put("logo", logo);
                params1.put("currencyName", currencyName);
                params1.put("exchangeRate", exchangeRate);
                params1.put("SUBREPORT_DIR", subreportSource);
                params1.put("REPORT_CONNECTION", cnn);
                report.generateReport(reportSource, params1, "Guest Bill", cnn, 3);
                report = null;
                cnn = null;
                reportSource = null;
                subreportSource = null;
                params = null;
                break;

            case 3:
                System.out.println("########"+servletContext.getRealPath("/WEB-INF/Report/GuestBillWithoutTax/GuestBill.jrxml"));
                reportSource = servletContext.getRealPath("/WEB-INF/Report/GuestBillWithoutTax/GuestBill.jrxml");
                subreportSource =  servletContext.getRealPath("/WEB-INF/Report/GuestBillWithoutTax/");
                Map<String, Object> params3 = new HashMap<String, Object>();
                params3.put("kotNo", kotNo);
                params3.put("butName", userName);
//                params3.put("pos_ID", posNo);
                params3.put("billNo", billNo);
                params3.put("SUBREPORT_DIR", subreportSource);
                params3.put("REPORT_CONNECTION", cnn);
                report.generateReport(reportSource, params3, "Kot Item Report", cnn, 3, restId);
                report = null;
                params = null;
                subreportSource = null;
                reportSource = null;
                cnn = null;
                break;
        }
    }
    
    @RequestMapping(value = {"updatePosGuestDetails"}, method = RequestMethod.POST)
    public
    @ResponseBody
    boolean updatePosGuestDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NullPointerException {
        FrontPosguest obj = new FrontPosguest();
        
        boolean status = guestService.updatePosGuestDetails(obj);
    return true;
    }
}
