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
public class CastManager {
	DataSource ds;
	public CastManager()
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
	
	// create a cast
	public Cast createCast(Cast cast)
	{
		String sql = "insert into cast values (null,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);			
			statement.setInt(1, cast.getMovieID());	
			statement.setInt(2, cast.getActorID());
			statement.setString(3, cast.getCharacterName());					
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// retrieve all casts
	public List<Cast> readAllCast()
	{
		List<Cast> castList = new ArrayList<Cast>();
		String sql = "select * from cast";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				Cast cast = new Cast();
				cast.setCharacterName(results.getString("characterName"));
				cast.setActorID(results.getInt("actorID"));
				cast.setMovieID(results.getInt("movieID"));				
				castList.add(cast);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return castList;
	}
	
	// retrieve all casts for specific actor
		public List<Cast> readAllCastForActor(int actorID)
			{
				List<Cast> castList = new ArrayList<Cast>();
				String sql = "select * from cast where actorID=?";
				try {
					Connection connection = ds.getConnection();
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setInt(1, actorID);
					ResultSet results = statement.executeQuery();
					while(results.next())
					{
						Cast cast = new Cast();
						cast.setCharacterName(results.getString("characterName"));
						cast.setActorID(results.getInt("actorID"));
						cast.setMovieID(results.getInt("movieID"));						
						castList.add(cast);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return castList;
			}

		
		// retrieve all cast for specific movie
		public List<Cast> readAllCastForMovie(int movieId)
			{
				List<Cast> castList = new ArrayList<Cast>();
				String sql = "select * from cast where movieID=?";
				try {
					Connection connection = ds.getConnection();
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setInt(1, movieId);
					ResultSet results = statement.executeQuery();
					while(results.next())
					{
						Cast cast = new Cast();						
						cast.setCharacterName(results.getString("characterName"));
						cast.setActorID(results.getInt("actorID"));
						cast.setMovieID(results.getInt("movieID"));
						castList.add(cast);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return castList;
			}

		
		// retrieve a cast by id
		public Cast readCastForId(int castId)
		{
			Cast cast = new Cast();
			
			String sql = "select * from cast where castId = ?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, castId);
				ResultSet result = statement.executeQuery();
				if(result.next())
				{							
					cast.setCharacterName(result.getString("characterName"));
					cast.setActorID(result.getInt("actorID"));
					cast.setMovieID(result.getInt("movieID"));
				}			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return cast;
		}
		
		
		// update a cast by castId
		public Cast updateCast(int castId, Cast cast)
		{
			String sql = "update cast set movieID=?, actorID=?, charactername=? where castID=?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, cast.getMovieID());
				statement.setInt(2, cast.getActorID());
				statement.setString(3, cast.getCharacterName());
				statement.setInt(4, castId);							
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return cast;
		}
		
		// delete a cast by castID
			public int deleteCast(int castID)
			{
				String sql = "delete from cast where castid=?";
				try {
					Connection connection = ds.getConnection();
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setInt(1, castID);
					return statement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0;
			}

}
