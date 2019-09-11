package com.srs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	
	private static Connection conn = null;
	private static Statement st = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	
	public static Connection getConnection(String dbName){
		String url = "jdbc:mysql://localhost:3306/"+dbName;
		String user = "root";
		String pwd = "root123";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Statement getSimpleStatement(){
		try{
		if(conn != null){
			st = conn.createStatement();
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
	return st;
	}
	
	public static PreparedStatement getPreparedStatement(String sql){
		try{
			if(conn != null){
				pst = conn.prepareStatement(sql);
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
		return pst;
	}
	public static void closeResources(){
		try{
			if(rs != null)
				rs.close();
			if(pst != null)
				pst.close();
			if(st != null)
				st.close();
			if(conn != null)
				conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}