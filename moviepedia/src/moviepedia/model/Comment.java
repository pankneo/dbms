package moviepedia.model;

import java.util.Date;

public class Comment {
	String comment;
	Date date;
	int commentID;
	int movieID;
	String userName;
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public int getMovieID() {
		return movieID;
	}
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Comment(String comment, Date date, int commentID, int movieID,
			String userName) {
		super();
		this.comment = comment;
		this.date = date;
		this.commentID = commentID;
		this.movieID = movieID;
		this.userName = userName;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

}
