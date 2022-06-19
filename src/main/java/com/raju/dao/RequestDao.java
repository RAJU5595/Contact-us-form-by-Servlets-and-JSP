package com.raju.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.raju.pojos.Request;

public class RequestDao {
	
	public boolean saveRequest(Request request) 
	{
		String query = String.format("insert into requests (name,email,message,is_active) values('%s','%s','%s','%s')", request.getName(),request.getEmail(),request.getMessage(),request.getIsActive());
		
		try {
			Statement statement = Database.getConnection().createStatement();
			return statement.executeUpdate(query)>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<Request> getActiveRequests()
	{
		List <Request> activeRequests = new ArrayList<>();
		String query = "select * from requests where is_active=true";
		Statement statement;
		
		try {
			statement = Database.getConnection().createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				Request request = new Request();
				request.setId(result.getInt("id"));
				request.setName(result.getString("name"));
				request.setEmail(result.getString("email"));
				request.setMessage(result.getString("message"));
				request.setIsActive(result.getBoolean("is_active"));
				request.setDate(result.getString("created_at"));
				
				activeRequests.add(request);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return activeRequests;
	}
	
	public List<Request> getArchiveRequests()
	{
		List <Request> acrhiveRequests = new ArrayList<>();
		String query = "select * from requests where is_active=false";
		Statement statement;
		
		try {
			statement = Database.getConnection().createStatement();
			ResultSet result = statement.executeQuery(query);
			
			while(result.next()) {
				Request request = new Request();
				request.setId(result.getInt("id"));
				request.setName(result.getString("name"));
				request.setEmail(result.getString("email"));
				request.setMessage(result.getString("message"));
				request.setIsActive(result.getBoolean("is_active"));
				request.setDate(result.getString("created_at"));
			
				acrhiveRequests.add(request);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return acrhiveRequests;
	}
	
	public boolean updateStatusOfRequest(int id) {
		String query = String.format("update requests set is_active=false where id=%s",id);
		Statement statement;
		
		try {
			statement = Database.getConnection().createStatement();
			ResultSet result = statement.executeQuery(query);
			return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
