package org.dteam.dao;

import java.sql.*;

import static org.dteam.dao.MySQLDAOFactory.*;

public class MySQLA1cDAO implements A1cDAO {

	@Override
	public int addLabValue(double labValue, String userID) throws SQLException {
		connectToDB();
		try {
			String sql = "UPDATE a1c SET LabValue =" + "'" + labValue + "'" + " WHERE UserID = " + "'" + userID + "'";
			return statement.executeUpdate(sql);
		} finally {
			closeDB();
		}		
	}

	@Override
	public double getLabValue(String userID) throws SQLException {
		connectToDB();
		double LabValue = 0;
		try {
			String sql = "SELECT LabValue FROM A1c WHERE userID = " + "'" + userID + "';";
			ResultSet rs;
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				LabValue = rs.getDouble("LabValue");
			}
		} finally {
			closeDB();
		}
		return LabValue;

	}
}