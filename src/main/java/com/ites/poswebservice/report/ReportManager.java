package com.ites.poswebservice.report;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRSaver;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.PrinterName;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;

/**
 * Created by admin on 1/31/17.
 */
public class ReportManager {
    JasperPrint jasperPrint = null;
    JasperReport jasperReport;
    private Map<String, Object> params;
    /**
     * Creates a new instance of reportManager
     */
    public ReportManager() {
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        params = null;
        jasperReport = null;
        jasperPrint = null;
    }

    public void generateReport(String reportSource, Map<String, Object> params, String title, Connection con, int printer) {
        {
            try {
                jasperReport = JasperCompileManager.compileReport(reportSource);
                jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
                if (printer == 1) {
                    JasperExportManager.exportReportToPdfFile(jasperPrint, "C://my/abc1.pdf");
                    JRSaver.saveObject(jasperPrint, "C://my/posReport1.jrprint");
                } else {
                    JasperExportManager.exportReportToPdfFile(jasperPrint, "C://my/abc2.pdf");
                    JRSaver.saveObject(jasperPrint, "C://my/posReport2.jrprint");
                }

                Print(printerName(printer), printer);
            } catch (JRException ex) {
                params = null;
                reportSource = null;
                title = null;
                ex.printStackTrace();
            }
        }
        params = null;
        reportSource = null;
        title = null;
    }

    public void generateReport(String reportSource, Map<String, Object> params, String title, Connection con, int printer, int restId) {
        {
            try {
                jasperReport = JasperCompileManager.compileReport(reportSource);
                jasperPrint = JasperFillManager.fillReport(jasperReport, params, con);
                if (printer == 1) {
//                    JasperExportManager.exportReportToPdfFile(jasperPrint, "C://my/abc1.pdf");
//                    JRSaver.saveObject(jasperPrint, "C://my/posReport1.jrprint");
                    JasperExportManager.exportReportToPdfFile(jasperPrint, "..//10.1.1.63/Users/Admin/Desktop/my/abc1.pdf");
                    JRSaver.saveObject(jasperPrint, "..//10.1.1.63/Users/Admin/Desktop/my/posReport1.jrprint");
                } else {
//                    JasperExportManager.exportReportToPdfFile(jasperPrint, "C://my/abc2.pdf");
//                    JRSaver.saveObject(jasperPrint, "C://my/posReport2.jrprint");
                    JasperExportManager.exportReportToPdfFile(jasperPrint, "..//10.1.1.63/Users/Admin/Desktop/my/abc2.pdf");
                    JRSaver.saveObject(jasperPrint, "..//10.1.1.63/Users/Admin/Desktop/my/posReport2.jrprint");
                }
                Print(printerName(printer, restId), printer);
            } catch (JRException ex) {
                params = null;
                reportSource = null;
                title = null;
                ex.printStackTrace();
            }
        }
        params = null;
        reportSource = null;
        title = null;
    }

    private String printerName(int printerId) {
        String printName = "";
        DBFacade db = new DBFacade();
        ResultSet rs;
        try {
            rs = db.fetch("SELECT printerName FROM m_print WHERE  printId='" + printerId + "'");
            if (rs.next()) {
                printName = rs.getString("printerName");
            }
            rs.close();
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return printName;
    }

    private String printerName(int printerId, int restId) {
        String printName = "";
        DBFacade db = new DBFacade();
        ResultSet rs;
        try {
            rs = db.fetch("SELECT Printer_Name FROM config_restaurant_printer  INNER JOIN m_printer   ON (config_restaurant_printer.Printer_ID = m_printer.Pk_No) WHERE Restaurant_ID ='" + restId + "' AND config_restaurant_printer.Printer_Type = '" + printerId + "' AND Active = 1");
            if (rs.next()) {
                printName = rs.getString("Printer_Name");
            }
            rs.close();
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return printName;
    }

    public void Print(String name) {
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
//        attributeSet.add(MediaSizeName.ISO_A7);

        PrintServiceAttributeSet set = new HashPrintServiceAttributeSet();

        set.add(new PrinterName(name, null));
        System.out.println("rrrrr" + name);
        JRPrintServiceExporter exporter = new JRPrintServiceExporter();

        exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport.jrprint");
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, attributeSet);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, set);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
        try {
            exporter.exportReport();
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }

    public void Print(String name, int printerId) {
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        PrintServiceAttributeSet set = new HashPrintServiceAttributeSet();

        set.add(new PrinterName(name, null));
        JRPrintServiceExporter exporter = new JRPrintServiceExporter();

        if (printerId == 1) {
//            exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport1.jrprint");
exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "..//10.1.1.63/Users/Admin/Desktop/my/posReport1.jrprint");
        } else {
//            exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport2.jrprint");
exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "..//10.1.1.63/Users/Admin/Desktop/my/posReport2.jrprint");
        }

        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, attributeSet);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, set);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
        try {
            exporter.exportReport();
        } catch (JRException ex) {
            ex.printStackTrace();
        }

    }

    public void Print1() {
        PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
        PrintServiceAttributeSet set = new HashPrintServiceAttributeSet();
        set.add(new PrinterName("EPSON TM-U220 Receipt", null));

        JRPrintServiceExporter exporter = new JRPrintServiceExporter();

        exporter.setParameter(JRExporterParameter.INPUT_FILE_NAME, "C://my/posReport.jrprint");
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, attributeSet);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, set);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
        try {
            exporter.exportReport();
        } catch (JRException ex) {
            // pass the message that "Printer is not found"
        }
    }

    
    public String document_parth() {
        String a = System.getProperty("user.dir") + File.separatorChar + "src\\Report\\";
        return a;
    }
}
