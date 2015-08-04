package org.dteam.dao;

import org.dteam.model.A1cReading;

public interface A1cDAO {	
	public int addLabValue(double labValue, String userID);
	public A1cReading getLabValue(String userID);
}
