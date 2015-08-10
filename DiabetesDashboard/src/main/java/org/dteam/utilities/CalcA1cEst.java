package org.dteam.utilities;

import static org.dteam.dao.MySQLReadingDAO.*;

import java.sql.SQLException;

public class CalcA1cEst {

	// for derivation of constants, see article "Translating the A1C Assay Into
	// Estimated Average Glucose Values" @:
	// http://care.diabetesjournals.org/content/31/8/1473.full.pdf
	static final double CONSTANT_1 = 46.7;
	static final double CONSTANT_2 = 28.7;

	public static double getCalcA1cEstimate(String userID) {

		int AvgBG = 0;
		try {
			AvgBG = getAvgBG(userID);
			double calcA1cEst = (AvgBG + CONSTANT_1) / CONSTANT_2;
			return calcA1cEst;
		} catch (SQLException e) {
			System.out.println("Error fetching A1c value");
		}
		return AvgBG;
		
	}

}