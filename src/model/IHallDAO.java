package model;

import java.sql.SQLException;

import pojo.Hall;

public interface IHallDAO {

	void addHall(Hall hall) throws SQLException;

	void removeHall(String hall) throws SQLException;

	Hall getHallByName(String hall) throws SQLException;

}