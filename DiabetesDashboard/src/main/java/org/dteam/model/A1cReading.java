package org.dteam.model;

import java.io.Serializable;

public class A1cReading implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double labA1c;
	
	public A1cReading() {}

	public double getLabA1c() {
		return labA1c;
	}

	public void setLabA1c(double labA1c) {
		this.labA1c = labA1c;
	}
}
