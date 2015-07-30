package org.dteam.dao;

import org.dteam.model.User;

public interface UserDAO {
	public int addUser(User user); 
	public boolean findUser(String userID);

}
