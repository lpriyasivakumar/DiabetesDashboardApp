package org.dteam.dao;

import java.sql.*;

import java.util.ArrayList;
import org.dteam.model.Reading;
import static org.dteam.dao.MySQLDAOFactory.*;
import static org.dteam.utilities.DateRangeUtil.*;

public  class MySQLReadingDAO implements ReadingDAO {

	@Override
	public int addReading(Reading reading,String userID) {
		connectToDB();
		try {
			String sql = "Insert into reading(UserID, ReadingDate, TimeOfDayID, BloodGlucose,InsulinUnits) values ('"+userID+ "','" +reading.getDate()+"','"+reading.getTimeOfDay()+"','"
					+ reading.getBloodGlucose()+"','"+reading.getInsulin()+"');";
			return statement.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
		return 0;
	}

	@Override
	public ArrayList<Reading> getReadings(String dateRange,String userID) {
		connectToDB();
		ArrayList<Reading> ReadingList = new ArrayList<Reading>();
		try {
			String sql = "SELECT * FROM Reading WHERE ReadingDate BETWEEN DATE_SUB(CURDATE(), INTERVAL " +getDateRange(dateRange) + " DAY) and CURDATE() AND UserID="+"'"+userID+"'";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Reading reading = new Reading();
				reading.setDate(rs.getDate("ReadingDate").toString());
				reading.setInsulin(rs.getInt("InsulinUnits"));
				reading.setBloodGlucose(rs.getInt("BloodGlucose"));
				reading.setTimeOfDay(rs.getString("TimeOfDayID"));
				ReadingList.add(reading);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();

		return ReadingList;
	}
	
	public static int getAvgBG(String userID) {
		connectToDB();
		try{
			String sql = "SELECT AVG(BloodGlucose) AS BG_AVG FROM Reading WHERE ReadingDate BETWEEN DATE_SUB(CURDATE(), INTERVAL 90 DAY) and CURDATE() AND GROUP BY ReadingDate AND userID = "+"'"+userID+"';";
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