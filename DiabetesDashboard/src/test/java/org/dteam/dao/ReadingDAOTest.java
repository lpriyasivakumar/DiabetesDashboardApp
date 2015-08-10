package org.dteam.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.dteam.model.Reading;
import org.junit.After;
import org.junit.Test;

public class ReadingDAOTest {

	DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	ReadingDAO readingDAO = mysqlFactory.getReadingDAO();

	@Test
	public void testAddValidReadingShouldreturn1() throws SQLException {
		Reading reading = new Reading();
		reading.setDate("2015-04-15");
		reading.setBloodGlucose(175);
		reading.setInsulin(25);
		reading.setTimeOfDay("1");
		assertEquals(1, readingDAO.addReading(reading, "104821667003922512716"));
	}

	@Test (expected = RuntimeException.class)
	public void testAddInvalidReadingShouldthrowException() throws SQLException {
		Reading reading = null;		
		assertEquals(0, readingDAO.addReading(reading, "104821667003922512716"));
	}

	@Test
	public void testgetReadingsWithInValidUserIDShouldreturnEmptyList() throws SQLException {
		ArrayList<Reading> readings = new ArrayList<Reading>();
		assertEquals(readings, readingDAO.getReadings("weekly", "One"));
	}	

	@After
	public void tearDown() throws SQLException {
		MySQLDAOFactory.connectToDB();
		MySQLDAOFactory.statement
				.executeUpdate("Delete from reading Where ReadingDate = '2015-04-15' And UserID = '104821667003922512716' And BloodGlucose='175'");
		MySQLDAOFactory.closeDB();
	}

}
