package org.dteam.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.dteam.model.Reading;

public interface ReadingDAO {
	public int addReading(Reading reading, String userID) throws SQLException;

	public ArrayList<Reading> getReadings(String dateRange, String userID) throws SQLException;

}
