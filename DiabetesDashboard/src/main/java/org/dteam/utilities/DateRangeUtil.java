package org.dteam.utilities;

public class DateRangeUtil {

	public static String getDateRange(String dateRange) {
		if(dateRange.equals("weekly")) {
			return "7";
		}
		else if (dateRange.equals("monthly")) {
			return "30";
		}
		return null;
	}
}
