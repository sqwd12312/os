package com.bwm.db;

import java.sql.*;


public class Conn {
  
    private Statement stmt;
    private ResultSet rs;
  //���ӵ����ݿ��URL
  	public static final String dbUrl="jdbc:mysql://localhost:3306/homeworksubmit";
  	//���ӵ����ݿ���û���
  	public static final String dbUser="root";
  	//���ݿ�����
  	public static final String dbPwd="root";
  	
  	//����һ��Connection ����
  	static Connection con;
  	
  	public static Connection getConnInstance(){
  			  
  			try {
  				 //����mysql������
  				Class.forName("com.mysql.jdbc.Driver");
  			} catch (ClassNotFoundException e) {
  				System.out.println("����mysql������ʧ�ܣ�");
  				e.printStackTrace();
  			}
//  			System.out.println("����mysql�������ɹ�");
  		
  		try {
  			//�������ݿ�����
  			con=DriverManager.getConnection(dbUrl,dbUser,dbPwd);
  		} catch (SQLException e) {
  			System.out.println("���ݿ�����ʧ�ܣ�");
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