package org.dteam.dao;

import static org.junit.Assert.*;

import org.dteam.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UserDAOTest {
	
	
	UserDAO userDao;
	
	@Before
	public void setup(){
		userDao = Mockito.mock(UserDAO.class);
		User user = new User();
		user.setUserID("30");
		user.setName("Jane Doe");
		
		 
		Mockito.when(userDao.addUser(null)).thenThrow(RuntimeException.class);
		
		Mockito.when(userDao.findUser("1")).thenReturn(true);
		Mockito.when(userDao.findUser("One")).thenReturn(false);
	}
	
	@Test
	public void testAddUserWithValidUser() {
		User user = new User();
		user.setUserID("30");
		user.setName("Jane Doe");
		Mockito.when(userDao.addUser(user)).thenReturn(1);
		assertEquals(1,userDao.addUser(user));
	}
	
	@Test(expected = Exception.class)
	public void testAddUserWithInvalidUser() {
		userDao.addUser(null);
	}

	@Test
	public void testFindUserWithValidUserID() {
		assertEquals(true,userDao.findUser("1"));
	}
	@Test
	public void testFindUserWithInValidUserID() {
		assertEquals(false,userDao.findUser("One"));
	}


}
