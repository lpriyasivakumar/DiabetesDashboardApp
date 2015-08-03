package org.dteam.dao;

import static org.junit.Assert.*;

import org.dteam.model.User;
import org.junit.Test;

public class UserDAOTest {
	
	DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	UserDAO userDAO = mysqlFactory.getUserDAO();

	@Test
	public void testAddUserWithValidUser() {
		User user = new User();
		user.setUserID("20");
		user.setName("Jane Doe");
		assertEquals(1,userDAO.addUser(user));
	}
	
	@Test(expected = Exception.class)
	public void testAddUserWithInvalidUser() {
		userDAO.addUser(null);
	}

	@Test
	public void testFindUserWithValidUserID() {
		assertEquals(true,userDAO.findUser("1"));
	}
	@Test
	public void testFindUserWithInValidUserID() {
		assertEquals(false,userDAO.findUser("One"));
	}


}
