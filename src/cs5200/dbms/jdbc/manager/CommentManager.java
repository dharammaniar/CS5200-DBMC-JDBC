package cs5200.dbms.jdbc.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import cs5200.dbms.jdbc.entity.Comment;

public class CommentManager {

	DataSource ds;
	
	public CommentManager() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/CS5200_JDBC_DB");
			System.out.println(ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void createComment(Comment newComment) {
		String sql = "insert into comment (comment, date, username, movieId) values (?,?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newComment.getComment());
			statement.setDate(2, newComment.getDate());
			statement.setString(3, newComment.getUsername());
			statement.setInt(4, newComment.getMovieId());
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Comment> readAllComments() {
		List<Comment> allComments = new ArrayList<Comment>();
		String sql = "select * from comment";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Comment comment = new Comment();
				comment.setCommentId(results.getInt("commentId"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				comment.setUsername(results.getString("username"));
				comment.setMovieId(results.getInt("movieId"));
				allComments.add(comment);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return allComments;
	}
	
	public List<Comment> readAllCommentsForUsername(String username) {
		List<Comment> allComments = new ArrayList<Comment>();
		String sql = "select * from comment where username = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Comment comment = new Comment();
				comment.setCommentId(results.getInt("commentId"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				comment.setUsername(results.getString("username"));
				comment.setMovieId(results.getInt("movieId"));
				allComments.add(comment);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return allComments;
	}
	
	public List<Comment> readAllCommentsForMovie(int movieId) {
		List<Comment> allComments = new ArrayList<Comment>();
		String sql = "select * from comment where movieId = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, movieId);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Comment comment = new Comment();
				comment.setCommentId(results.getInt("commentId"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				comment.setUsername(results.getString("username"));
				comment.setMovieId(results.getInt("movieId"));
				allComments.add(comment);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return allComments;
	}
	
	public Comment readCommentForId(int commentId) {
		Comment comment = new Comment();
		String sql = "select * from comment where commentId = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, commentId);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				comment.setCommentId(results.getInt("commentId"));
				comment.setComment(results.getString("comment"));
				comment.setDate(results.getDate("date"));
				comment.setUsername(results.getString("username"));
				comment.setMovieId(results.getInt("movieId"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return comment;
	}
	
	public void updateComment(int commentId, Comment newComment) {
		String sql = "update comment set comment = ?, date = ?, username = ?, movieId = ? where commentId = ? ";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newComment.getComment());
			statement.setDate(2, newComment.getDate());
			statement.setString(3, newComment.getUsername());
			statement.setInt(4, newComment.getMovieId());
			statement.setInt(5, commentId);
			statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteComment(int commentId) {
		String sql = "delete from comment where commentId = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, commentId);
			statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
