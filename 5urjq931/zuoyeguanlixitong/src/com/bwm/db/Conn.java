package com.bwm.db;

import java.sql.*;


public class Conn {
  
    private Statement stmt;
    private ResultSet rs;
  //连接到数据库的URL
  	public static final String dbUrl="jdbc:mysql://localhost:3306/homeworksubmit";
  	//连接到数据库的用户名
  	public static final String dbUser="root";
  	//数据库密码
  	public static final String dbPwd="root";
  	
  	//声明一个Connection 对象
  	static Connection con;
  	
  	public static Connection getConnInstance(){
  			  
  			try {
  				 //加载mysql驱动器
  				Class.forName("com.mysql.jdbc.Driver");
  			} catch (ClassNotFoundException e) {
  				System.out.println("加载mysql驱动器失败：");
  				e.printStackTrace();
  			}
//  			System.out.println("加载mysql驱动器成功");
  		
  		try {
  			//建立数据库连接
  			con=DriverManager.getConnection(dbUrl,dbUser,dbPwd);
  		} catch (SQLException e) {
  			System.out.println("数据库连接失败：");
  			e.printStackTrace();
  			return null;
  		}
  		
  		return con;
  	}

    public Statement getStmtread() {
        try {
            con = getConnInstance();
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                       ResultSet.CONCUR_READ_ONLY);
            return stmt;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    public ResultSet getRs(String sql) {
        try {
            stmt = getStmtread();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    public Statement getStmt() {
        try {
            con = getConnInstance();
            stmt = con.createStatement();
            return stmt;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    public synchronized void close() {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            if (con != null) {
                con.close();
                con = null;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}