package org.dteam.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import org.dteam.model.Reading;
import static org.dteam.dao.MySQLDAOFactory.*;

public class MySQLReadingDAO implements ReadingDAO {			
		
	@Override
	public int addReading(Reading reading) {
		connectToDB();
		try {
			statement = conn.createStatement();
			//String sql = "Insert into bgreading values ('"+bgReading.getBloodGlucose()+"');";
			//return statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
		return 0;
	}

	@Override
	public ArrayList<Reading> getReadings(Date startDt, Date endDt) {
		connectToDB();
//		ArrayList<int>
//		try {
//			statement = conn.createStatement();
//			String sql = "Select * from bgreading ="+
//		}
		closeDB();
		return null;
	}
}
