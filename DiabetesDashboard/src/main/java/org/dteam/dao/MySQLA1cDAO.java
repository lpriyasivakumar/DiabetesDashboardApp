package org.dteam.dao;

import java.sql.*;

import static org.dteam.dao.MySQLDAOFactory.*;

public class MySQLA1cDAO implements A1cDAO {

	@Override
	public int addLabValue(double labValue, String userID) throws SQLException {
		connectToDB();
		String sql = "UPDATE a1c SET LabValue =" + "'" + labValue + "'"
				+ " WHERE UserID = " + "'" + userID + "'";
		int result = statement.executeUpdate(sql);
		closeDB();
		return result;

	}

	@Override
	public double getLabValue(String userID) throws SQLException {
		connectToDB();
		double LabValue = 0;
		String sql = "SELECT LabValue FROM A1c WHERE userID = " + "'" + userID
				+ "';";
		ResultSet rs;
		rs = statement.executeQuery(sql);
		if (rs.next()) {
			LabValue = rs.getDouble("LabValue");
		}
		closeDB();
		return LabValue;

	}
}