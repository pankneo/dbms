package moviepedia.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import moviepedia.model.*;
public class UserManager {
DataSource ds;
	
	public UserManager()
	{
	  try {
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MovieDB");
		System.out.println(ds);
	  } catch (NamingException e) {
		  System.out.println("Code Reached==============");
		e.printStackTrace();
	  }
	}
	
	
	// create a user
	public User createUser(User user)
	{
		String sql = "insert into user values (?,?,?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(3, user.getFirstName());
			statement.setString(4, user.getLastName());
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.setString(5, user.getEmail());
			statement.setDate(6, (Date) user.getDob());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// retrieve all users
	public List<User> readAllUsers()
	{
		List<User> userList = new ArrayList<User>();
		String sql = "select * from user";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				User user = new User();				
				user.setFirstName(results.getString("firstName"));
				user.setLastName(results.getString("lastName"));
				user.setUserName(results.getString("username"));
				user.setPassword(results.getString("password"));
				user.setEmail(results.getString("email"));
				user.setDob(results.getDate("dateOfBirth"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	// retrieve a user by username
	public User readUser(String username)
	{
		User user = new User();
		
		String sql = "select * from user where userName = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{
				
				user.setEmail(result.getString("email"));
				user.setFirstName(result.getString("firstName"));
				user.setLastName(result.getString("lastName"));
				user.setUserName(result.getString("username"));
				user.setPassword(result.getString("password"));
				user.setDob(result.getDate("dateOfBirth"));
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return user;
	}
	// update a user by username
	public User updateUser(String username, User user)
	{
		String sql = "update user set firstName=?, lastName=?, password=?, email=?, dateOfBirth=? where userName=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());			
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getEmail());
			statement.setDate(5, (Date) user.getDob());
			statement.setString(6, user.getUserName());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return user;
	}
	// delete a user by username
	public int deleteUser(String username)
	{
		String sql = "delete from user where username=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
