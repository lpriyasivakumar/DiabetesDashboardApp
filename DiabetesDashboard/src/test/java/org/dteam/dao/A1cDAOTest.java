package org.dteam.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import org.junit.After;
import org.junit.Test;

public class A1cDAOTest {

	DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	A1cDAO a1cDAO = mysqlFactory.getA1cDAO();
	
	@Test
	public void testAddLabValueAndGetLabValue() throws SQLException {		
		assertEquals(1, a1cDAO.addLabValue(4.6, "104821667003922512716"));
		assertEquals(4.6, a1cDAO.getLabValue("104821667003922512716"),0);
	}	

	@After
	public void tearDown() throws SQLException {
		MySQLDAOFactory.connectToDB();
		MySQLDAOFactory.statement.executeUpdate("Update a1c Set LabValue='0' Where UserID = '104821667003922512716'");
		MySQLDAOFactory.closeDB();

	}

}