package org.dteam.dao;

import java.sql.*;

import static org.dteam.dao.MySQLDAOFactory.*;

public class MySQLA1cDAO implements A1cDAO {

	@Override
	public int addLabValue(double labValue, String userID) {
		connectToDB();
		try {
			String sql = "UPDATE a1c SET LabValue =" + "'" + labValue + "'" + " WHERE UserID = " + "'" + userID + "'";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return 0;
	}

	@Override
	public double getLabValue(String userID) {
		connectToDB();
		double LabValue = 0;
		try {
			String sql = "SELECT LabValue FROM A1c WHERE userID = " + "'" + userID + "';";
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				LabValue = rs.getDouble("LabValue");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return LabValue;

	}
	
}