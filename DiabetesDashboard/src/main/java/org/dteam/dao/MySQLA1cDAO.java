package org.dteam.dao;

import java.sql.*;

import static org.dteam.dao.MySQLDAOFactory.*;

public class MySQLA1cDAO implements A1cDAO {

	@Override
	public int updateLabValue(double labValue, String userID) throws SQLException {
		connectToDB();
		String sql = "Update A1c set LabValue = '"+labValue+"' Where UserID= '"+userID+"';";
		int result = statement.executeUpdate(sql);
		closeDB();
		return result;

	}

	@Override
	public double getLabValue(String userID) throws SQLException {
		connectToDB();
		double LabValue = 0;
		String sql = "SELECT LabValue FROM A1c WHERE UserID = " + "'" + userID + "';";
		ResultSet rs;
		rs = statement.executeQuery(sql);
		if (rs.next()) {
			LabValue = rs.getDouble("LabValue");
		}
		closeDB();
		return LabValue;

	}

	@Override
	public int addLabValue(double labValue, String userID) throws SQLException {
		connectToDB();
		String sql = "Insert into A1c(UserID,LabValue)values("+"'"+userID+"','"+labValue+ "')";
		int result = statement.executeUpdate(sql);
		closeDB();
		return result;
		
		
	}
}
