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

public class CommentManager {
	DataSource ds;
	public CommentManager()
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
	
	
	// create a comment
		public Comment createComment(Comment comment)
		{
			String sql = "insert into comment values (null,?,?,?,?)";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, comment.getComment());
				statement.setDate(2, (Date) comment.getDate());
				statement.setString(3, comment.getUserName());
				statement.setInt(4, comment.getMovieID());
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		// retrieve all comments
		public List<Comment> readAllComments()
		{
			List<Comment> commentList = new ArrayList<Comment>();
			String sql = "select * from comment";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				ResultSet results = statement.executeQuery();
				while(results.next())
				{
					Comment comment = new Comment();
					comment.setComment(results.getString("comment"));
					comment.setUserName(results.getString("userName"));
					comment.setCommentID(results.getInt("commentID"));
					comment.setDate((Date) results.getDate("date"));
					comment.setMovieID(results.getInt("movieID"));					
					commentList.add(comment);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return commentList;
		}
		
	// retrieve all comments for specific user
	public List<Comment> readAllCommentsForUsername(String username)
		{
			List<Comment> commentList = new ArrayList<Comment>();
			String sql = "select * from comment where username=?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setString(1, username);
				ResultSet results = statement.executeQuery();
				while(results.next())
				{
					Comment comment = new Comment();
					comment.setComment(results.getString("comment"));
					comment.setUserName(results.getString("userName"));
					comment.setCommentID(results.getInt("commentID"));
					comment.setDate((Date) results.getDate("date"));
					comment.setMovieID(results.getInt("movieID"));					
					commentList.add(comment);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return commentList;
		}

	
	// retrieve all comments for specific movie
	public List<Comment> readAllCommentsForMovie(int movieId)
		{
			List<Comment> commentList = new ArrayList<Comment>();
			String sql = "select * from comment where movieID=?";
			try {
				Connection connection = ds.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setInt(1, movieId);
				ResultSet results = statement.executeQuery();
				while(results.next())
				{
					Comment comment = new Comment();
					comment.setComment(results.getString("comment"));
					comment.setUserName(results.getString("userName"));
					comment.setCommentID(results.getInt("commentID"));
					comment.setDate((Date) results.getDate("date"));
					comment.setMovieID(results.getInt("movieID"));					
					commentList.add(comment);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return commentList;
		}

	
	// retrieve a comment by commentid
	public Comment readCommentForId(int commentId)
	{
		Comment comment = new Comment();
		
		String sql = "select * from comment where commentId = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, commentId);
			ResultSet result = statement.executeQuery();
			if(result.next())
			{					
				comment.setComment(result.getString("comment"));
				comment.setUserName(result.getString("userName"));
				comment.setCommentID(result.getInt("commentID"));
				comment.setDate((Date) result.getDate("date"));
				comment.setMovieID(result.getInt("movieID"));
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return comment;
	}
	
	
	// update a comment by commentId
	public Comment updateComment(int commentId, Comment comment)
	{
		String sql = "update comment set comment=?, date=?, movieId=?, userName=? where commentID=?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, comment.getComment());
			statement.setDate(2, (Date) comment.getDate());						
			statement.setInt(3, comment.getMovieID());
			statement.setString(4, comment.getUserName());
			statement.setInt(5, commentId);			
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return comment;
	}
	
	// delete a comment by commentId
		public int deleteComment(int id)
		{
			String sql = "delete from comment where commentid=?";
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
