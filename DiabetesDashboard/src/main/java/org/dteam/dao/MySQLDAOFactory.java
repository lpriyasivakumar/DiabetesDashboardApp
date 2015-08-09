package org.dteam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDAOFactory extends DAOFactory {

	static final String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
	static final String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
	private static final String userName = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
	private static final String password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
	private static final String url = String.format("jdbc:mysql://%s:%s/diabetesdashboard", host,port);
	public static Connection conn;
	static Statement statement = null;

	public static void connectToDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(getUrl(), getUsername(), getPassword());
			statement = conn.createStatement();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeDB() {
		try {

			if (statement != null) {
				conn.close();
			}
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

	public static String getUrl() {
		return url;
	}

	public static String getUsername() {
		return userName;
	}

	public static String getPassword() {
		return password;
	}

}
