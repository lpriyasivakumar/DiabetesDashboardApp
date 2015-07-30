package org.dteam.dao;

import java.util.ArrayList;

import org.dteam.model.BgReading;

public interface BloodGlucoseDAO {
	public int addBgReading(BgReading bgReading);
	public ArrayList<BgReading> getReadings();

}
