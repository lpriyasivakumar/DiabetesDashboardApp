package org.dteam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDAOFactory extends DAOFactory {

	static final String host = "jdbc:mysql://localhost:3306/diabetic_dashboard_data";
	static final String userName = "root";
	static final String password = "*********";
	static Connection conn;
	static Statement statement=null;

	public static void connectToDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(host, userName, password);
			statement = conn.createStatement();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void closeDB(){
		try {
				if (statement != null)
					conn.close();
			 } catch (SQLException se) {
			 se.printStackTrace();
			 }		
	}	

	

	@Override
	public UserDAO getUserDAO() {
		return new MySQLUserDAO();
	}

	@Override
	public ReadingDAO getReadingDAO() {
		return new MySQLReadingDAO();
	}

	@Override
	public A1cDAO getA1cDAO() {
		return new MySQLA1cDAO();
	}

}
