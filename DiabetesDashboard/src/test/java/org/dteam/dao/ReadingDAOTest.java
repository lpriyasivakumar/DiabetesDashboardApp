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
	public void testAddValidReadingShouldreturn1() {
		Reading reading = new Reading();
		reading.setDate("2015-04-15");
		reading.setBloodGlucose(175);
		reading.setInsulin(25);
		reading.setTimeOfDay("1");
		assertEquals(1,readingDAO.addReading(reading, "1"));
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
		assertEquals(5,(readingDAO.getReadings("weekly", "106025413030436687338")).size());
	}
	
	@After
    public void tearDown() throws SQLException {
        MySQLDAOFactory.connectToDB();
        MySQLDAOFactory.statement.executeUpdate("Delete from reading Where ReadingDate = '2015-04-15' And UserID = '1'");
        MySQLDAOFactory.closeDB();
    }

}
