package model;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import pojo.Hall;
import pojo.Movie;

public class MovieDAO extends AbstractDAO{
	

	private static final String SELECT_MOVIE_BY_NAME = "SELECT * FROM film-show WHERE film_name = ?";
	private static final String DELETE_MOVIE_BY_NAME = "DELETE FROM film-show WHERE film_name = ?";
	private static final String ADD_MOVIE_QUERY = "INSERT INTO film-show VALUES (?, ?,?,?,?,?)";

	public void addMovie(Movie movie)  throws SQLException {
		
				PreparedStatement ps = getCon().prepareStatement(ADD_MOVIE_QUERY);
				ps.setString(1, movie.getMovieName());
				ps.setString(2,movie.getHallName());
				ps.setDate(3, movie.getDate());
				ps.setInt(4, movie.getDuration());
				ps.setString(5, movie.getDescription());
				ps.setString(6, movie.getImagePath());
		
				ps.executeUpdate();
		
	}

	public void removeMovie(String movie) throws SQLException  {

		
			PreparedStatement ps = getCon().prepareStatement(DELETE_MOVIE_BY_NAME);
			ps.setString(1, movie);
			ps.executeUpdate();
		
	}

	public Movie getMovieByName(String movie)  throws SQLException {

		
			PreparedStatement ps = getCon().prepareStatement(SELECT_MOVIE_BY_NAME);
			ps.setString(1, movie);
			ResultSet result = ps.executeQuery();
			result.next();
			String name = result.getString(1);
			String hall=result.getString(2);
			Date date=result.getDate(3);
			int duration=result.getInt(4);
			String description=result.getString(5);
			String path=result.getString(6);
			
			return new Movie(name, hall, date, duration, description, path);

		
	}

}



