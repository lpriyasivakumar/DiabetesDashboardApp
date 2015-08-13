package org.dteam.dao;

import java.sql.SQLException;

public interface A1cDAO {
	public int addLabValue(double labValue, String userID) throws SQLException;

	public double getLabValue(String userID) throws SQLException;
}