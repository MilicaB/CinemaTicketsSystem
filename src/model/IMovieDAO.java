package model;

import java.sql.SQLException;

import pojo.Movie;

public interface IMovieDAO {

	void addMovie(Movie movie) throws SQLException;

	void removeMovie(String movie) throws SQLException;

	Movie getMovieByName(String movie) throws SQLException;

}