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

import cs5200.dbms.jdbc.entity.Cast;

public class CastManager {

	DataSource ds;
	
	public CastManager() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/CS5200_JDBC_DB");
			System.out.println(ds);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void createCast(Cast newCast) {
		String sql = "insert into cast (characterName, movieId, actorId) values (?,?,?)";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newCast.getCharacterName());
			statement.setInt(2, newCast.getMovieId());
			statement.setInt(3, newCast.getActorId());
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cast> readAllCast() {
		List<Cast> allCast = new ArrayList<Cast>();
		String sql = "select * from cast";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Cast cast = new Cast();
				cast.setCastId(results.getInt("castId"));
				cast.setCharacterName(results.getString("characterName"));
				cast.setMovieId(results.getInt("movieId"));
				cast.setActorId(results.getInt("actorId"));
				allCast.add(cast);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return allCast;
	}
	
	public List<Cast> readAllCastForActor(int actorId) {
		List<Cast> allCast = new ArrayList<Cast>();
		String sql = "select * from cast where actorId = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, actorId);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Cast cast = new Cast();
				cast.setCastId(results.getInt("castId"));
				cast.setCharacterName(results.getString("characterName"));
				cast.setMovieId(results.getInt("movieId"));
				cast.setActorId(results.getInt("actorId"));
				allCast.add(cast);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return allCast;
	}
	
	public List<Cast> readAllCastForMovie(int movieId) {
		List<Cast> allCast = new ArrayList<Cast>();
		String sql = "select * from cast where movieId = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, movieId);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				Cast cast = new Cast();
				cast.setCastId(results.getInt("castId"));
				cast.setCharacterName(results.getString("characterName"));
				cast.setMovieId(results.getInt("movieId"));
				cast.setActorId(results.getInt("actorId"));
				allCast.add(cast);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return allCast;
	}
	
	public Cast readCastForId(int castId) {
		Cast cast = new Cast();
		String sql = "select * from cast where castId = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, castId);
			ResultSet results = statement.executeQuery();
			while(results.next()) {
				cast.setCastId(results.getInt("castId"));
				cast.setCharacterName(results.getString("characterName"));
				cast.setMovieId(results.getInt("movieId"));
				cast.setActorId(results.getInt("actorId"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cast;
	}
	
	public void updateCast(int castId, Cast newCast) {
		String sql = "update cast set characterName = ?, movieId = ?, actorId = ? where castId = ? ";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newCast.getCharacterName());
			statement.setInt(2, newCast.getMovieId());
			statement.setInt(3, newCast.getActorId());
			statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCast(int castId) {
		String sql = "delete from cast where castId = ?";
		try {
			Connection connection = ds.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, castId);
			statement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
