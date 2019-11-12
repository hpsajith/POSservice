package com.ites.poswebservice.report;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by admin on 1/31/17.
 */
public class GetReport {
    
    public GetReport() {}
    
    private DBFacade db = new DBFacade();
//    private Thread t;
    private String kotNo;
    private String type;
    private String type1;
    private String type2;
    private String type3;
    private String head;
    private String head1;
    private String head2;
    private String head3;
    private int printer;
    private int restId;
    private String resourcePathPath;
    private String subreportPath;


    public GetReport(int restId, int kotNo, String type, String type1, String type2, String type3, String head, String head1, String head2, String head3, int printer,String resourcePathPath,String subreportPath){
        this.restId = restId;
        this.kotNo =kotNo+"";
        this.type=type;
        this.type1=type1;
        this.type2=type2;
        this.type3=type3;
        this.head=head;
        this.head1=head1;
        this.head2=head2;
        this.head3=head3;
        this.printer=printer;
        this.resourcePathPath=resourcePathPath;
        this.subreportPath=subreportPath;
    }
    public void generateReport() {
     
        try {
            System.out.println("Running thread  " +  kotNo +" ++++ "+ printer);
            addSeperateSerialKBNo(kotNo, printer);
            ReportManager report = new ReportManager();
            Connection cnn = db.connect();
            String reportSource = null;
            String subreportSource = null;
//            if (printer == 1) {  
                System.out.println("**********"+resourcePathPath);
//                reportSource = webPath+"/Report/KotItem/kotItem.jrxml";
                reportSource =resourcePathPath;
//                subreportSource = webPath+"/Report/KotItem/";
                subreportSource = subreportPath;
//            }
//            else {
//                System.out.println("**********"+webPath+"/Report/BotItem/kotItem.jrxml");
//                reportSource = webPath+"/Report/BotItem/kotItem.jrxml";
//                subreportSource = webPath+"/Report/BotItem/";                
//            }
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("head", head);
            params.put("head1", head1);
            params.put("head2", head2);
            params.put("head3", head3);
            params.put("type", type);
            params.put("type1", type1);
            params.put("type2", type2);
            params.put("type3", type3);
            params.put("kotNo", kotNo);
            params.put("printer", printer);
            params.put("restName", getRestName(restId));
            params.put("SUBREPORT_DIR", subreportSource);
            params.put("REPORT_CONNECTION", cnn);
            report.generateReport(reportSource, params, "Kot Item Report", cnn, printer, restId);
            System.out.println("Thread " +  kotNo + " exiting.");
            report = null;
            cnn = null;
            reportSource = null;
            subreportSource = null;
            params = null;
            type = null;
            type1 = null;
            type3 = null;
            type2 = null;
            head = null;
            head1 = null;
            head2 = null;
            head3 = null;
            Thread.sleep(50);
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }

    public void addSeperateSerialKBNo(String kotNo, int printerID) {
        System.out.println("CALL SP--->>>addSeperateSerialKBNo");
        String spSql1 = "CALL addSeperateSerialKBNo(" + kotNo + "," + printerID + ")";
        try {
            db.save(spSql1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        spSql1 = null;
    }

    public String getRestName(int restId) {
        String restName = "";
        ResultSet rs = null;
        rs = new FormDBControl().select("select r_name from m_restaurant where restraunt_id='" + restId + "'");
        try {
            while (rs.next()) {
                restName = rs.getString("r_name");
            }
            rs.close();
            rs = null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return restName;
    }
}
