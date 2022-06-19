package com.raju.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.raju.pojos.User;

public class UserDao {
	
	public boolean checkCredentials(User user)
	{
		try {
			Statement statement = Database.getConnection().createStatement();
			String query = String.format("select * from admin_details where username='%s' and password='%s'", user.getUsername(),user.getPassword());
			ResultSet result = statement.executeQuery(query);
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
