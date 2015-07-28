package org.dteam.dao;
import org.dteam.model.BgReading;
import java.sql.*;
import java.util.ArrayList;

public class BloodGlucoseDAOMySql extends MySqlDBConnection implements BloodGlucoseDAO  {
	public Statement statement;
	@Override
	public int addBgReading(BgReading bgReading) {
		connectToDB();
		try {
			statement = conn.createStatement();
			//String sql = "Insert into bgreading values ('"+bgReading.getBloodGlucose()+"');";
			//return statement.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(statement == null) {
					conn.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	@Override
	public ArrayList<BgReading> getReadings() {
		connectToDB();
//		ArrayList<int>
//		try {
//			statement = conn.createStatement();
//			String sql = "Select * from bgreading ="+
//		}
		return null;
	}
}