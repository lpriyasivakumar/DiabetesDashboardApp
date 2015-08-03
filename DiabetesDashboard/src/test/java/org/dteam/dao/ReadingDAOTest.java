package org.dteam.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.dteam.model.Reading;
import org.junit.Test;

public class ReadingDAOTest {
	
	DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ReadingDAO readingDAO = mysqlFactory.getReadingDAO();

	@Test
	public void testAddValidReadingShouldreturn1() {
		Reading reading = new Reading();
		reading.setDate("2015-04-15");
		reading.setBloodGlucose(175);
		reading.setInsulin(25);
		reading.setTimeOfDay("1");
		assertEquals(1,readingDAO.addReading(reading, "20"));
	}
	
	@Test
	public void testAddUserWithInvalidUserShouldreturn0() {
		Reading reading = new Reading();		
		assertEquals(0,readingDAO.addReading(reading,"2"));
	}
	
	@Test
	public void testgetReadingsWithInValidUserIDShouldreturnEmptyList() {
		ArrayList<Reading> readings = new ArrayList<Reading>();
		assertEquals(readings,readingDAO.getReadings("weekly", "One"));
	}
	
	
	@Test
	public void testgetReadingsWithValidUserIDShouldReturnTwoELements() {		
		assertEquals(2,(readingDAO.getReadings("weekly", "106025413030436687338")).size());
	}

}
