package org.dteam.dao;

//import java.sql.Date;
import java.sql.*;

import java.util.ArrayList;
import org.dteam.model.Reading;
import static org.dteam.dao.MySQLDAOFactory.*;

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
	public ArrayList<Reading> getReadings() {
		connectToDB();
		ArrayList<Reading> ReadingList = new ArrayList<Reading>();
		try {
			String sql = "SELECT * FROM Reading WHERE ReadingDate BETWEEN DATE_SUB(CURDATE(), INTERVAL 30 DAY) and CURDATE();";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Reading reading = new Reading();
				reading.setDate(rs.getDate("ReadingDate"));
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

	
}
