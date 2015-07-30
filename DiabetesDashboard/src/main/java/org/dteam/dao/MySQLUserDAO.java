package org.dteam.dao;

import org.dteam.model.User;
import java.sql.*;
import static org.dteam.dao.MySQLDAOFactory.*;

public class MySQLUserDAO  implements UserDAO {	

	@Override
	public  int addUser(User user) {
		connectToDB();
		try {
			
			String sql = "Insert into userdb values('" + user.getUserID() + "','" + user.getName() + "');";
			return statement.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return 0;
	}

	@Override
	public boolean findUser(String userID) {
		connectToDB();
		try {
			statement = conn.createStatement();
			String sql = "Select * from userdb where UserID =" + "'" + userID + "'";
			ResultSet rs = statement.executeQuery(sql);
			return rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}

}
