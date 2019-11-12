package com.ites.poswebservice.report;

import com.mysql.jdbc.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 1/31/17.
 */
public class FormDBControl {
    DBFacade db = new DBFacade();

    public boolean addFamilyGroup(int MajorGroupNameNo, String FamilyGroupName, String FamilyGroupCode, String t) {
        boolean bln = false;
        try {
            PreparedStatement pm = (PreparedStatement) db.psmt("INSERT INTO family_group(F_M_no,F_name,F_report_cord,F_image)" + "values(?,?,?,?)");
            pm.setInt(1, MajorGroupNameNo);
            pm.setString(2, FamilyGroupName);
            pm.setString(3, FamilyGroupCode);
            pm.setString(4, t);
            pm.executeUpdate();
            bln = true;
            pm = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            //   log.logWrite(this.getClass().getName(), ex.toString());
        }
        FamilyGroupCode = null;
        FamilyGroupName = null;
        t = null;

        return bln;
    }

    //insert master data
    public boolean addMasterGroup(int masterMNo, int masterFNo, String masterName, String masterReport, String ima) {
        boolean bln = false;
        try {
            PreparedStatement pm = (PreparedStatement) db.psmt("INSERT INTO master_group(Master_m_no,Master_F_no,Master_name,Master_Report,Master_image)" + "values(?,?,?,?,?)");
            pm.setInt(1, masterMNo);
            pm.setInt(2, masterFNo);
            pm.setString(3, masterName);
            pm.setString(4, masterReport);
            pm.setString(5, ima);
            pm.executeUpdate();

            bln = true;
            pm = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            //   log.logWrite(this.getClass().getName(), ex.toString());
        }
        masterName = null;
        masterReport = null;
        ima = null;
        return bln;
    }

    //get Major group
    public boolean addMajorGroup(String name, String code, String iamg) {

        boolean bln = false;
        try {
            PreparedStatement pm = (PreparedStatement) db.psmt("INSERT INTO major_group(M_name,M_Report_group,M_image)" + "values(?,?,?)");
            pm.setString(1, name);
            pm.setString(2, code);
            pm.setString(3, iamg);
            pm.executeUpdate();

            bln = true;
            pm = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        name = null;
        code = null;
        iamg = null;
        return bln;
    }

    public ResultSet getFamilyNames(int k) {
        String Sql = "Select M_name from major_group WHERE M_no =" + k + "";
        try {
            return (ResultSet) db.fetch(Sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    //get name of family groups to view table master group
    public ResultSet getFamilyNamestomaster(int k) {
        String Sql = "Select F_name from family_group WHERE F_no =" + k + "";
        try {
            return (ResultSet) db.fetch(Sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
//

    public ResultSet select(String sql1) {
        try {
            return (ResultSet) db.fetch(sql1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String[] selectArrayGroupName(String sql, String item) throws SQLException {
        String[] a = null;
        int k = 0;
        ResultSet rs = null;
        try {
            rs = (ResultSet) db.fetch(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        rs.last();
        int rown = rs.getRow();
        a = new String[rown];
        rs.beforeFirst();
        while (rs.next()) {
            a[k] = rs.getString(item);
            k++;
        }
        rs.close();
        rs = null;
        item = null;
        sql = null;
        return a;
    }

    //get Major group for family group form
    public int getIdNo(String sql, String param) {

        int no = 0;
        try {

            ResultSet rs = null;
            rs = (ResultSet) db.fetch(sql);
            while (rs.next()) {
                no = rs.getInt(param);
            }
            rs.close();
            rs = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            //  Logger.getLogger(RoomControl.class.getName()).log(Level.SEVERE, null, ex);
            //  log.logWrite(this.getClass().getName(), ex.toString());
        }
        param = null;
        sql = null;
        return no;
    }
//set major group detail after editing

    public boolean updatemajorGroup(int id, String name, String code, String ima) {
        boolean bln = false;
        try {

            PreparedStatement pm = (PreparedStatement) db.psmt("Update major_group set M_name=?, M_Report_group=?,M_image=? where M_no=" + id + "");
            pm.setString(1, name);
            pm.setString(2, code);
            pm.setString(3, ima);
            pm.executeUpdate();
            bln = true;
            pm = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            // log.logWrite(this.getClass().getName(), ex.toString());
        }
        name = null;
        code = null;
        ima = null;
        return bln;
    }
//update family group data\base

    public boolean updateFamilyGroup(int id, int majorGroupNo, String name, String code, String m) {
        boolean bln = false;
        try {

            PreparedStatement pm = (PreparedStatement) db.psmt("Update family_group set F_M_no=?,F_name=?, F_report_cord=?,F_image=? where F_no=" + id + "");
            pm.setInt(1, majorGroupNo);
            pm.setString(2, name);
            pm.setString(3, code);
            pm.setString(4, m);


            pm.executeUpdate();
            bln = true;
            pm = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            // log.logWrite(this.getClass().getName(), ex.toString());
        }
        name = null;
        code = null;
        m = null;
        return bln;
    }

    public boolean updateMaster(int id, int majorGroupNo, int faminigNo, String name, String code, String ima) {
        boolean bln = false;
        try {
            PreparedStatement pm = (PreparedStatement) db.psmt("Update master_group set Master_m_no=?,Master_F_no=?, Master_name=?,Master_Report=?,Master_image=? where Master_no=" + id + "");
            pm.setInt(1, majorGroupNo);
            pm.setInt(2, faminigNo);
            pm.setString(3, name);
            pm.setString(4, code);
            pm.setString(5, ima);
            pm.executeUpdate();
            bln = true;
            pm = null;
        } catch (Exception ex) {
            ex.printStackTrace();
            // log.logWrite(this.getClass().getName(), ex.toString());
        }
        name = null;
        code = null;
        ima = null;
        return bln;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        db = null;
    }
}
