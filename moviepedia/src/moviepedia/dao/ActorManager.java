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

public class ActorManager {
	DataSource ds;
	public ActorManager(){
	try {
		Context ctx = new InitialContext();
		ds = (DataSource)ctx.lookup("java:comp/env/jdbc/MovieDB");
		System.out.println(ds);
	  } catch (NamingException e) {
		  System.out.println("Code Reached==============");
		e.printStackTrace();
	  }
	}
	
	// create a actor
		public Actor createActor(Actor actor)
		{
			String sql = "insert into actor values (null,?,?,?)";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, actor.getFirstName());
				statement.setString(2, actor.getLastName());
				statement.setDate(3, (Date) actor.getDateOfBirth());
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		// retrieve all actors
		public List<Actor> readAllActors()
		{
			List<Actor> actorList = new ArrayList<Actor>();
			String sql = "select * from actor";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while(results.next())
				{
					Actor actor = new Actor();				
					actor.setFirstName(results.getString("firstName"));
					actor.setLastName(results.getString("lastName"));					
					actor.setDateOfBirth(results.getDate("dateOfBirth"));
					actorList.add(actor);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return actorList;
		}
		// retrieve a actor by actorid
		public Actor readActor(int id)
		{
			Actor actor = new Actor();
			
			String sql = "select * from actor where id = ?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, id);
				ResultSet result = statement.executeQuery();
				if(result.next())
				{	
					actor.setFirstName(result.getString("firstName"));
					actor.setLastName(result.getString("lastName"));					
					actor.setDateOfBirth((Date)result.getDate("dateOfBirth"));
				}			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return actor;
		}
		// update a actor by actorid
		public Actor updateActor(int id, Actor actor)
		{
			String sql = "update actor set firstName=?, lastName=?,dateOfBirth=? where id=?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(4,id);
				statement.setString(1,actor.getFirstName());
				statement.setString(2, actor.getLastName());
				statement.setDate(3, (Date) actor.getDateOfBirth());
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return actor;
		}
		// delete a actor by id
		public int deleteActor(int id)
		{
			String sql = "delete from actor where id=?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, id);
				return statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}

}
