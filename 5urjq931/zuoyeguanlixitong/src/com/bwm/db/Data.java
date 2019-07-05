package com.bwm.db;

import java.sql.*;

public class Data {

    private Conn con = new Conn();
    private Statement stmt;
    private ResultSet rs;


    public int getRowCount(String strSql) {
        int intCount = 0;
        try {
            stmt = con.getStmtread();
            rs = stmt.executeQuery("SELECT COUNT(*) FROM " + strSql);
            if (rs.next()) {
                intCount = rs.getInt(1);
            } else {
                intCount = -1;
            }
        } catch (Exception e) {
            intCount = -2;
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            con.close();
            return intCount;
        }
    }

   
    public int insert(String sql) {
        int count = 0;
        stmt = con.getStmt();
        try {
            count = stmt.executeUpdate(sql);
        } catch (Exception e) {
            count = -2;
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            con.close();
            return count;
        }
    }

    public int update(String sql) {
        int count = 0;
        stmt = con.getStmt();
        try {
            count = stmt.executeUpdate(sql);
        } catch (Exception e) {
            count = -2;
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            con.close();
            return count;
        }
    }

    public int delete(String sql) {
        int count = 0;
        stmt = con.getStmt();
        try {
            count = stmt.executeUpdate(sql);
        } catch (Exception e) {
            count = -2;
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            con.close();
            return count;
        }
    }
}