package org.dteam.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import org.junit.After;
import org.junit.Test;

public class A1cDAOTest {

	DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	A1cDAO a1cDAO = mysqlFactory.getA1cDAO();

	@Test
	public void testAddLabValueShouldReturn1() throws SQLException {
		int labValue = a1cDAO.addLabValue(4.6, "1");
		assertEquals(1, a1cDAO.addLabValue(labValue, "1"));
	}

	@Test
	public void testGetLabValue() throws SQLException {
		double expectedLabValue = 4.6;
		assertEquals(expectedLabValue, a1cDAO.getLabValue("1"), 0);
	}

	@After
	public void tearDown() throws SQLException {
		MySQLDAOFactory.connectToDB();
		MySQLDAOFactory.statement.executeUpdate("Delete from a1c Where UserID = '1'");
		MySQLDAOFactory.closeDB();

	}
}
