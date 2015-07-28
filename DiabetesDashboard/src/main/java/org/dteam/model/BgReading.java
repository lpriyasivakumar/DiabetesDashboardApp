package org.dteam.model;

import java.io.Serializable;
import java.util.Date;

public class BgReading implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private String timeOfDay;
	private int bloodGlucose;
		
	public BgReading() {}
		
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTimeOfDay() {
		return timeOfDay;
	}
	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}
	public int getBloodGlucose() {
		return bloodGlucose;
	}
	public void setBloodGlucose(int bloodGlucose) {
		this.bloodGlucose = bloodGlucose;
	}

}
