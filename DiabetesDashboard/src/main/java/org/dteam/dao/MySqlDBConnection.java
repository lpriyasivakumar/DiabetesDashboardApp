package org.dteam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MySqlDBConnection {
	static final String host = "jdbc:mysql://localhost:3306/diabetic_dashboard_data";
	static final String userName = "root";
	static final String password = "*********";
	static Connection conn;

	public void connectToDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host, userName, password);	
			
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
//		finally {
//			try {
//				if (stmt != null)
//					conn.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}

	}
	
		
}
