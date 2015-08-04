package org.dteam.dao;

import java.util.ArrayList;

import org.dteam.model.A1cReading;
import org.dteam.model.Reading;

public interface A1cDAO {	
	public int addLabValue(double labValue, String userID);
	public A1cReading getLabValue(String userID);
	//public 
}
