package com.ites.poswebservice.controller;

import com.ites.poswebservice.model.hotelpos.TableConfig;
import com.ites.poswebservice.model.random.LoadRestItem;
import com.ites.poswebservice.model.random.MsgContainer;
import com.ites.poswebservice.model.random.OpenTableDetail;
import com.ites.poswebservice.model.random.TableLoad;
import com.ites.poswebservice.services.TableService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/TableController"})
public class TableController {

    @Autowired
    private TableService tableService;

    /**
     * HTTP endpoint to get all the tables configurations available in the
     * system.
     *
     * {@link} GET [Host]:[Port]/TableController/getAllTables
     *
     * @return List<TableConfig>
     */
    @RequestMapping(value = {"getAllTables"}, method = RequestMethod.GET)
    public @ResponseBody
    List<TableLoad> getAllTables(@RequestParam(value = "id", defaultValue = "0") int restid, @RequestParam(value = "userId", defaultValue = "0") int userId) {
        List<TableLoad> tables = tableService.getAllTables(restid, userId);
        return tables;
    }

    /**
     * HTTP endpoint to a particular table configurations available in the
     * system.
     *
     * {@link} GET [Host]:[Port]/TableController/getTable
     *
     * @param int id
     *
     * @return List<TableConfig>
     */
    @RequestMapping(value = {"getTable"}, method = RequestMethod.GET)
    public @ResponseBody
    TableConfig getTable(@RequestParam(value = "id", defaultValue = "0") int id) {
        TableConfig table = tableService.getTable(id);
        return table;
    }

    @RequestMapping(value = {"getOpenTableDetail"}, method = RequestMethod.GET)
    public @ResponseBody
    List<OpenTableDetail> getOpenTableDetail(@RequestParam(value = "id", defaultValue = "0") int tableId) {
        List<OpenTableDetail> table = tableService.getOpenTableDetail(tableId);
        return table;
    }

    @RequestMapping(value = {"closeGuestBill"}, method = RequestMethod.GET)
    public @ResponseBody
    String closeGuestBill(@RequestParam(value = "kotNo", defaultValue = "0") int kotNo) {
        String msg = "";
        try {
            tableService.updateOpenTableState(kotNo);
            msg = "Table Closed";
        } catch (Exception ex) {
            msg = "undone";
            ex.printStackTrace();
        }
        System.out.println("dddddddddd" + msg);
        return msg;
    }
}
