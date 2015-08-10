package org.dteam.dao;

import java.sql.SQLException;

import org.dteam.model.User;

public interface UserDAO {
	public int addUser(User user) throws SQLException;

	public boolean findUser(String userID) throws SQLException;

}
