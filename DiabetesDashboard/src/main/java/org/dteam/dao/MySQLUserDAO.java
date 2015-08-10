package org.dteam.dao;

import org.dteam.model.User;
import java.sql.*;
import static org.dteam.dao.MySQLDAOFactory.*;

public class MySQLUserDAO implements UserDAO {

	@Override
	public int addUser(User user) throws SQLException {
		connectToDB();
		String sql = "Insert into UserDB(UserID,UserName) values('"
				+ user.getUserID() + "','" + user.getName() + "');";
		int result = statement.executeUpdate(sql);
		closeDB();
		return result;

	}

	@Override
	public boolean findUser(String userID) throws SQLException {
		connectToDB();
		String sql = "Select * from UserDB where UserID =" + "'" + userID + "'";
		ResultSet rs = statement.executeQuery(sql);
		boolean found = rs.next();
		closeDB();
		return found;

	}

}