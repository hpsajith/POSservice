package com.ites.poswebservice.report;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by admin on 1/31/17.
 */
public class DBFacade {
    private static Connection c = null;
    protected static String DB = "hotelpos";
    protected static String username = "itesgfinance";
    protected static String pasword = "itesg@finance";
    protected static String host = "localhost";
    protected static String port = "3306";

    public String getHost(){
        return host;
    }
    public static Connection connect() {
        try {
            if (c == null || c.isClosed()) {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String url = "jdbc:mysql://" + host + ":" + port + "/" + DB;
                c = DriverManager.getConnection(url, username, pasword);
            }
        } catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException ex) {
            // alert that "Network Connection Fail
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return c;
    }

    public void save(String sql) throws Exception {
        if (c == null) {
            connect();
        }
        System.out.println(sql);
        try {
            c.createStatement().executeUpdate(sql);
        } catch (Exception e) {
            c = null;
        }
    }

    public ResultSet fetch(String sql) throws Exception {
        if (c == null) {
            connect();
        }
        System.out.println(sql);
        try {
            return c.createStatement().executeQuery(sql);
        } catch (Exception e) {
            c = null;
            return null;
        }
    }

    public PreparedStatement psmt(String sql) throws Exception {
        if (c == null) {
            connect();
        }
        System.out.println(sql);
        try {
            return (PreparedStatement) c.prepareStatement(sql);
        } catch (Exception e) {
            c = null;
            return null;
        }
    }
}
