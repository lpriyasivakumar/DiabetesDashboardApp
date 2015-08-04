package org.dteam.dao;

import java.sql.*;

import org.dteam.model.A1cReading;

import static org.dteam.dao.MySQLDAOFactory.*;

public class MySQLA1cDAO implements A1cDAO {

	@Override
	public int addLabValue(double labValue, String userID) {
		connectToDB();
		try {
		    String sql = "DELETE LabValue FROM A1c;";
		    statement.executeUpdate(sql);
			String sql1 = "Insert into A1CReading(labValue, userID) " + "values ('" +userID+ "','" +labValue+ "')";
			return statement.executeUpdate(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
		return 0;
}

	@Override
	public A1cReading getLabValue(String userID) {
		connectToDB();
		A1cReading a1cReading = new A1cReading();
		try {
			String sql = "SELECT LabValue FROM A1c;";
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				a1cReading.setLabA1c(rs.getDouble("LabValue"));
			}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		closeDB();
		
		return a1cReading;
	}	
	
	public static int getAvgBG(String userID) {
		connectToDB();
		try{
			String sql = "SELECT BG_AVG AS AVG(BloodGlucose) FROM Reading GROUP BY ReadingDate "
				+ "WHERE ReadingDate BETWEEN DATE_SUB(CURDATE(), INTERVAL"
				+ " 90 DAY) and CURDATE();";
			ResultSet rs =  statement.executeQuery(sql);
			if(rs.next()) {
				return rs.getInt("BG_AVG");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
			closeDB();
			return 0;
	}	
}