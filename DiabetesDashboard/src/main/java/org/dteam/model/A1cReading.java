package org.dteam.model;

import java.io.Serializable;
import java.util.Date;

public class A1cReading implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date date;
	private double labA1c;
	private double avgA1c;
	
	public A1cReading() {}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getLabA1c() {
		return labA1c;
	}

	public void setLabA1c(double labA1c) {
		this.labA1c = labA1c;
	}

	public double getAvgA1c() {
		return avgA1c;
	}

	public void setAvgA1c(double avgA1c) {
		this.avgA1c = avgA1c;
	}
	
	
	

}
