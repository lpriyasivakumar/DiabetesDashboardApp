package org.dteam.model;

import java.io.Serializable;


public class Reading implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String date;
	private String timeOfDay;
	private int bloodGlucose;
	private int insulin;
		
	public Reading() {}
		
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
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

	public int getInsulin() {
		return insulin;
	}

	public void setInsulin(int insulin) {
		this.insulin = insulin;
	}

}
